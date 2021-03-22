package com.study.multidatasource.service;

import com.github.pagehelper.PageInfo;
import com.study.multidatasource.Pojo.Ds1User;
import com.study.multidatasource.params.Ds1UserParams;

import java.util.List;

public interface Ds1UserServiceI {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ds1User getById(Integer id);


    /**
     * 通过实体不为空的属性作为筛选条件查询列表
     *
     * @param ds1User 实例对象
     * @return 对象列表
     */
    PageInfo<List<Ds1User>> listByEntity(Ds1User ds1User, Integer current);


    List<Ds1User> listByEntity(Ds1User ds1User);

    /**
     * 新增实体属性不为null的列
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int insertSelective(Ds1UserParams ds1User);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null。注意：若字段有NULL，会插入NULL值
     *
     * @param list List<ds1User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<Ds1User> list);

    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(Ds1UserParams ds1User);

    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会被更新为null
     *
     * @param list List<ds1User> 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<Ds1User> list);

    /**
     * 通过主键删除
     *
     * @param id 主键id
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过实体非空属性删除
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int deleteByEntity(Ds1User ds1User);

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list List<Integer> 实例对象的主键ID列表
     * @return 影响行数
     */
    int deleteByIds(List<Integer> list);

    /**
     * 获取当前表的所有总数
     *
     * @return 总数
     */
    int countAll();

    /**
     * 通过字段来查找符合条件的所有总数
     *
     * @param ds1User 实例对象
     * @return 符合条件的总数
     */
    int countByEntity(Ds1User ds1User);
}