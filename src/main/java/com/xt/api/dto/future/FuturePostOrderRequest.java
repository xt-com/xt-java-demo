package com.xt.api.dto.future;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouzhuang
 * @create 2023/9/20 16:09
 */
@Data
@Builder
public class FuturePostOrderRequest {

    private String symbol;
    private String orderSide;
    private String orderType;
    private String origQty;
    private String price;
    private String reduceOnly;

    private String timeInForce;
    private String triggerProfitPrice;
    private String triggerStopPrice;
    private String positionSide;
}
