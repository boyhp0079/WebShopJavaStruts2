/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.ProductDao;
import Dao.UserDao;
import Model.Product;
import Model.User;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84911
 */
public class AdminAction extends ActionSupport {
    private List<Product> products = new ArrayList<>();
    private List<User> users= new ArrayList<>();
    ProductDao productDao = new ProductDao();
    private List<String> categoryList;

    UserDao userDao = new UserDao();


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
   public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
    public AdminAction() {
    }
    public String showproducts() throws Exception {
        categoryList = new ProductDao().getCategoryList();
        System.out.println("why:"+categoryList);
        products = productDao.getProducts();
        return SUCCESS;
    }
    public String showusers() throws Exception {
        users =  userDao.getUsers();
        return SUCCESS;
    }



}
