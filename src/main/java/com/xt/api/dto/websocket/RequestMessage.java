package com.xt.api.dto.websocket;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
public class RequestMessage implements Serializable {
    private String method; //SUBSCRIBE
    private List<String> params;  //{topic}@{arg},{arg}
    private String id;
}
