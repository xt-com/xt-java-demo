package com.xt.api.dto.copytrade.futures;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class FollowLeaderDTO {

    private Long leaderAccountId;

    private String followType;

    private BigDecimal followVal;

    private BigDecimal followLoss;

    private String followLossOperate;

    private BigDecimal triggerProfitRate;

    private BigDecimal triggerStopRate;

    private boolean autoFollowSymbol;

    private String symbols;
}
