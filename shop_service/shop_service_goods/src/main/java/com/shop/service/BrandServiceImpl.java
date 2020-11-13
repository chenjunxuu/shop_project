package com.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.BrandMapper;
import com.shop.entity.Result;
import com.shop.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chenjunxu
 */
@Service
public class BrandServiceImpl implements BrandService{
    @Resource
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page searchPage(Map<String, String> searchMap, int pageNo, int pageSize) {
        //使用分页器进行分页
        PageHelper.startPage(pageNo,pageSize);
        //构建查询对象 example 条件
        Example example = new Example(Brand.class);
        //这个要结合着 brandMapper.selectCountByExample(example);来用 相当于执行select count(name) form tb_brand
        //example.setCountProperty("name");
        //example.setOrderByClause("name desc"); 相当于 select * from tb_brand order by name desc
        //example.setDistinct(true); select dinstinct name from tb_brand;
        //构建查询条件对象 Example的内部类
        Example.Criteria criteria = example.createCriteria();
        //判断searchMap不为空并且里面必须有值
        if(searchMap!=null && searchMap.size()>0){
            if(StringUtils.isNotEmpty(searchMap.get("name"))){
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            if(StringUtils.isNotEmpty(searchMap.get("letter"))){
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }

        }

        List<Brand> brandList = brandMapper.selectByExample(example);

        return (Page)brandList;
    }


}
