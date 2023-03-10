package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	/*
	 * @Test public void getBankBookListTest() throws Exception { List<BankBookDTO>
	 * ar = bankBookDAO.getBankBookList(); assertNotEquals(0, ar.size()); }
	 */
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(1L);
		
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
//	
//	//@Test
//	public void setBankBookAddTest() throws Exception{
//		int a = 0;
//		for(int i=0;i<30;i++) {
//			Random r = new Random();
//			double d = r.nextDouble(); //0.1234
//			int num = (int)(d * 1000); //123
//			d = num / 100.0;
//			BankBookDTO bankBookDTO = new BankBookDTO();
//			bankBookDTO.setBookName("농협적금-"+num);
//			bankBookDTO.setBookRate(d);
//			bankBookDTO.setBookDetail("book");
//			bankBookDTO.setBookSale(1);
//			a = bankBookDAO.setBankBookAdd(bankBookDTO);
//			assertEquals(1, a);
//		}
//	}
//	
//	//@Test
//	public void setBankBookDeleteTest() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNum(59L);
//		int a = bankBookDAO.setBankBookDelete(bankBookDTO);
//		assertEquals(1, a);
//	}
//	//@Test
//	public void setBankBookUpdateTest() throws Exception{
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNum(1L);
//		bankBookDTO.setBookName("나라사랑");
//		bankBookDTO.setBookDetail("나라사랑통장????");
//		bankBookDTO.setBookRate(2.0);
//		bankBookDTO.setBookSale(1);
//		int a  = bankBookDAO.setBankBookUpdate(bankBookDTO);
//		assertEquals(1, a);
//	}
}
