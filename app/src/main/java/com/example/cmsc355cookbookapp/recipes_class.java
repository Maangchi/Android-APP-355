package com.example.cmsc355cookbookapp;

public class recipes_class {

    private int id;
    private String recipe;
    private String r_ing1;
    private int r_ing1_amt;
    private String r_ing1_amtType;
    private String r_ing2;
    private int r_ing2_amt;
    private String r_ing2_amtType;
    private String r_ing3;
    private int r_ing3_amt;
    private String r_ing3_amtType;

    // constructor
    public recipes_class(int id, String recipe, String r_ing1, int r_ing1_amt, String r_ing1_amtType, String r_ing2, int r_ing2_amt, String r_ing2_amtType, String r_ing3, int r_ing3_amt, String r_ing3_amtType) {
        this.id = id;
        this.recipe = recipe;
        this.r_ing1 = r_ing1;
        this.r_ing1_amt = r_ing1_amt;
        this.r_ing1_amtType = r_ing1_amtType;
        this.r_ing2 = r_ing2;
        this.r_ing2_amt = r_ing2_amt;
        this.r_ing2_amtType = r_ing2_amtType;
        this.r_ing3 = r_ing3;
        this.r_ing3_amt = r_ing3_amt;
        this.r_ing3_amtType = r_ing3_amtType;
    }

    public recipes_class() {
    }

    // toString is necessary fo rprinting the contenst of a class


    @Override
    public String toString() {
        return "recipes_class{" +
                "id=" + id +
                ", recipe='" + recipe + '\'' +
                ", r_ing1='" + r_ing1 + '\'' +
                ", r_ing2='" + r_ing2 + '\'' +
                ", r_ing3='" + r_ing3 + '\'' +
                ", r_ing1_amt=" + r_ing1_amt +
                ", r_ing2_amt=" + r_ing2_amt +
                ", r_ing3_amt=" + r_ing3_amt +
                ", r_ing1_amtType=" + r_ing1_amtType +
                ", r_ing2_amtType=" + r_ing2_amtType +
                ", r_ing3_amtType=" + r_ing3_amtType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getR_ing1() {
        return r_ing1;
    }

    public void setR_ing1(String r_ing1) {
        this.r_ing1 = r_ing1;
    }

    public String getR_ing2() {
        return r_ing2;
    }

    public void setR_ing2(String r_ing2) {
        this.r_ing2 = r_ing2;
    }

    public String getR_ing3() {
        return r_ing3;
    }

    public void setR_ing3(String r_ing3) {
        this.r_ing3 = r_ing3;
    }

    public int getR_ing1_amt() {
        return r_ing1_amt;
    }

    public void setR_ing1_amt(int r_ing1_amt) {
        this.r_ing1_amt = r_ing1_amt;
    }

    public int getR_ing2_amt() {
        return r_ing2_amt;
    }

    public void setR_ing2_amt(int r_ing2_amt) {
        this.r_ing2_amt = r_ing2_amt;
    }

    public int getR_ing3_amt() {
        return r_ing3_amt;
    }

    public void setR_ing3_amt(int r_ing3_amt) {
        this.r_ing3_amt = r_ing3_amt;
    }

    public String getR_ing1_amtType() {
        return r_ing1_amtType;
    }

    public void setR_ing1_amtType(String r_ing1_amtType) {
        this.r_ing1_amtType = r_ing1_amtType;
    }

    public String getR_ing2_amtType() {
        return r_ing2_amtType;
    }

    public void setR_ing2_amtType(String r_ing2_amtType) {
        this.r_ing2_amtType = r_ing2_amtType;
    }

    public String getR_ing3_amtType() {
        return r_ing3_amtType;
    }

    public void setR_ing3_amtType(String r_ing3_amtType) {
        this.r_ing3_amtType = r_ing3_amtType;
    }
}
