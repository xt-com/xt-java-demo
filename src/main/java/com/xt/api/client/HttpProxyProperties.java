package com.xt.api.client;

import lombok.Data;

/**
 * @author zhouzhuang
 * @create 2023/4/21 10:53
 */
@Data
public class HttpProxyProperties {

    /**use proxy ip or not*/
    private boolean enabled;
    /**proxy ip*/
    private String host;
    /**proxy port*/
    private int port;

}
