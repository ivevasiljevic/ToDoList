package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerRemoveTaskView implements Initializable{

    private DBConnection db;
    @FXML private ChoiceBox<String> choice = new ChoiceBox<>();

    public void initialize(URL url, ResourceBundle rb)
    {
        db = new DBConnection();

        Connection conn = db.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from zadatak");
            choice.setValue(rs.getString(1));
            while(rs.next())
            {
                choice.getItems().add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(javafx.event.ActionEvent event) throws SQLException,IOException {
        Connection conn = db.getConnection();
        String sql = "delete from zadatak where ime_zadatka = '" + choice.getValue().toString() + "'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();


        ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak");

        if(!rs.isBeforeFirst())
        {
            Parent root = FXMLLoader.load(getClass().getResource("praznaLista.fxml"));

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("punaLista.fxml"));

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }

    }

    public void cancelDelete(javafx.event.ActionEvent event) throws IOException,SQLException
    {
        Connection conn  = db.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak");

        if(!rs.isBeforeFirst())
        {
            Parent root = FXMLLoader.load(getClass().getResource("praznaLista.fxml"));

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("punaLista.fxml"));

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
    }

}
