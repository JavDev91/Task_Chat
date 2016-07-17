package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller  {
    @FXML
    Stage stage;


    @FXML
    Button task_new;

//    @FXML
//    public void initialize() {
//
//        });
//    }

        @FXML
        private void task_new()  {
            Stage stage = new Stage();
            openDia1(stage);
        }
        @FXML
        protected void openDia1(Stage stage)  {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/task_new.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }


    @FXML
    public void onClick() {
        Controller controller = new Controller();
        controller.task_new();
        controller.openDia1(stage);




    }
}

