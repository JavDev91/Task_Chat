package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage primaryStage;
    BorderPane rootLayout;
    AnchorPane center;
    AnchorPane right;
    ScrollPane left;

    @FXML
    ListView list_ip;

    @Override
    public void start(Stage primaryStage) throws Exception{

            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Chat");
            initRootLayout();
            showCenter();
            showRight();
            showLeft();


        //
//        connect.getSQL("Login");
//        connect.getSQL("KABINET.COMP");


    }


    public void initRootLayout() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/chat_stage.fxml"));
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();




    }

    public void showCenter() throws  Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/sample_center.fxml"));
        center = loader.load();
        rootLayout.setCenter(center);

    }

    public void showRight() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("/sample_right.fxml"));
        right = fxmlLoader.load();
        rootLayout.setRight(right);
    }

    public  void showLeft() throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("/sample_left.fxml"));
        left = fxmlLoader.load();
        rootLayout.setLeft(left);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
