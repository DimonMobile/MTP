package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name = "CardController")
@RequestScoped
public class CardController {
    private int cardId;
    private String name;
    private Date dueDate;
    private int cvc;
    private int sum;

    public void doPayment() {

    }
}
