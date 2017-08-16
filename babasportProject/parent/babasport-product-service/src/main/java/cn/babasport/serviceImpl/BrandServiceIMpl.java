package cn.babasport.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.container.page.PageHandler;

import cn.babasport.common.PageHelper;
import cn.babasport.common.PageHelper.Page;
import cn.babasport.dao.BrandDao;
import cn.babasport.pojo.Brand;
import cn.babasport.service.BrandService;


/**
 * 品牌的服务
 * @author Administrator
 *
 */
@Controller(value="brandService")
public class BrandServiceIMpl implements BrandService{
	
	@Autowired
	private BrandDao brandDao;
	
	/**
	 * 根据类型获取所有品牌的集合
	 */
	@Override
	public Page<Brand> findByExample(Brand brand, Integer pageNum, Integer pageSize) {
		//使用PageHelper进行分页查询
		PageHelper.startPage(pageNum, pageSize);
		//获取所有表单数据
		List<Brand> brands = brandDao.findByExample(brand);
		//结束分页查询,返回=页面数据
		Page<Brand> page = PageHelper.endPage();
		
		return page;
	}

	@Override
	public Brand findBrandById(Long id) {
		Brand brand = brandDao.findBrandById(id);
		return brand;
	}

	@Override
	public boolean updateBrandById(Brand brand) {
		try {
			brandDao.updateBrand(brand);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean add(Brand brand) {
		try {
			brandDao.add(brand);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBrands(String[] ids) {
		try {
		
			brandDao.deleteBrandByStatus(ids);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
