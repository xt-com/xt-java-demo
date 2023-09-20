package com.xt.api.client;

import lombok.Data;

/**
 * @author zhouzhuang
 * @create 2023/4/21 10:53
 */
@Data
public class HttpProxyProperties {

    /**是否使用代理ip*/
    private boolean enabled;
    /**代理IP*/
    private String host;
    /**代理端口*/
    private int port;

}
