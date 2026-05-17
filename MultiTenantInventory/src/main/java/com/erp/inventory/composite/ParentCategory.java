package com.erp.inventory.composite;

import java.util.ArrayList;
import java.util.List;

public class ParentCategory extends CategoryComponent {

	private List<CategoryComponent> childCategories = new ArrayList<>();

	public ParentCategory(String categoryId, String categoryName) {

		super(categoryId, categoryName);
	}

	@Override
	public void add(CategoryComponent component) {

		childCategories.add(component);
	}

	@Override
	public void remove(CategoryComponent component) {

		childCategories.remove(component);
	}

	@Override
	public List<CategoryComponent> getChildren() {

		return childCategories;
	}

	@Override
	public void showCategoryHierarchy() {

		System.out.println("CATEGORY : " + categoryName);

		for (CategoryComponent component : childCategories) {

			component.showCategoryHierarchy();
		}
	}
}