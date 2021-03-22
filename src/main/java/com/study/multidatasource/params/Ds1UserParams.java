package com.study.multidatasource.params;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Ds1User)实体类
 *
 * @author any
 * @since 2021-03-19 16:42:43
 */
public class Ds1UserParams implements Serializable {
    private static final long serialVersionUID = 811212391397798423L;
    /**
     * 用户表
     */
    @ApiModelProperty(value = "用户表", required = true)
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", required = true)
    private String name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;


    @Override
    public String toString() {
        return "Ds1User{" +
                "id=" + id +
                "name=" + name +
                "phone=" + phone +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}