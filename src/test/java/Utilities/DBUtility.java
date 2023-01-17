package Utilities;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class DBUtility {
    public static Statement statement;
    public static Connection connection;


    public static ArrayList<ArrayList<String>> getListData(String query)  {
        // query : select * from city;

        ArrayList<ArrayList<String>> tablo=new ArrayList<>();
        // Db den butun satırları ve kolonları okuyup liste atıcam

        // 1 - db bağlantısını ac
        DBConnectionOpen();
        // 2- sorguyu çalıştır
        try {
            ResultSet rs = statement.executeQuery(query);
            int kolonSayisi = rs.getMetaData().getColumnCount();
            // 3- sorgu sonucu tabloya doldur
            while (rs.next()) {
                ArrayList<String> satir = new ArrayList<>();

                for (int i = 1; i <= kolonSayisi; i++)
                    satir.add(rs.getString(i));
                tablo.add(satir);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        // 4- db bağlantısını kapat
        DBConnectionClose();



        return tablo;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablo=getListData("select * from actor");

        for (List<String> satir:tablo) {

            System.out.println(satir);

        }
    }
    public static void DBConnectionOpen()
    {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
