/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.UserDao;
import Model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author 84911
 */
public class LoginAction extends ActionSupport {

    private int userid;
    private String username;
    private String password;
    private String password2;
    private int role;
    UserDao userDao = new UserDao();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginAction() {
    }

    public String execute() throws Exception {
        User user = userDao.login(username, password);
        if (user != null) {
            Map session = (Map) ActionContext.getContext().getSession();
            session.put("user", user);
            session.put("logged_in", true);
            return SUCCESS;
        } else {
            msg = "Wrong username or password";
            return ERROR;
        }
    }

    public String signup() throws Exception {
        System.out.println("jjj:"+password+" : "+password2);
        if (!password2.equals(password)) {
            msg = "Pass1 and Pass2 not the same!";
            return ERROR;
        } else if (userDao.signup(username, password)) {
            msg = "SUCCESS";
        }
        return SUCCESS;
    }

    public String logout() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        session.remove("logged_in");
        return SUCCESS;
    }

    public String getprofile() throws Exception {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        username = user.getUsername();
        password = user.getPassword();
        role = user.getRole();
        userid = user.getUserid();

        return SUCCESS;
    }

    public String updateprofile() throws Exception {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        if (userDao.updatePassword(user.getUserid(), password)) {
            user.setPassword(password);
            session.put("user", user);
            return SUCCESS;
        } else {
            session.put("user", user);
            return ERROR;
        }

    }

}
