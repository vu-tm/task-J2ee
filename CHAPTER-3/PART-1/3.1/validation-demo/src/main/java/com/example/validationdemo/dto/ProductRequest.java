package com.example.validationdemo.dto;



import com.example.validationdemo.annotation.Sku;
import com.example.validationdemo.validation.OnCreate;
import com.example.validationdemo.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    @NotBlank(message = "Product name cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters", groups = {OnCreate.class, OnUpdate.class})
    String name;

    @NotNull(message = "Price cannot be null", groups = OnCreate.class)
    @Positive(message = "Price must be positive", groups = {OnCreate.class, OnUpdate.class})
    Double price;

    @NotNull(message = "Category ID is required", groups = OnCreate.class)
    Long categoryId;

    @Valid
    @Size(max = 5, message = "You can add up to 5 tags", groups = {OnCreate.class, OnUpdate.class})
    List<@NotBlank(message = "Tag cannot be blank") String> tags;

    @Email(message = "Invalid email format for warranty", groups = {OnCreate.class, OnUpdate.class})
    String emailForWarranty;

    @Min(value = 0, message = "Discount cannot be negative", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 80, message = "Discount cannot exceed 80%", groups = {OnCreate.class, OnUpdate.class})
    Integer discountPercentage;

    @Future(message = "Availability date must be in the future", groups = {OnCreate.class, OnUpdate.class})
    LocalDate availabilityDate;

    @Sku(message = "SKU must be 8 uppercase letters or digits", groups = {OnCreate.class, OnUpdate.class})
    String sku;
}
