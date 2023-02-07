package com.iu.s1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)// Test에서 Servlet context 사용하기위해 개발할때 하는 설정 , 배포할때는 안씀
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}) //classpath : 배포할때의 경로
public abstract class MyTestCase {

}
