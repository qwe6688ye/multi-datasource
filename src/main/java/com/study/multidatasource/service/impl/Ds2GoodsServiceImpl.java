package com.study.multidatasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.multidatasource.Pojo.Ds2Goods;
import com.study.multidatasource.annotation.DS;
import com.study.multidatasource.dao.Ds2GoodsDao;
import com.study.multidatasource.params.Ds2GoodsParams;
import com.study.multidatasource.service.Ds2GoodsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Ds2GoodsServiceImpl implements Ds2GoodsServiceI {

    @Autowired
    private Ds2GoodsDao ds2GoodsDao;

    @Override
    public Ds2Goods getById(Integer id) {
        return ds2GoodsDao.getById(id);
    }

    @Override
    public PageInfo<List<Ds2Goods>> listByEntity(Ds2Goods ds2Goods, Integer current) {
        PageHelper.startPage(current, 10);
        List<Ds2Goods> list = ds2GoodsDao.listByEntity(ds2Goods);
        PageInfo<List<Ds2Goods>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    @DS(value = "ds2")
    public List<Ds2Goods> listByEntity(Ds2Goods ds2Goods) {
        System.out.println("service");
        List<Ds2Goods> list = ds2GoodsDao.listByEntity(ds2Goods);
        return list;
    }

    @Override
    public int insertSelective(Ds2GoodsParams ds2GoodsParams) {
        Ds2Goods ds2Goods = new Ds2Goods();
        ds2Goods.setId(ds2GoodsParams.getId());
        ds2Goods.setName(ds2GoodsParams.getName());
        ds2Goods.setPrice(ds2GoodsParams.getPrice());


        return ds2GoodsDao.insertSelective(ds2Goods);
    }

    @Override
    public int insertBatch(List<Ds2Goods> list) {
        return ds2GoodsDao.insertBatch(list);
    }

    @Override
    public int updateByPrimaryKeySelective(Ds2GoodsParams ds2GoodsParams) {
        Ds2Goods ds2Goods = new Ds2Goods();
        ds2Goods.setId(ds2GoodsParams.getId());
        ds2Goods.setName(ds2GoodsParams.getName());
        ds2Goods.setPrice(ds2GoodsParams.getPrice());
        return ds2GoodsDao.updateByPrimaryKeySelective(ds2Goods);
    }

    @Override
    public int updateBatch(List<Ds2Goods> list) {
        return ds2GoodsDao.updateBatch(list);
    }

    @Override
    public int deleteById(Integer id) {
        return ds2GoodsDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(Ds2Goods ds2Goods) {
        return ds2GoodsDao.deleteByEntity(ds2Goods);
    }

    @Override
    public int deleteByIds(List<Integer> list) {
        return ds2GoodsDao.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return ds2GoodsDao.countAll();
    }

    @Override
    public int countByEntity(Ds2Goods ds2Goods) {
        return ds2GoodsDao.countByEntity(ds2Goods);
    }

}