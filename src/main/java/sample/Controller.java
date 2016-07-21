package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller <String> extends Control {

    @FXML
    Stage stage;
     @FXML
    Button task_new;
    @FXML
    ListView <String> list_ip;
    @FXML
    ListView list_user;
    @FXML
    ListView list_task;

    ArrayList <String> tempList;




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

    @FXML
    public void buildList() throws SQLException {


        Connect connect = new Connect();
        tempList = (ArrayList<String>) connect.getSQL("IP");
        System.out.println(tempList);
        ObservableList <String> list_ip_view =  FXCollections.observableArrayList(tempList);
        list_ip = new ListView(list_ip_view);
        list_ip.



    }
}

