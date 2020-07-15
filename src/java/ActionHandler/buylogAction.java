/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionHandler;

import Dao.BuyLogDao;
import Model.Cart;
import Model.Product;
import Model.User;
import Model.buylog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84911
 */
public class buylogAction extends ActionSupport {
    BuyLogDao buyLogDao = new BuyLogDao();
    private List<buylog> buylogs = new ArrayList<>();
    private int userid;
    private int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    public List<buylog> getBuylogs() {
        return buylogs;
    }

    public void setBuylogs(List<buylog> buylogs) {
        this.buylogs = buylogs;
    }
    public buylogAction() {
        
    }
    @Override
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        userid = user.getUserid();
        buylogs = buyLogDao.getBuyLogsbyUser(userid);
        return SUCCESS;
    }
 
    public String getalllog() throws Exception {
        buylogs = buyLogDao.getBuyLogs();
        return SUCCESS;
    }
    public String addlog() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        Cart cart = (Cart) session.get("cart");
         for (Map.Entry<Product,Integer> entry : cart.getProducts().entrySet()){
             Product temp =(Product)entry.getKey();
            buyLogDao.addbuylog(userid,temp.getPid(), entry.getValue());
         }
        session.remove("cart");
        return SUCCESS;
    }

}
