package com.example.cmsc355cookbookapp;

class Ingredients_class {

    private int ing_id;
    private String name;
    private int amount;
    private String Amount_type;
    private boolean need;

    //constructor
    public Ingredients_class (int ing_id, String name, int amount, String amount_type, boolean need) {
        this.ing_id = ing_id;
        this.name = name;
        this.amount = amount;
        Amount_type = amount_type;
        this.need = need;
    }
    //toString


    @Override
    public String toString() {
        return "Ingrediates_class{" +
                "ing_id=" + ing_id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", Amount_type='" + Amount_type + '\'' +
                ", need=" + need +
                '}';
    }

    //getters and setters
    public void setIng_id(int ing_id) {
        this.ing_id = ing_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAmount_type(String amount_type) {
        Amount_type = amount_type;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getIng_id() {
        return ing_id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getAmount_type() {
        return Amount_type;
    }

    public boolean isNeed() {
        return need;
    }

}
