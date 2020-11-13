package com.shop.service;

import com.github.pagehelper.Page;
import com.shop.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author chenjunxu
 */
public interface BrandService {
    /**
     * 查询全部Brand
     * @return
     */
    public List<Brand> findAll();

    /**
     * 通过ID查询Brand
     * @param Id
     * @return
     */
    public Brand findById(Integer Id);

    /**
     * 新增brand
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改brand
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除brand
     * @param Id
     */
    void delete(Integer Id);

    /**
     * 分页查询brand
     * @param searchPage
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page searchPage(Map<String,String> searchPage , int pageNo, int pageSize);
}
