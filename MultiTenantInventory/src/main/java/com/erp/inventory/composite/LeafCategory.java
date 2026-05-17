package com.erp.inventory.composite;

public class LeafCategory extends CategoryComponent {

	public LeafCategory(String categoryId, String categoryName) {

		super(categoryId, categoryName);
	}

	@Override
	public void showCategoryHierarchy() {

		System.out.println("   SUB CATEGORY : " + categoryName);
	}
}