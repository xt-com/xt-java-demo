package com.xt.api.dto.spot;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhouzhuang
 * @create 2023/9/20 16:09
 */
@Data
@Builder
public class SpotPostOrderRequest {

    private String symbol;
    private String side;
    private String type;
    private String timeInForce;

    private String bizType;
    private String price;

    private String quantity;
    private String media;
    private String mediaChannel;
}
