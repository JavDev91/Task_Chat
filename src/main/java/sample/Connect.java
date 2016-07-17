package sample;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by prog on 15.07.2016.
 */
public class Connect  {

    private String login = "root";
    private String password = "8323102";
    private String URL = "jdbc:mysql://10.41.0.111:3306";
    java.sql.Connection connection = null;


    public void toConnect() {

        try {
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            connection = DriverManager.getConnection(URL, login, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public void toDisconnect() throws SQLException {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    public static void main(String [] args) throws SQLException {
//
//        Connect connect = new Connect();
//        connect.toConnect();
//        System.out.println("Connect open");
//        connect.toDisconnect();
//        System.out.println("connect close");
//    }

}
