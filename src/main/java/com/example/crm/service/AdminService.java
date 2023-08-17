package com.example.crm.service;


import com.example.crm.request.StatusUpdateRequest;
import com.example.crm.response.UserResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    private final RestTemplate restTemplate;

    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserResponse> getAllUser(String role) {
        String PATH = "/" + role;
        String URL = "http://localhost:9091/user/api/admin/userList";
        if (!role.isEmpty()) {
            URL = "http://localhost:9091/user/api/admin/userList" + PATH;
        }
        System.out.println(URL);
        ResponseEntity<UserResponse[]> responseEntity = restTemplate.getForEntity(URL, UserResponse[].class);
        return new ArrayList<>(List.of(Objects.requireNonNull(responseEntity.getBody())));
    }


    public void setStoreStatus(String storeId, boolean status) {
        String STORE_URL = "http://localhost:9091/user/api/admin/edit/status/";
        String STORE_DETAILS_URL = "http://localhost:9090/store/edit";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        StatusUpdateRequest statusUpdateDTO = new StatusUpdateRequest(status);
        HttpEntity<StatusUpdateRequest> request = new HttpEntity<>(statusUpdateDTO, headers);
        ResponseEntity<Void> response = restTemplate.postForEntity(STORE_URL, request, Void.class);
        ResponseEntity<Void> response2 = restTemplate.postForEntity(STORE_DETAILS_URL, request, Void.class);
    }

//    //setShopsActive -

//    //getCustomerById
//    //getCustomersOrders
//    //getProductsOfShops
//
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public List<User> getAllCustomers() {
//        return userRepository.findAllByRole(Role.CUSTOMER);
//    }
//
//    public List<User> getAllShops() {
//        return userRepository.findAllByRole(Role.SHOP);
//    }
//
//    //    TODO
//    public StoreResponse getShopDetail(String id) throws JsonProcessingException {
//        final String URL = "http://localhost:9090/store/byUserId/";
////        final String DETAILS_URL = "http://localhost:9090/store/details/byUserId/";
//        ResponseEntity<StoreResponse> responseEntity = restTemplate.getForEntity(URL + id, StoreResponse.class);
//        StoreResponse response = responseEntity.getBody();
//        assert response != null;
//        return StoreResponse.builder()
//                .id(response.getId())
//                .storeName(response.getStoreName())
//                .detailsResponse(getStoreDetail(response.getId()))
//                .build();
//    }
//
//    private StoreDetailsResponse getStoreDetail(Long id) {
//        final String DETAILS_URL = "http://localhost:9090/store/details/byUserId/";
//        ResponseEntity<StoreDetailsResponse> detailsResponse = restTemplate.getForEntity(DETAILS_URL + id, StoreDetailsResponse.class);
//        StoreDetailsResponse storeDetailsResponse = detailsResponse.getBody();
//        assert storeDetailsResponse != null;
//        return StoreDetailsResponse.builder()
//                .id(storeDetailsResponse.getId())
//                .country(storeDetailsResponse.getCountry())
//                .city(storeDetailsResponse.getCity())
//                .street(storeDetailsResponse.getStreet())
//                .zipcode(storeDetailsResponse.getZipcode())
//                .address(storeDetailsResponse.getAddress())
//                .phoneNumber(storeDetailsResponse.getPhoneNumber())
//                .createTime(storeDetailsResponse.getCreateTime())
//                .updateTime(storeDetailsResponse.getUpdateTime())
//                .build();
//    }
//
//    public void setStoreStatus(String id, boolean status) {
//        final String URL = "http://localhost:9090/store/edit/status/";
//        User user = userRepository.findById(id).orElseThrow();
//        user.setActive(status);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForEntity(URL + id, status, String.class);
//    }

}
