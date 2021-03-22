package com.study.multidatasource.utils.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Result")
public class RetResult<T> {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("消息")
    private String msg;
    @ApiModelProperty("数据")
    private T data;

    public RetResult(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=(T)data;
    }

    @Override
    public String toString() {
        return "RetResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = (T)data;
    }
}
