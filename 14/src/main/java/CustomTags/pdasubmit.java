package CustomTags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class pdasubmit extends SimpleTagSupport {
    @Override
    public void doTag() {
        try {
            getJspContext().getOut().println("<input type=submit value='Вход'/><input type=submit value='Регистрация'/>");
        } catch( IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
