package beans;

import DAO.UserDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.FileWriter;
import java.util.Date;

@ManagedBean(name = "CardController")
@RequestScoped
public class CardController {
    private int cardId;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private String name;
    private Date dueDate;
    private int cvc;
    private int sum;

    public String doPayment() throws Exception {
//        System.out.println("/home/ITRANSITION.CORP/d.plotnikov/Documents/Itransition/kek.txt");
//        FileWriter fw = new FileWriter("/home/ITRANSITION.CORP/d.plotnikov/Documents/Itransition/kek.txt");
//        fw.write("kaban");
//        fw.close();
//        UserDAO userDao = new UserDAO();
        return "kaban/";
    }
}
