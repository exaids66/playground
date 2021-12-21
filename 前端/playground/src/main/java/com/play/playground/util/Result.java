package com.play.playground.util;


import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class Result<T> {

    // 业务错误码
    private long code;

    // 结果集
    private T data;

    // 描述
    private String msg;

    // 描述
    private LocalDateTime responseTime = LocalDateTime.now();

    public Result() {
        // to do nothing
    }

    public Result(ApiErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(ApiErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public static <T> Result<T> ok(T data) {
        ApiErrorCode aec = ApiErrorCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = ApiErrorCode.FAILED;
        }
        return restResult(data, aec);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, ApiErrorCode.FAILED.getCode(), msg);
    }

    public static <T> Result<T> failed(ApiErrorCode errorCode) {
        return restResult(null, errorCode);
    }

    public static <T> Result<T> restResult(T data, ApiErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> Result<T> restResult(T data, long code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean ok() {
        return ApiErrorCode.SUCCESS.getCode() == code;
    }

    /**
     * 服务间调用非业务正常，异常直接释放
     */
    public T serviceData() throws Exception {
        if (!ok()) {
            throw new Exception(this.msg);
        }
        return data;
    }
}
