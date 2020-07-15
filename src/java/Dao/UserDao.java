/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User;
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
public class UserDao implements DBInfo{
    
    public User login(String username,String password){
        User b=null;
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select userid, username, [password], urole from Users where username = ? and [password] = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                b = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            con.close();
            return b;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean signup(String username,String password){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("insert into Users(username,[password],urole) values (?,?,?)");
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setInt(3,1);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public List<User> getUsers(){
        List<User> users= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select userid, username, [password], urole from Users");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) 
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            
            con.close();
            return users;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean updatePassword(int userid,String password){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Update Users set [password] = ? where userid = ?");
            stmt.setString(1,password);
            stmt.setInt(2,userid);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public User getUser(int userid){
        User b=null;
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Select userid, username, [password], urole from Users where userid = ?");
            stmt.setInt(1,userid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                b = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            con.close();
            return b;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    //=======================admin 
    public boolean updateUser(int userid,String password,int role){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Update Users set [password] = ?,urole=? where userid = ?");
            stmt.setString(1,password);
            stmt.setInt(2,role);
            stmt.setInt(3,userid);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean addUser(String username,String password,int role){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("insert into Users(username,[password],urole) values (?,?,?)");
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setInt(3,role);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean deleteUser(int userid){
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("Delete from Users where userid = ?");
            stmt.setInt(1,userid);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
