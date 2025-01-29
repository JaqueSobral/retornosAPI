package com.example.retornosAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @NotBlank(message = "A descrição é opcional.")
    @Size(max = 500, message = "Descrição deve ter até 500 caracteres.")
    private String description;


    @NotNull(message = "Preço é obrigatório.")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que 0.")
    private Double price;

    @NotNull(message = "Quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "Quantidade em estoque deve ser maior ou igual a 0.")
    private int stockQuantity;

    @NotBlank(message = "Categoria é obrigatória.")
    @Pattern(regexp = "Eletrônico|Vestuário|Alimentação", message = "Categoria inválida.")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}