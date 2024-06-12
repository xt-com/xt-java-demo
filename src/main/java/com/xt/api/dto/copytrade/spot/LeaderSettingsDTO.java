package com.xt.api.dto.copytrade.spot;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LeaderSettingsDTO {

    private String leaderIntro;

    private String labelIds;

    private boolean displayEquity;

    private boolean displayQuantity;

    private String symbols;

    private boolean openLeader;

}
