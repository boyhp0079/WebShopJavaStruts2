/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84911
 */
public class ProductDao implements DBInfo{

        public List<String> getCategoryList(){
            List<String> CategoryList = new ArrayList<>();
                    try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("SELECT DISTINCT category FROM Product");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) 
                CategoryList.add(rs.getString(1));
            con.close();
            return CategoryList;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        }


    public List<Product> getProducts(){
        List<Product> products= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select pid, [name], img, price, category from Product");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) 
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),rs.getString(5)));
            con.close();
            return products;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<Product> getProductsBySearch(String search){
        List<Product> products = new ArrayList<Product>() ;
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select pid, [name], img, price, category from Product where [name] LIKE ?");
            stmt.setString(1, "%"+search+"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) 
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),rs.getString(5)));
            con.close();
            return products;
        } catch (Exception e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<Product> getProductsByCate(String category){
        List<Product> products= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select pid, [name], img, price, category from Product where category=?");
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) 
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),rs.getString(5)));
            con.close();
            return products;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public Product getProduct(int pid){
        Product product=null;
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select pid, [name], img, price, category from Product where pid=?");
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) 
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4),rs.getString(5));
            con.close();
            return product;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean deleteProduct(int pid){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Delete from Product where pid=?");
            stmt.setInt(1, pid);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

        public boolean updateProduct(int pid, String name, String img, float price, String category){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Update Product set [name]=?,img=?,price=?,category=? where pid=?");
            stmt.setString(1, name);
            stmt.setString(2, img);
            stmt.setFloat(3, price);
            stmt.setString(4, category);
            stmt.setInt(5, pid);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        }

        public boolean addProduct(String name, String img, float price, String category){
        Product product=null;
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("insert into Product([name],img,price,category)values (?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, img);
            stmt.setFloat(3, price);
            stmt.setString(4, category);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
