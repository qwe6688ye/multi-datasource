package com.study.multidatasource.params;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Ds2Goods)实体类
 *
 * @author any
 * @since 2021-03-19 16:47:24
 */
public class Ds2GoodsParams implements Serializable {
    private static final long serialVersionUID = 569152792406697651L;
    /**
     * 商品表
     */
    @ApiModelProperty(value = "商品表", required = true)
    private Integer id;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", required = true)
    private String name;
    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", required = true)
    private Double price;


    @Override
    public String toString() {
        return "Ds2Goods{" +
                "id=" + id +
                "name=" + name +
                "price=" + price +
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}