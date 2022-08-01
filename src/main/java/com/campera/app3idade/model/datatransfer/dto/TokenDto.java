package com.campera.app3idade.model.datatransfer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TokenDto {
    @Getter
    private String token;
    @Getter
    private String string;
}
