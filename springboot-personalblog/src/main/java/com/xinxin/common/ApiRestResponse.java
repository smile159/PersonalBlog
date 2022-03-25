package com.xinxin.common;

import com.xinxin.response.ApiResponseEnum;
import lombok.Data;


@Data
public class ApiRestResponse<T>{
    //请求的响应状态
    private final Integer status;
    //请求的响应信息
    private final String msg;
    //请求的响应数据
    private T data;

    //构造函数
    // 1.没有data的构造函数
    public ApiRestResponse(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }

    // 2.有data的构造函数
    public ApiRestResponse(Integer status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // 成功的方法请求无返回值
    public static <T>  ApiRestResponse<T> success(){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getMsg());
    }

    // 成功的请求方法，有返回值
    public static <T>  ApiRestResponse<T> sussess(T data){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getMsg(),data);
    }

    // 成功的请求，自定义msg
    public static <T>  ApiRestResponse<T> sussess(String msg){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(), msg);
    }

    // 成功的请求，自定义msg和data
    public static <T>  ApiRestResponse<T> sussess(String msg,T data){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),msg,data);
    }


    // 失败的请求 无返回值
    public static <T>  ApiRestResponse<T> error(){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getMsg());
    }


    // 失败的请求 有返回值
    public static <T>  ApiRestResponse<T> error(T data){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getMsg(),data);
    }

    // 失败的请求 无返回值，自定义msg
    public static <T>  ApiRestResponse<T> error(String msg){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),msg);
    }


    // 失败的请求 无返回值，自定义msg和data
    public static <T>  ApiRestResponse<T> error(String msg,T data){
        return new ApiRestResponse<T>(ApiResponseEnum.SUCCESS.getCode(),msg,data);
    }
}
