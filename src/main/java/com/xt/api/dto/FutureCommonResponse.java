package com.xt.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

/**
 * @author zhouzhuang
 * @create 2023/9/20 17:30
 */
@Data
@NoArgsConstructor
public class FutureCommonResponse<T> {
    private final static Integer RC_SUCCESS = 0;
    private final static Integer RC_FAILURE = 1;
    private Integer returnCode;
    private T result;
    private String msgInfo;
    private Object error;


    private FutureCommonResponse(Integer returnCode, T result, String msgInfo, Object error) {
        this.returnCode = returnCode;
        this.result = result;
        this.msgInfo = msgInfo;
        this.error = error;
    }

    private static FutureCommonResponse<Object> FAILURE = new FutureCommonResponse<>(RC_FAILURE,null, "FAILURE", null);



    public static FutureCommonResponse<Object> failure() {
        return FAILURE;
    }

    public static FutureCommonResponse<Object> failure(String msg) {
        return new FutureCommonResponse<>(RC_FAILURE,null, msg, null);
    }
}
