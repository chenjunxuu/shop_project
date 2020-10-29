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
    List<Brand> findAll();
}
