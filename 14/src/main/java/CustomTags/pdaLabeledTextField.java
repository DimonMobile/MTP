package CustomTags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class pdaLabeledTextField extends SimpleTagSupport {
    private String label;
    private String value;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void doTag() {
        try {
            getJspContext().getOut().println("<p><label>" + label +"</label><input name='" + name +
                    "' type='text' value='" + value + "'/></p>");
        } catch( IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
