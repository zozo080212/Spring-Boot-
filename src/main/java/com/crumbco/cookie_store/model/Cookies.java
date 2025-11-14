package com.crumbco.cookie_store.model;

public class Cookies {
    private Long id;
    private String name;
    private String ingredients;
    private Double quantityOnHand;
    private Double costPer;

    public Cookies() {}

    public Cookies(Long id, String name, String ingredients, Double quantityOnHand, Double costPer) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.quantityOnHand = quantityOnHand;
        this.costPer = costPer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public Double getQuantityOnHand() { return quantityOnHand; }
    public void setQuantityOnHand(Double quantityOnHand) { this.quantityOnHand = quantityOnHand; }

    public Double getCostPer() { return costPer; }
    public void setCostPer(Double costPer) { this.costPer = costPer; }

    @Override
    public String toString() {
        return "Cookies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", quantityOnHand=" + quantityOnHand +
                ", costPer=" + costPer +
                '}';
    }
}