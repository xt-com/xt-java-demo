package com.xt.api.dto.copytrade.futures;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CopyTradeProfitUpdateReqDTO {

    private Long trackNo;

    private BigDecimal triggerProfitPrice;

    private BigDecimal triggerStopPrice;

    /**
     *  触发价格类型:LATEST_PRICE,MARK_PRICE
     */
    private String triggerPriceType;

}
