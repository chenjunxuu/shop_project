package com.shop.service;

import com.shop.dao.BrandMapper;
import com.shop.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenjunxu
 */
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return null;
    }
}
