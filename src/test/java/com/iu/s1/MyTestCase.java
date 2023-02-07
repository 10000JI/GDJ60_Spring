package com.iu.s1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
//spring 폴더 밑에 또 다른 파일이 있어도 되고 없어도 됨
public abstract class MyTestCase {
	//abstract로 상속해서 쓰자

}
