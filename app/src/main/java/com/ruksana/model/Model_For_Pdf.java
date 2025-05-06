package com.ruksana.model;

public class Model_For_Pdf {

    String name,category,data;

    public Model_For_Pdf() {
    }

    public Model_For_Pdf(String name, String category, String data) {
        this.name = name;
        this.category = category;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
