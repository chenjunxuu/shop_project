package com.shop.controller;

import com.github.pagehelper.Page;
import com.shop.entity.PageResult;
import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.pojo.Brand;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @PutMapping("update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result(true, StatusCode.OK,"修改成功");
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }
    @GetMapping("/searchPage/{pageNo}/{pageSize}")
    public Result searchPage(@RequestParam Map<String,String> searchMap,@PathVariable int pageNo,@PathVariable int pageSize){
        Page page = brandService.searchPage(searchMap, pageNo, pageSize);
        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
        return new Result(true, StatusCode.OK,"分页查询成功",pageResult);
    }

}
