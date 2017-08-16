package cn.babasport.serviceImpl;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.babasport.dao.TestMapper;
import cn.babasport.pojo.TestTb;
import cn.babasport.service.TestTbService;
/**
 * TestTb 服务控制器
 * @author Administrator
 *
 */
@Controller(value="testTbService")
public class TestTbServiceImpl implements TestTbService{
	@Autowired
	private TestMapper testMapper;
	
	/**
	 * 添加实体
	 */
	@Override
	@Transactional
	public void add(TestTb t) {
		testMapper.add(t);
		TestTb t1 = new TestTb();
		t1.setName("ali");
		//int i = 2/0;
		testMapper.add(t1);
	}
	
	
}
