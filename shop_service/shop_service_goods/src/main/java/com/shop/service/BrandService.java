package com.shop.service;

import com.shop.pojo.Brand;

import java.util.List;

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
}
