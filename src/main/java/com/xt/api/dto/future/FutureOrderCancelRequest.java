package com.xt.api.dto.future;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FutureOrderCancelRequest {

    private Long orderId;
}
