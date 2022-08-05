package com.campera.app3idade.model.datatransfer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class AppUserDto {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String countryCode;
    @Getter @Setter
    private String areaCode;
    @Getter @Setter
    private String phoneNumber;
    @Getter	@Setter
    private String email;
}
