package cn.babasport.controler;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.babasport.pojo.TestTb;
import cn.babasport.service.TestTbService;

@Controller
public class CenterControler {
	/*@Autowired
	private TestTbService testTbService;*/
	
	//加载总页面
	@RequestMapping(value="/console/{pageName}.do")
	public String consoleShow(@PathVariable("pageName")String pageName){
		return pageName;
	}
	
	//框架页面
	@RequestMapping(value="/console/frame/{pageName}.do")
	public String consoleFrameShow(@PathVariable("pageName") String pageName){
		return "frame/"+ pageName;
	}
	
	//加载商品页面
	@RequestMapping(value="/console/product/{pageName}.do")
	public String consoleProductShow(@PathVariable("pageName")String pageName){
		return "product/"+pageName;
	}
	
	/*//加载品牌页面
	@RequestMapping(value="/console/brand/{pageName}.do")
	public String consoleBrandShow(@PathVariable("pageName")String pageName){
		return "brand/"+pageName;
	}*/
	
	
	
}
