package com.ruksana.model;

public class Model_For_practice {

    String name,category,categoryQ;

    public Model_For_practice() {
    }

    public Model_For_practice(String name, String category, String categoryQ) {
        this.name = name;
        this.category = category;
        this.categoryQ = categoryQ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryQ() {
        return categoryQ;
    }

    public void setCategoryQ(String categoryQ) {
        this.categoryQ = categoryQ;
    }
}
