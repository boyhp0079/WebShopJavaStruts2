/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.ProductDao;
import Model.Cart;
import Model.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 84911
 */
public class GetProductAction extends ActionSupport {

    private int pid;
    private String name;
    private String img;
    private float price;
    private String category;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    ProductDao productDao = new ProductDao();
    
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public GetProductAction() {
    }

    public String execute() throws Exception {
        Product product= productDao.getProduct(pid);
        if(product==null) return ERROR;
        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        img = product.getImg();
        return SUCCESS;
    }

    public String addtocart() throws Exception {
        //get product from database here
        Product p = productDao.getProduct(pid);
        if(p==null) return ERROR;
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addProductWamount(p,amount);
        ActionContext.getContext().getSession().put("cart", cart);
        return SUCCESS;
    }

}
