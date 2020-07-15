/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;


/**
 *
 * @author 84911
 */
public class buylog {
    private String username;
    private String name;
    private int amount;
    private float total;
    private String buydate;

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }




    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public buylog(String username, String name, int amount,float total,String buydate) {
        this.total = total;
        this.username = username;
        this.name = name;
        this.amount = amount;
        this.buydate = buydate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
