package com.xt.api.dto.copytrade.futures;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AdjustLeverageReqDTO {

    private String symbol;

    private Integer leverage;

    private String positionSide;

}
