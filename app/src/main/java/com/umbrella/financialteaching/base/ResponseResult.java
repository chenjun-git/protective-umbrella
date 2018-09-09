package com.umbrella.financialteaching.base;

/**
 * Created by chenjun on 18/9/9.
 */

public class ResponseResult<T> {
    public String has_more;
    public String messge;
    public String successs;
    public T data;

    public ResponseResult(String more, String message, T result) {
        this.has_more = more;
        this.messge = message;
        this.data = result;
    }
}
