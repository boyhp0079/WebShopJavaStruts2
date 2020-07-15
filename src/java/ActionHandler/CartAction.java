/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Model.Cart;
import Model.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 84911
 */
public class CartAction extends ActionSupport {
    private Map<Product, Integer> products;
    private int pid;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
 

    public CartAction() {
    }
    
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        Cart cart = (Cart) session.get("cart");
        if(cart!=null){
        products = cart.getProducts();
        total = String.format("%.2f", cart.getTotalprice());
        }
        return SUCCESS;
    }
    public String remove() {
            Map session = ActionContext.getContext().getSession();
            Cart cart = (Cart) session.get("cart");
            cart.removeProduct(pid);
            session.put("cart", cart);
            return SUCCESS;
    }
    

}
