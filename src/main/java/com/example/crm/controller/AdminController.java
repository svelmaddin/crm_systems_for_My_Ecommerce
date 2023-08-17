package com.example.crm.controller;

import com.example.crm.response.UserResponse;
import com.example.crm.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //    localhost:8080/api/admin?role=
    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllByRole(@RequestParam(name = "role") String role) {
        return ResponseEntity.ok(adminService.getAllUser(role));
    }

    @PostMapping()
    public ResponseEntity<Void> setStoreStatus(@RequestParam(name = "id") String storeId,
                                               @RequestParam(name = "status") boolean status) {
        adminService.setStoreStatus(storeId, status);
        return ResponseEntity.ok().build();
    }
}
