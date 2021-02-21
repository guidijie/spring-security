package com.jie.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {

    private Boolean success;

    private int code;

    private String msg;

    private T data;

    private ResponseResult(boolean success, ResultCode resultCode, T data) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : (resultCode == null ? ResultCode.FAIL.getCode() : resultCode.getCode());
        this.msg = success ? ResultCode.SUCCESS.getMsg() : (resultCode == null ? ResultCode.FAIL.getMsg() : resultCode.getMsg());
        this.data = data;
    }


    // 成功
    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    // 成功
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(true, null, data);
    }

    // 失败
    public static <T> ResponseResult<T> error() {
        return error(null);
    }

    // 失败
    public static <T> ResponseResult<T> error(ResultCode resultEnum) {
        return new ResponseResult<T>(false, resultEnum, null);
    }


//    // 自定义code和msg
//    public ResponseResult<T> addCode(ResultCode resultCode){
//        this.setCode(resultCode.getCode());
//        this.setMsg(resultCode.getMsg());
//        return this;
//    }
//
//    // 添加数据
//    public  ResponseResult<T> addData(T data){
//        this.setData(data);
//        return this;
//    }

}

