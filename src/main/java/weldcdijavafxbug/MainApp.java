package weldcdijavafxbug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MainApp extends Application {

    private Weld weld;
    private WeldContainer container;

    @Override
    public final void init() {
        weld = new Weld();
        container = weld.initialize();
    }

    @Override
    public final void stop() {
        weld.shutdown();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmll = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"), null);
        fxmll.setControllerFactory((clazz) -> container.instance().select(clazz).get());
        Parent root = fxmll.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
