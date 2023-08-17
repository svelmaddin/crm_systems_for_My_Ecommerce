package com.example.crm.response;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreResponse {
    private Long id;
    private String storeName;
    private StoreDetailsResponse detailsResponse;
}
