package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Katie on 9/25/2017.
 */
public class DAO {

    public static boolean addLink(
            String Name,
            String Description,
            String Date,
            String URL,
            String Category
    ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DAOCredentials.DB_ADDRESS,
                    DAOCredentials.USERNAME,
                    DAOCredentials.PASSWORD);

            String addLinkCommand = "INSERT INTO bookmarks " +
                    "(name, description, date, url, category)" +
                    "VALUES ('" +
                    Name + "', '" +
                    Description + "', '" +
                    Date + "', '" +
                    URL + "', '" +
                    Category +
                    "')";

            Statement st = mysqlConnection.createStatement();

            int result = st.executeUpdate(addLinkCommand);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static ArrayList<bottomAdded> getBottomAdded() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DAOCredentials.DB_ADDRESS,
                    DAOCredentials.USERNAME,
                    DAOCredentials.PASSWORD);

            String getBottomAddedCommand = "SELECT name, url, category FROM bookmarks ORDER BY idbookmarks DESC LIMIT 15;";

            Statement readGetBottom = mysqlConnection.createStatement();

            ResultSet result = readGetBottom.executeQuery(getBottomAddedCommand);

            ArrayList<bottomAdded> recentList = new ArrayList<bottomAdded>();

            while(result.next()) {
                bottomAdded temp = new bottomAdded(result.getString(1), result.getString(2), result.getString(3));

                recentList.add(temp);
            }

            return recentList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static ArrayList<categories> getAllCategories() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DAOCredentials.DB_ADDRESS,
                    DAOCredentials.USERNAME,
                    DAOCredentials.PASSWORD);

            String getAllCategories = "SELECT DISTINCT category from bookmarks;";

            Statement readAllCategories = mysqlConnection.createStatement();

            ResultSet result = readAllCategories.executeQuery(getAllCategories);

            ArrayList<categories> categoryList = new ArrayList<categories>();

            while (result.next()) {
                categories temp = new categories(result.getString(1));

                categoryList.add(temp);
            }

            return categoryList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Information> getInformation (String Category) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DAOCredentials.DB_ADDRESS,
                    DAOCredentials.USERNAME,
                    DAOCredentials.PASSWORD);

            PreparedStatement getInformationCommand = mysqlConnection.prepareStatement("SELECT name, description, url, date, category FROM bookmarks WHERE category = ?");

           getInformationCommand.setString(1, Category);

            ResultSet result = getInformationCommand.executeQuery();

            ArrayList<Information> informationList = new ArrayList<Information>();

            while(result.next()) {
                Information temp = new Information(result.getString(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5));

                informationList.add(temp);
            }

            return informationList;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


}