package com.weipch.result;

import lombok.Data;

@Data
public class ResponseResult<T> {

    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;

    //构造私有化
    private ResponseResult() { }

    //设置数据,返回对象的方法
    public static<T> ResponseResult<T> build(T data, Integer code, String message) {
        //创建Resullt对象，设置值，返回对象
        ResponseResult<T> responseResult = new ResponseResult<>();
        //判断返回结果中是否需要数据
        if(data != null) {
            //设置数据到result对象
            responseResult.setData(data);
        }
        //设置其他值
        responseResult.setCode(code);
        responseResult.setMessage(message);
        //返回设置值之后的对象
        return responseResult;
    }


    //设置数据,返回对象的方法
    public static<T> ResponseResult<T> build(T data, ResultCodeEnum resultCodeEnum) {
        //创建Resullt对象，设置值，返回对象
        ResponseResult<T> responseResult = new ResponseResult<>();
        //判断返回结果中是否需要数据
        if(data != null) {
            //设置数据到result对象
            responseResult.setData(data);
        }
        //设置其他值
        responseResult.setCode(resultCodeEnum.getCode());
        responseResult.setMessage(resultCodeEnum.getMessage());
        //返回设置值之后的对象
        return responseResult;
    }

    //成功的方法
    public static<T> ResponseResult<T> success(T data) {
        ResponseResult<T> responseResult = build(data, ResultCodeEnum.SUCCESS);
        return responseResult;
    }

    //失败的方法
    public static<T> ResponseResult<T> error(T data) {
        return build(data,ResultCodeEnum.FAIL);
    }

}
