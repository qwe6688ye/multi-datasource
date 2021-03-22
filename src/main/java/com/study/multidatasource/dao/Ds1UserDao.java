package com.study.multidatasource.dao;

import com.study.multidatasource.Pojo.Ds1User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface Ds1UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ds1User getById(@NotNull Integer id);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个
     *
     * @param ds1User 实例对象
     * @return 单个对象
     */
    Ds1User getByEntity(Ds1User ds1User);

    /**
     * 通过实体不为空的属性作为筛选条件查询列表
     *
     * @param ds1User 实例对象
     * @return 对象列表
     */
    List<Ds1User> listByEntity(Ds1User ds1User);


    /**
     * 通过Id列表作为筛选条件查询列表，列表长度不为0
     *
     * @param list List<Integer> 实例对象主键ID列表
     * @return 对象列表
     */
    List<Ds1User> listByIds(@NotEmpty List<Integer> list);

    /**
     * 新增实体，注意：当实体属性为null时，对应的列也会插入为null
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int insert(@NotNull Ds1User ds1User);

    /**
     * 新增实体属性不为null的列
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int insertSelective(@NotNull Ds1User ds1User);

    /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null。注意：若字段有NULL，会插入NULL值
     *
     * @param list List<ds1User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@NotEmpty List<Ds1User> list);

    /**
     * 通过主键修改实体属性不为null的列
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(@NotNull Ds1User ds1User);

    /**
     * 通过表字段修改实体属性不为null的列 where-为被修改的数据条件，set为要修改的数据。注意：当where的某个属性不为NULL时，该属性不会被修改
     *
     * @param where 条件字段，set 修改字段值
     * @return 影响行数
     */
    int updateByField(@NotNull @Param("where") Ds1User where, @NotNull @Param("set") Ds1User set);

    /**
     * 通过主键修改实体列表，列表长度不能为0，注意：当实体属性为null时，对应的列也会被更新为null
     *
     * @param list List<ds1User> 实例对象列表
     * @return 影响行数
     */
    int updateBatch(@NotEmpty List<Ds1User> list);

    /**
     * 通过主键删除
     *
     * @param id 主键ID
     * @return 影响行数
     */
    int deleteById(@NotNull Integer id);

    /**
     * 通过实体非空属性删除
     *
     * @param ds1User 实例对象
     * @return 影响行数
     */
    int deleteByEntity(@NotNull Ds1User ds1User);

    /**
     * 通过主键列表删除，列表长度不能为0
     *
     * @param list List<Integer> 实例对象的主键ID列表
     * @return 影响行数
     */
    int deleteByIds(@NotEmpty List<Integer> list);

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