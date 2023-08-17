package com.example.crm.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailsResponse {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String zipcode;
    private String address;
    private String phoneNumber;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Byte[] photo;
}
