package com.baocheng.service.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: common json result
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class BCJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;	// 不使用

    public static BCJSONResult build(Integer status, String msg, Object data) {
        return new BCJSONResult(status, msg, data);
    }

    public static BCJSONResult build(Integer status, String msg, Object data, String ok) {
        return new BCJSONResult(status, msg, data, ok);
    }

    public static BCJSONResult ok(Object data) {
        return new BCJSONResult(data);
    }

    public static BCJSONResult ok() {
        return new BCJSONResult(null);
    }

    public static BCJSONResult errorMsg(String msg) {
        return new BCJSONResult(500, msg, null);
    }

    public static BCJSONResult errorMap(Object data) {
        return new BCJSONResult(501, "error", data);
    }

    public static BCJSONResult errorTokenMsg(String msg) {
        return new BCJSONResult(502, msg, null);
    }

    public static BCJSONResult errorException(String msg) {
        return new BCJSONResult(555, msg, null);
    }

    public static BCJSONResult errorUserQQ(String msg) {
        return new BCJSONResult(556, msg, null);
    }

    public static BCJSONResult errorUserTicket(String msg) {
        return new BCJSONResult(557, msg, null);
    }

    public BCJSONResult() {

    }

    public BCJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public BCJSONResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public BCJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}

