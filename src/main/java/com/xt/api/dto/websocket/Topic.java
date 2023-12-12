package com.xt.api.dto.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Topic {
    notify(true),
    order(true),
    trade(true),
    position(true),
    balance(true);
    private final Boolean token;
}
