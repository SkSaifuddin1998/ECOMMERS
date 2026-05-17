package com.erp.inventory.composite;

import java.util.Collections;
import java.util.List;

public abstract class CategoryComponent {

    public  String categoryId;
    public String categoryName;

    public CategoryComponent(String categoryId,
                             String categoryName) {

        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public void add(CategoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(CategoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public List<CategoryComponent> getChildren() {
        return Collections.emptyList();
    }

    public abstract void showCategoryHierarchy();
}