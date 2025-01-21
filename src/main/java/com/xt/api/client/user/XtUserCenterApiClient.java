package com.xt.api.client.user;

import com.xt.api.dto.CommonResponse;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtUserCenterApiClient {

    CommonResponse getUserBalance(Long userId);
}
