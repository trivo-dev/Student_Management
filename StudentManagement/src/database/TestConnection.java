package database;

import database.DBConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if(conn != null) {
            System.out.println("Ket noi MySQL thanh cong!");
        } else {
            System.out.println("Ket noi that bai!");
        }

    }
    
}