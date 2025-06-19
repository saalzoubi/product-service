package com.se.product_service.dto.request;

import lombok.*;

import jakarta.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class addProductRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String description;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price Min value is 0")
    @Max(value = 1000, message = "Price Max value is 1000")
    private Double price;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity min value is 0")
    @Max(value = 1000, message = "Quantity max value is 1000")
    private Integer quantity;
}

