package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;

@Component("fileDownView")
public class FileDownView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FileDownView");
		BoardFileDTO  boardFileDTO = (BoardFileDTO) model.get("boardFile");
		
//		Iterator<String> it =  model.keySet().iterator();
//		
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println("Key: "+key);
//		}
		
		// Key: boardName, boardFile (boardFileDTO도 매개변수로 ModelAndView로 받아오지만 filenum 데이터만 존재하기 때문에 불필요)
		
		//경로 준비
		String path = (String)model.get("boardName");
		path = "resources/upload/"+path+"/";
		path = request.getSession().getServletContext().getRealPath(path);
		
		File file = new File(path,boardFileDTO.getFileName());
		
		//응답 시 한글 Encoding 처리
		response.setCharacterEncoding("UTF-8");
		
		//응답 시 파일의 크기 전송
		response.setContentLength((int)file.length());
		
		//파일 다운 시에 파일의 이름을 지정하고, 인코딩 설정 (한글임을 대비)
		String downName = boardFileDTO.getOriName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		//자원 해제 -> 역순
		os.close();
		fi.close();
	}
}
