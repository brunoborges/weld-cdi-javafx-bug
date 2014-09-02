package weldcdijavafxbug;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FXMLController {

    public FXMLController() {
        System.out.println("This constructur will be called twice! See output");
        System.out.println("Thread: " + Thread.currentThread().hashCode() + " " + Thread.currentThread().getName());
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

}
