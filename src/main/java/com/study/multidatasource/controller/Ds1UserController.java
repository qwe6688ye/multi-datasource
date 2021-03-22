package com.study.multidatasource.controller;

import com.github.pagehelper.PageInfo;
import com.study.multidatasource.Pojo.Ds1User;
import com.study.multidatasource.annotation.DS;
import com.study.multidatasource.params.Ds1UserParams;
import com.study.multidatasource.service.Ds1UserServiceI;
import com.study.multidatasource.utils.result.RetResponse;
import com.study.multidatasource.utils.result.RetResult;
import io.swagger.annotations.*;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ds1User")
@Api(value = "用户表", tags = {"用户表"})
public class Ds1UserController {

    @Autowired
    private Ds1UserServiceI ds1UserService;

    @GetMapping("/get/{id}")
    @ApiOperationSort(10)
    @ApiOperation(value = "通过ID获得信息", notes = "")
    public RetResult<Ds1User> ds1UsergetById(@PathVariable Integer id) {
        Ds1User ds1User = ds1UserService.getById(id);
        return ds1User != null ? RetResponse.makeOkRsp(ds1User) : RetResponse.makeErrRsp("信息不存在");
    }


    @GetMapping("/list")
    @ApiOperationSort(30)
    @ApiOperation(value = "通过条件查询符合条件的对象", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "current", required = true, dataType = "Integer"),
    })
    public RetResult<PageInfo<List<Ds1User>>> ds1Userlist(Ds1User ds1User, Integer current) {
        PageInfo<List<Ds1User>> ds1UserList = ds1UserService.listByEntity(ds1User, current);
        return RetResponse.makeOkRsp(ds1UserList);
    }


    @GetMapping("/listAll")
    @ApiOperationSort(40)
    @ApiOperation(value = "通过条件查询符合条件的对象(全部))", notes = "")
    @DS(value = "ds1")
    public RetResult<List<Ds1User>> ds1UserlistAll(Ds1User ds1User) {
        List<Ds1User> ds1UserList = ds1UserService.listByEntity(ds1User);
        return RetResponse.makeOkRsp(ds1UserList);
    }


    @PostMapping("/insert")
    @ApiOperationSort(50)
    @ApiOperation(value = "新增信息，只会新增填入的数据，NULL数据忽略", notes = "")
    public RetResult ds1UserinsertSelective(@RequestBody Ds1UserParams ds1UserParams) {
        if (ds1UserService.insertSelective(ds1UserParams) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("插入失败");
        }
    }

    @PostMapping("/update")
    @ApiOperationSort(60)
    @ApiOperation(value = "修改信息，只会修改填入的数据，NULL数据忽略", notes = "")
    public RetResult ds1Userupdate(@RequestBody Ds1UserParams ds1UserParams) {
        if (ds1UserService.updateByPrimaryKeySelective(ds1UserParams) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("修改失败");
        }
    }

    @PostMapping("/delete/{id}")
    @ApiOperationSort(70)
    @ApiOperation(value = "通过主键删除", notes = "")
    public RetResult ds1UserdeleteOne(@PathVariable Integer id) {
        if (ds1UserService.deleteById(id) > 0) {
            return RetResponse.makeOkRsp(null);
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @PostMapping("/delete")
    @ApiOperationSort(80)
    @ApiOperation(value = "通过主键列表删除", notes = "")
    public RetResult ds1UserdeleteBatch(@RequestBody List<Integer> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) result = ds1UserService.deleteByIds(ids);
        return RetResponse.makeOkRsp(result);
    }

}