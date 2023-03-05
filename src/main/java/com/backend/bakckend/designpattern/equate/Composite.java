package com.backend.bakckend.designpattern.equate;


import java.util.ArrayList;

abstract class ProductCategory {
    int id;
    String name;
    int price;

    public ProductCategory(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void addProduct(ProductCategory productCategory);

    public abstract void removeProduct(ProductCategory productCategory);

    public abstract int getCount();

    public abstract int getPrice();

    public abstract int getId();

    public abstract String getName();
}

class Product extends ProductCategory {

    public Product(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public void addProduct(ProductCategory productCategory) {
        System.out.println("Can't add product");
    }

    @Override
    public void removeProduct(ProductCategory productCategory) {
        System.out.println("Can't remove product");
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}


class Category extends ProductCategory {
    ArrayList<ProductCategory> productCategories;

    public Category(int id, String name, int price) {
        super(id, name, price);
        productCategories = new ArrayList<ProductCategory>();
    }

    @Override
    public void addProduct(ProductCategory productCategory) {
        productCategories.add(productCategory);
    }

    @Override
    public void removeProduct(ProductCategory productCategory) {
        for (ProductCategory temp : productCategories) {
            if (temp.getId() == productCategory.getId()){
                productCategories.remove(temp);
                return;
            }

        }
    }

    @Override
    public int getCount() {
        int count = 0;
        for (ProductCategory temp : productCategories) {
            count += temp.getCount();
        }
        return count;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (ProductCategory temp : productCategories) {
            price += temp.getPrice();
        }
        return price;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}


public class Composite {

    public static void main(String[] args) {
        ProductCategory womanCategory = new Category(1, "lady", 0);
        ProductCategory manCategory   = new Category(2, "man", 0);

        ProductCategory clothesCategoryW = new Category(2345,"clothes",0);
        ProductCategory bagCategoryW = new Category(2346,"bag",0);
        ProductCategory shoesCategoryW = new Category(2347,"shoes",0);

        womanCategory.addProduct(clothesCategoryW);
        womanCategory.addProduct(bagCategoryW);
        womanCategory.addProduct(shoesCategoryW);

        ProductCategory clothesCategoryM = new Category(2348,"clothes",0);
        ProductCategory bagCategoryM = new Category(2349,"bag",0);
        ProductCategory shoesCategoryM = new Category(2350,"shoes",0);

        manCategory.addProduct(clothesCategoryM);
        manCategory.addProduct(bagCategoryM);
        manCategory.addProduct(shoesCategoryM);

        ProductCategory shoes1 = new Product(2351,"nike",1);
        ProductCategory shoes2 = new Product(2352,"adidas",2);
        ProductCategory shoes3 = new Product(2353,"gucci",3);
        ProductCategory shoes4 = new Product(2354,"puma",4);
        ProductCategory shoes5 = new Product(2355,"prada",5);
        ProductCategory shoes6 = new Product(2356,"chanel",6);

        shoesCategoryW.addProduct(shoes1);
        shoesCategoryW.addProduct(shoes2);
        shoesCategoryW.addProduct(shoes3);

        shoesCategoryM.addProduct(shoes4);
        shoesCategoryM.addProduct(shoes5);
        shoesCategoryM.addProduct(shoes6);

        ProductCategory bag1 = new Product(2351,"lv",100);
        ProductCategory bag2 = new Product(2352,"gucci",200);
        ProductCategory bag3 = new Product(2353,"chanel",300);
        ProductCategory bag4 = new Product(2354,"dior",400);
        ProductCategory bag5 = new Product(2355,"prada",500);
        ProductCategory bag6 = new Product(2356,"puma",600);

        bagCategoryW.addProduct(bag1);
        bagCategoryW.addProduct(bag2);
        bagCategoryW.addProduct(bag3);

        bagCategoryM.addProduct(bag4);
        bagCategoryM.addProduct(bag5);
        bagCategoryM.addProduct(bag6);

        System.out.println(womanCategory.getCount());
        System.out.println(womanCategory.getPrice());
        System.out.println(manCategory.getCount());
        System.out.println(manCategory.getPrice());

    }
}
