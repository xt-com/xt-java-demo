package com.xt.api.dto.copytrade.spot;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Data
@Builder
public class CopyTradeProfitUpdateReqDTO {

    private String symbol;

    private Long leaderOrderId;

    private BigDecimal triggerProfitPrice;

    private BigDecimal triggerStopPrice;

}
