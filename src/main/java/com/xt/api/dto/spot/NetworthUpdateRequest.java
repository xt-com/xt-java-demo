package com.xt.api.dto.spot;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhouzhuang
 * @create 2024/5/10 15:41
 */
@Data
@Builder
public class NetworthUpdateRequest {

    private String symbol;
    private BigDecimal netWorth;
}
