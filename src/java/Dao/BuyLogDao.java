/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Product;
import Model.buylog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84911
 */
public class BuyLogDao implements DBInfo{
    
    public List<buylog> getBuyLogs(){
        List<buylog> buylogs= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("SELECT Users.username, Product.[name],Buylog.amount,Product.price*Buylog.amount as total,buydate FROM Buylog JOIN Users ON Users.userid = Buylog.userid JOIN Product ON Product.pid = Buylog.pid");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Timestamp time = rs.getTimestamp("buydate");
                String formated = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(time);
                buylogs.add(new buylog(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),formated));
            }
            con.close();
            return buylogs;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public static void main(String[] args) {
        List<buylog> logs = new BuyLogDao().getBuyLogs();
        for (buylog log : logs) {
            System.out.println(log.getBuydate());
        }
    }
    public List<buylog> getBuyLogsbyUser(int userid){
        List<buylog> buylogs= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("SELECT Users.username, Product.[name],Buylog.amount,Product.price*Buylog.amount as total,buydate FROM Buylog JOIN Users ON Users.userid = Buylog.userid JOIN Product ON Product.pid = Buylog.pid where Users.userid = ?");
            stmt.setInt(1, userid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Timestamp time = rs.getTimestamp("buydate");
                String formated = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(time);
                buylogs.add(new buylog(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),formated));
            }
            con.close();
            return buylogs;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
     public boolean addbuylog(int userid,int pid,int amount){
        List<buylog> buylogs= new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbURL, userDB, passDB);){
            Class.forName(driverName);
            PreparedStatement stmt = con.prepareStatement("insert into Buylog(userid,pid,amount) values(?,?,?)");
            stmt.setInt(1, userid);
            stmt.setInt(2, pid);
            stmt.setInt(3, amount);
            int rs = stmt.executeUpdate();
            con.close();
            return rs>0;
        } catch (Exception e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
