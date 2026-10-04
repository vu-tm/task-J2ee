/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.api.response.demo.service;

import com.example.api.response.demo.exception.ResourceNotFoundException;
import com.example.api.response.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Chuột", 20));
        products.add(new Product(3, "Bàn phím", 50));
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm id = " + id));
    }
}