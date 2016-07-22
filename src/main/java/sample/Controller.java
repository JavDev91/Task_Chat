package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller  {

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


    Object [] tempList;




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
    public void buildList() throws SQLException   {

        String IP = "IP";
        Connect connect = new Connect();
        tempList = connect.getSQL(IP);
        ObservableList list =  FXCollections.observableArrayList(tempList);

        list_ip.setItems(list);

        }



}

