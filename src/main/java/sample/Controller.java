package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    Stage stage;
     @FXML
    Button task_new;
    @FXML
    ListView<String> list_ip, list_user,list_kab, list_task;

    @FXML
    Accordion List_main;
    @FXML
    TitledPane list_ip_slave, list_kab_slave, list_user_slave;

    ObservableList<String> list;
    ArrayList <String> tempList;


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

    public void buildListIP() throws SQLException   {
        Connect connect = new Connect();
        tempList = connect.getSQL("users","IP");
        list =  FXCollections.observableArrayList(tempList);
        list_ip.setItems(list);
        }

    public void buildListUser() throws SQLException {
        Connect connect = new Connect();
        tempList = connect.getSQL("users","Login");
        list =  FXCollections.observableArrayList(tempList);
        list_user.setItems(list);
    }

    public void buildListKab() throws SQLException {
        Connect connect = new Connect();
        tempList = connect.getSQL("users","KABINET");
        list =  FXCollections.observableArrayList(tempList);
        list_kab.setItems(list);
    }

    public void buildListTask() throws SQLException{
        Connect connect = new Connect();
        tempList = connect.getSQL("tasks","Task_name");
        list =  FXCollections.observableArrayList(tempList);
        list_task.setItems(list);
    }

//    public void initialize(URL location, ResourceBundle resources) {
//
//        try {
//            buildListTask();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            tempList.add("Заданий нет");
//        }

//    }
}

