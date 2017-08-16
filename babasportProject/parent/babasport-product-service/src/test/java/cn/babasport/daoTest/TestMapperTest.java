package cn.babasport.daoTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.babasport.dao.TestMapper;
import cn.babasport.pojo.TestTb;
import cn.babasport.service.TestTbService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestMapperTest{
	
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private TestTbService testTbService;
	@Test
	public void testAdd(){
		TestTb t = new TestTb();
		t.setName("aa");
		t.setBirthday(new Date(0));
		testMapper.add(t);
	}
	
	@Test
	public void add1(){
		TestTb t1 = new TestTb();
		t1.setBirthday(new Date(0));
		t1.setName("linda2");
		testTbService.add(t1);
	}
}
