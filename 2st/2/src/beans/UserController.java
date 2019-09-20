package beans;

import DAO.UserDAO;
import models.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void checkUserExistence(User user) throws Exception {
        UserDAO userDAO = new UserDAO();
        FacesContext ctx = FacesContext.getCurrentInstance();
        int userId = userDAO.checkCredentials(user);
        if (userId == -1) {
            ctx.addMessage("loginForm:credentials", new FacesMessage(FacesMessage.SEVERITY_WARN, "Wrong password", "Check login/password couple"));
        }
    }

    private User user = new User();
}
