package com.xt.api.dto.spot;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouzhuang
 * @create 2024/9/20 12:00
 */
@Data
@Builder
public class SpotUpdateOrderRequest {

    private String price;
    private String quantity;
}
