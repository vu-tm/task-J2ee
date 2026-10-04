/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.api.response.demo.controller;

import com.example.api.response.demo.model.ApiResponse;
import com.example.api.response.demo.model.Product;
import com.example.api.response.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ApiResponse<List<Product>> getAll() {
        return ApiResponse.success(productService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getById(@PathVariable int id) {
        return ApiResponse.success(productService.getById(id));
    }
}