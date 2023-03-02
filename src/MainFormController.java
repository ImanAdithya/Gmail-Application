import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.mail.MessagingException;

public class MainFormController {
    public TextField txtFrom;
    public TextField txtTo;
    public TextField txtSubject;
    public TextArea textArea;
    public AnchorPane MainFormContext;

    public void SendOnAction(ActionEvent actionEvent) {
        try {
            sendMail.outMail(textArea.getText(),txtTo.getText(),txtSubject.getText());
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        textArea.clear();
        txtFrom.clear();;
        txtSubject.clear();
        txtTo.clear();
    }
}
