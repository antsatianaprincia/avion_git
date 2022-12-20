package com.springboot.avion.utile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MyJson {
    private Object data;

    private Object error;
}
