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
public class AllProductAction extends ActionSupport {
    private List<Product> ProductList = new ArrayList();
    private String category;
    private String searchString;

  
    private List<String> CategoryList = new ArrayList<>();
    
    public List<String> getCategoryList() {
        return CategoryList;
    }
  public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
    public void setCategoryList(List<String> CategoryList) {
        this.CategoryList = CategoryList;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<Product> getProductList() {
        return ProductList;
    }

    public void setProductList(List<Product> ProductList) {
        this.ProductList = ProductList;
    }
    public AllProductAction() {
    }
    
    public String execute() throws Exception {
        CategoryList = new ProductDao().getCategoryList();
        
        if(category != null && !category.isEmpty()){
            for (String cateString : CategoryList) 
                if(cateString.equalsIgnoreCase(category))
                    ProductList = new ProductDao().getProductsByCate(category);
        }
        else ProductList= new ProductDao().getProducts();
        return SUCCESS;
    }
    public String findproducts(){
        CategoryList = new ProductDao().getCategoryList();
        ProductList = new ProductDao().getProductsBySearch(searchString);
        return SUCCESS;
    }
}
