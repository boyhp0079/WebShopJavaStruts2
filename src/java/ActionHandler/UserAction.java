/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author 84911
 */
public class UserAction extends ActionSupport {
    UserDao userDao = new UserDao();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    private int userid;
    private String username;
    private String password;
    private int role;
    public UserAction() {
    }
    
    public String adduser() throws Exception {
        if(userDao.addUser(username, password, role))
        return SUCCESS;
        else 
        return ERROR;
    }
    public String updateuser() throws Exception {
        userDao.updateUser(userid, password, role);
        return SUCCESS;
    }
    public String deleteuser() throws Exception {
        userDao.deleteUser(userid);
        return SUCCESS;
    }
    
}
