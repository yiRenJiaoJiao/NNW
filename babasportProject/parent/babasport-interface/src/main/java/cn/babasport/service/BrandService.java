package cn.babasport.service;

import java.util.List;

import cn.babasport.common.PageHelper.Page;
import cn.babasport.pojo.Brand;
/**
 * 服务接口
 * @author Administrator
 *
 */
public interface BrandService {
	/**
	 * 根据条件查询,根据类型获取所有的品牌
	 * @param brand
	 * @param pageSize 
	 * @param pageNum 
	 * @return
	 */
	public Page<Brand> findByExample(Brand brand, Integer pageNum, Integer pageSize);

	public Brand findBrandById(Long id);

	public boolean updateBrandById(Brand brand);

	public boolean add(Brand brand);

	public boolean deleteBrands(String[] ids);
}