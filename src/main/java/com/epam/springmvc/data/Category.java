package com.epam.springmvc.data;

import java.util.List;

public class Category implements Entity {
    private String name;
    private List<Product> products;
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
