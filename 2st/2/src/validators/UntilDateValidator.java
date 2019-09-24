package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UntilDateValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null) {
            String message = "Неверный формат срока действия карты";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "Хватит");
            throw new ValidatorException(facesMessage);
        }
    }
}
