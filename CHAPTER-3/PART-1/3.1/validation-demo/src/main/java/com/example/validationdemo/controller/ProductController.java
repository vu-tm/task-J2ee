package com.example.validationdemo.controller;



import com.example.validationdemo.dto.ProductRequest;
import com.example.validationdemo.dto.ProductResponse;
import com.example.validationdemo.validation.OnCreate;
import com.example.validationdemo.validation.OnUpdate;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Validated // Bắt buộc dùng cho @PathVariable/@RequestParam validation
public class ProductController {

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Validated(OnCreate.class) @RequestBody ProductRequest request) {

        ProductResponse response = ProductResponse.builder()
                .id(1L)
                .name(request.getName())
                .status("Created successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id,
            @Validated(OnUpdate.class) @RequestBody ProductRequest request) {

        ProductResponse response = ProductResponse.builder()
                .id(id)
                .name(request.getName())
                .status("Updated successfully")
                .build();

        return ResponseEntity.ok(response);
    }
}