package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;

public class Main extends Application {

    private DBConnection db;

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = new DBConnection();
        Connection conn  = db.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak");

        if(!rs.isBeforeFirst())
        {
            Parent root = FXMLLoader.load(getClass().getResource("praznaLista.fxml"));

            primaryStage.setTitle("To Do List");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("punaLista.fxml"));

            primaryStage.setTitle("To Do List");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
