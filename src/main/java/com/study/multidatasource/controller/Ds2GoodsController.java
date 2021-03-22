package com.study.multidatasource.controller;

import com.github.pagehelper.PageInfo;
import com.study.multidatasource.Pojo.Ds2Goods;
import com.study.multidatasource.annotation.DS;
import com.study.multidatasource.params.Ds2GoodsParams;
import com.study.multidatasource.service.Ds2GoodsServiceI;
import com.study.multidatasource.utils.result.RetResponse;
import com.study.multidatasource.utils.result.RetResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ds2Goods")
@Api(value = "商品表", tags = {"商品表"})
public class Ds2GoodsController {

    @Autowired
    private Ds2GoodsServiceI ds2GoodsService;

    @GetMapping("/get/{id}")
    @ApiOperationSort(10)
    @ApiOperation(value = "通过ID获得信息", notes = "")
    public RetResult<Ds2Goods> ds2GoodsgetById(@PathVariable Integer id) {
        Ds2Goods ds2Goods = ds2GoodsService.getById(id);
        return ds2Goods != null ? RetResponse.makeOkRsp(ds2Goods) : RetResponse.makeErrRsp("信息不存在");
    }


    @GetMapping("/list")
    @ApiOperationSort(30)
    @ApiOperation(value = "通过条件查询符合条件的对象", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "current", required = true, dataType = "Integer"),
    })
    public RetResult<PageInfo<List<Ds2Goods>>> ds2Goodslist(Ds2Goods ds2Goods, Integer current) {
        PageInfo<List<Ds2Goods>> ds2GoodsList = ds2GoodsService.listByEntity(ds2Goods, current);
        return RetResponse.makeOkRsp(ds2GoodsList);
    }


    @GetMapping("/listAll")
    @ApiOperationSort(40)
    @ApiOperation(value = "通过条件查询符合条件的对象(全部))", notes = "")
    @DS(value = "ds2")
    public RetResult<List<Ds2Goods>> ds2GoodslistAll(Ds2Goods ds2Goods) {
        System.out.println("controller");
        List<Ds2Goods> ds2GoodsList = ds2GoodsService.listByEntity(ds2Goods);
        return RetResponse.makeOkRsp(ds2GoodsList);
    }


    @PostMapping("/insert")
    @ApiOperationSort(50)
    @ApiOperation(value = "新增信息，只会新增填入的数据，NULL数据忽略", notes = "")
    public RetResult ds2GoodsinsertSelective(@RequestBody Ds2GoodsParams ds2GoodsParams) {
        if (ds2GoodsService.insertSelective(ds2GoodsParams) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("插入失败");
        }
    }

    @PostMapping("/update")
    @ApiOperationSort(60)
    @ApiOperation(value = "修改信息，只会修改填入的数据，NULL数据忽略", notes = "")
    public RetResult ds2Goodsupdate(@RequestBody Ds2GoodsParams ds2GoodsParams) {
        if (ds2GoodsService.updateByPrimaryKeySelective(ds2GoodsParams) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("修改失败");
        }
    }

    @PostMapping("/delete/{id}")
    @ApiOperationSort(70)
    @ApiOperation(value = "通过主键删除", notes = "")
    public RetResult ds2GoodsdeleteOne(@PathVariable Integer id) {
        if (ds2GoodsService.deleteById(id) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @PostMapping("/delete")
    @ApiOperationSort(80)
    @ApiOperation(value = "通过主键列表删除", notes = "")
    public RetResult ds2GoodsdeleteBatch(@RequestBody List<Integer> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) result = ds2GoodsService.deleteByIds(ids);
        return RetResponse.makeOkRsp(result);
    }

}