/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Product {
    private int pid;
    private String name;
    private String img;
    private float price;
    private String category;


    public Product() {

    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(int pid, String name, String img, float price, String category) {
        this.pid = pid;
        this.name = name;
        this.img = img;
        this.price = price;
        this.category = category;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;

        return this.pid == other.pid;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.pid;
        return hash;
    }
}
