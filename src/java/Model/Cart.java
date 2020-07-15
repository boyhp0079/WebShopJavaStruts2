
package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

    private final Map<Product, Integer> cart = new HashMap<Product, Integer>();

    public Cart() {
    }

    public void addProduct(Product p) {
        Integer amount = cart.get(p);
        cart.put(p, amount==null?1:(amount + 1));
    }
    
    public void addProductWamount(Product p,Integer amount) {
        Integer preamount = cart.get(p);
        cart.put(p, preamount==null?amount:(preamount + amount));
    }
    public void removeProduct(int pid) {
        for(Iterator<Product> iterator = cart.keySet().iterator(); iterator.hasNext(); ) {
          Product key = iterator.next();
          if(key.getPid()== pid) {
            iterator.remove();
          }
        }
    }
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProductWamount(new Product(0, "dsa", "dsad", Float.parseFloat("0.32"), "dsad"),5);
        cart.addProductWamount(new Product(0, "dsa", "dsad", Float.parseFloat("0.32"), "dsad"),5);

        System.out.println(cart.getProducts().keySet());
    }
    public Map<Product, Integer> getProducts() {
        return cart;
    }

    public float getTotalprice() {
        float total = 0;
        Set<Product> keys = cart.keySet();
        for (Product product : keys) {
            total += product.getPrice()* cart.get(product);
        }
        return total;
    }
}
