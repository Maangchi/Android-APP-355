package com.example.cmsc355cookbookapp;

public class Ingredients_class {

    private int ing_id;
    private String name;
    private int amount;
    private String Amount_type;
    private boolean need;

    //constructor
    public Ingredients_class(int ing_id, String name, int amount, String amount_type, boolean need) {
        this.ing_id = ing_id;
        this.name = name;
        this.amount = amount;
        Amount_type = amount_type;
        this.need = need;
    }

    public Ingredients_class() {
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

    public void convertAmountType(String amountTypeToBe) {
        if (this.Amount_type.equals(amountTypeToBe)) {
        }
        else if (amountTypeToBe.equals("Teaspoons")) {
            if (this.Amount_type.equals("Tablespoons")) {
                this.amount = this.amount * 3;
            }
            else if (this.Amount_type.equals("Cups")) {
                this.amount = this.amount * 48;
            }
            else if (this.Amount_type.equals("Pints")) {
                this.amount = this.amount * 96;
            }
            else if (this.Amount_type.equals("Quarts")) {
                this.amount = this.amount *  192;
            }
            else if (this.Amount_type.equals("Gallons")) {
                this.amount = this.amount *  768;
            }
            this.Amount_type = "Teaspoons";
        }
        else if (amountTypeToBe.equals("Tablespoons")) {
            if (this.Amount_type.equals("Teaspoons")) {
                this.amount = this.amount / 3;

            }
            else if (this.Amount_type.equals("Cups")) {
                this.amount = this.amount * 16;

            }
            else if (this.Amount_type.equals("Pints")) {
                this.amount = this.amount * 32;

            }
            else if (this.Amount_type.equals("Quarts")) {
                this.amount = this.amount * 64;
            }
            else if (this.Amount_type.equals("Gallons")) {
                this.amount = this.amount * 256;
            }
            this.Amount_type = "Tablespoons";
        }
        else if (amountTypeToBe.equals("Cups")) {
            if (this.Amount_type.equals("Teaspoons")) {
                this.amount = this.amount / 48;
            }
            else if (this.Amount_type.equals("Tablespoons")) {
                this.amount = this.amount / 16;
            }
            else if (this.Amount_type.equals("Pints")) {
                this.amount = this.amount * 2;
            }
            else if (this.Amount_type.equals("Quarts")) {
                this.amount = this.amount * 4;
            }
            else if (this.Amount_type.equals("Gallons")) {
                this.amount = this.amount * 16;
            }
            this.Amount_type = "Cups";

        }
        else if (amountTypeToBe.equals("Pints")) {
            if (this.Amount_type.equals("Teaspoons")) {
                this.amount = this.amount * 96;
            }
            else if (this.Amount_type.equals("Tablespoons")) {
                this.amount = this.amount * 32;
            }
            else if (this.Amount_type.equals("Cups")) {
                this.amount = this.amount * 2;
            }
            else if (this.Amount_type.equals("Quarts")) {
                this.amount = this.amount / 2;
            }
            else if (this.Amount_type.equals("Gallons")) {
                this.amount = this.amount / 8;
            }
            this.Amount_type = "Pints";

        }
        else if (amountTypeToBe.equals("Quarts")) {
            if (this.Amount_type.equals("Teaspoons")) {
                this.amount = this.amount / 192;
            }
            else if (this.Amount_type.equals("Tablespoons")) {
                this.amount = this.amount / 64;
            }
            else if (this.Amount_type.equals("Cups")) {
                this.amount = this.amount / 4;
            }
            else if (this.Amount_type.equals("Pints")) {
                this.amount = this.amount / 2;
            }
            else if (this.Amount_type.equals("Gallons")) {
                this.amount = this.amount * 4;
            }
            this.Amount_type = "Quarts";

        }
        else if (amountTypeToBe.equals("Gallons")) {
            if (this.Amount_type.equals("Teaspoons")) {
                this.amount = this.amount / 769;
            }
            else if (this.Amount_type.equals("Tablespoons")) {
                this.amount = this.amount / 256;
            }
            else if (this.Amount_type.equals("Cups")) {
                this.amount = this.amount / 16;
            }
            else if (this.Amount_type.equals("Pints")) {
                this.amount = this.amount / 8;
            }
            else if (this.Amount_type.equals("Quarts")) {
                this.amount = this.amount / 4;
            }
            this.Amount_type = "Gallons";

        }
        else if (amountTypeToBe.equals("Ounces")) {
            if(this.Amount_type.equals("Pounds")){
                this.amount = this.amount * 16;
            }
            this.Amount_type = "Ounces";

        }
        else if (amountTypeToBe.equals("Pounds")) {
            if(this.Amount_type.equals("Ounces")){
                this.amount = this.amount / 16;
            }
            this.Amount_type = "Pounds";

        }
        else if (amountTypeToBe.equals("Grams")) {
            if(this.Amount_type.equals("Kilograms")){
                this.amount = this.amount * 100;
            }
            this.Amount_type = "Grams";

        }
        else if (amountTypeToBe.equals("Kilograms")) {
            if(this.Amount_type.equals("Grams")){
                this.amount = this.amount / 100;
            }
            this.Amount_type = "Kilograms";

        }
        else if (amountTypeToBe.equals("Liters")) {
            if(this.Amount_type.equals("MilliLiters")){
                this.amount = this.amount / 100;
            }
            this.Amount_type = "Liters";

        }
        else if (amountTypeToBe.equals("MilliLiters")) {
            if(this.Amount_type.equals("Liters")){
                this.amount = this.amount * 100;
            }
            this.Amount_type = "MilliLiters";
        }
    }
}
