package sample;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prog on 15.07.2016.
 */
public class Connect  {

    private String login = "root";
    private String password = "8323102";
    private String URL = "jdbc:mysql://10.41.0.111:3306";
    String column;
    Statement statement;
    ResultSet rs;
    List<String> listSql;



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

    public List<String> getSQL(String column) throws SQLException {

        this.column = column;
        String query = "SELECT " + column + " FROM taskchat.users ";
        toConnect();
        statement = connection.createStatement();
        rs = statement.executeQuery(query);
        listSql = new ArrayList<String>();

        while (rs.next()) {
            listSql.add(rs.getString(1));
        }
        toDisconnect();
        return listSql;
    }



//    public static void main(String [] args) throws SQLException {
//
//        Connect connect = new Connect();
//        connect.getSQL("login");
//
//
//    }

}
