package com.shop.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.pojo.Brand;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenjunxu
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    @Resource
    private BrandService brandService;
    @GetMapping("/findAll")
    public Result findAll(){
        List<Brand> brandList = brandService.findAll();
        return new  Result(true, StatusCode.OK,"查询全部品牌成功",brandList);
    }
    @GetMapping("/findById")
    public Result brandById(Integer id){
        Brand brand = brandService.findById(id);
        return new Result(true, StatusCode.OK,"根据ID查询品牌成功",brand);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK,"修改成功");
    }
}
