package weldcdijavafxbug;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FXMLController implements Initializable {

    public FXMLController() {
        System.out.println("This constructur will be called twice! See output");
        new Exception("STACKTRACE OUTPUT").printStackTrace();
    }

    @PostConstruct
    public void init() {
        System.out.println("This method will be called only once!");
    }

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Controller initialized");
    }
}
