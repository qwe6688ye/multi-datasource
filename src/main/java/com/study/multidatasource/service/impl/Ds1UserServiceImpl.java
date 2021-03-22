package com.study.multidatasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.multidatasource.Pojo.Ds1User;
import com.study.multidatasource.annotation.DS;
import com.study.multidatasource.dao.Ds1UserDao;
import com.study.multidatasource.params.Ds1UserParams;
import com.study.multidatasource.service.Ds1UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Ds1UserServiceImpl implements Ds1UserServiceI {

    @Autowired
    private Ds1UserDao ds1UserDao;

    @Override
    public Ds1User getById(Integer id) {
        return ds1UserDao.getById(id);
    }

    @Override
    public PageInfo<List<Ds1User>> listByEntity(Ds1User ds1User, Integer current) {
        PageHelper.startPage(current, 10);
        List<Ds1User> list = ds1UserDao.listByEntity(ds1User);
        PageInfo<List<Ds1User>> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    @DS(value = "ds1")
    public List<Ds1User> listByEntity(Ds1User ds1User) {
        List<Ds1User> list = ds1UserDao.listByEntity(ds1User);
        return list;
    }

    @Override
    public int insertSelective(Ds1UserParams ds1UserParams) {
        Ds1User ds1User = new Ds1User();
        ds1User.setId(ds1UserParams.getId());
        ds1User.setName(ds1UserParams.getName());
        ds1User.setPhone(ds1UserParams.getPhone());


        return ds1UserDao.insertSelective(ds1User);
    }

    @Override
    public int insertBatch(List<Ds1User> list) {
        return ds1UserDao.insertBatch(list);
    }

    @Override
    public int updateByPrimaryKeySelective(Ds1UserParams ds1UserParams) {
        Ds1User ds1User = new Ds1User();
        ds1User.setId(ds1UserParams.getId());
        ds1User.setName(ds1UserParams.getName());
        ds1User.setPhone(ds1UserParams.getPhone());
        return ds1UserDao.updateByPrimaryKeySelective(ds1User);
    }

    @Override
    public int updateBatch(List<Ds1User> list) {
        return ds1UserDao.updateBatch(list);
    }

    @Override
    public int deleteById(Integer id) {
        return ds1UserDao.deleteById(id);
    }

    @Override
    public int deleteByEntity(Ds1User ds1User) {
        return ds1UserDao.deleteByEntity(ds1User);
    }

    @Override
    public int deleteByIds(List<Integer> list) {
        return ds1UserDao.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return ds1UserDao.countAll();
    }

    @Override
    public int countByEntity(Ds1User ds1User) {
        return ds1UserDao.countByEntity(ds1User);
    }

}