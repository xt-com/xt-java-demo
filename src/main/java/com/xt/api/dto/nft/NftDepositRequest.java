package com.xt.api.dto.nft;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouzhuang
 * @create 2023/9/20 16:09
 */
@Data
@Builder
public class NftDepositRequest {

    private Long currencyId;

    private String serial;

    private String passcode;
}
