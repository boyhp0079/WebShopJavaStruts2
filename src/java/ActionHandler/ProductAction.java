/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.ProductDao;
import Model.Product;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84911
 */
public class ProductAction extends ActionSupport {
    private int pid;
    private String name;
    private String img;
    private float price;
    private String category;
    private List<String> categoryList;

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
    ProductDao productDao = new ProductDao();



    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    
    public ProductAction() {
    }

    
    public String addproduct() throws Exception {
        if(productDao.addProduct(name, img, price, category))
            return SUCCESS;
        else
            return ERROR;
    }
    public String updateproduct() throws Exception {
        if(productDao.updateProduct(pid,name, img, price, category))
            return SUCCESS;
        else
            return ERROR;
    }
    public String deleteproduct() throws Exception {
        if(productDao.deleteProduct(pid))
            return SUCCESS;
        else
            return ERROR;
    }

    public ProductAction(int pid, String name, String img, float price, String category, List<String> categoryList) {
        this.pid = pid;
        this.name = name;
        this.img = img;
        this.price = price;
        this.category = category;
        this.categoryList = categoryList;
    }
    @Override
    public String execute() throws Exception {
        categoryList=new ProductDao().getCategoryList();
        return SUCCESS;
    }
    
}
