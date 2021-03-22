package com.study.multidatasource.utils.result;


public class RetResponse {
    public static <T> RetResult<T> makeOkRsp(T data) {
        return new RetResult<T>(RetCode.SUCCESS.code,"success",data);
    }

    //自定义message 失败信息
    public static <T> RetResult<T> makeErrRsp() {
        return new RetResult<T>(RetCode.FAIL.code,"fail",null);
    }

    //自定义message 失败信息
    public static <T> RetResult<T> makeErrRsp(String msg) {
        return new RetResult<T>(RetCode.FAIL.code,msg,null);
    }

    //自定义message 失败信息
    public static <T> RetResult<T> makeErrRsp(String msg,T data) {
        return new RetResult<T>(RetCode.FAIL.code,msg,data);
    }
    //自定义code,msg 返回数据
    public static <T> RetResult<T> makeRsp(int code, String msg) {
        return new RetResult<T>(code,msg,null);
    }
    //自定义code,msg,data 返回数据
    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        return new RetResult<T>(code,msg,data);
    }
}