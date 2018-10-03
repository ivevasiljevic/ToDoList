package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

public class ControllerDodavanjeListe implements Initializable{
    @FXML
    private TextField text;
    @FXML
    private DatePicker date;
    @FXML
    private ChoiceBox<String> choice = new ChoiceBox<>();
    private DBConnection db;

    public void initialize(URL url, ResourceBundle rb)
    {
        db = new DBConnection();
        choice.getItems().add("Default");
        choice.getItems().add("Osobno");
        choice.getItems().add("Šoping");
        choice.getItems().add("Poslovno");

        choice.setValue("Default");
    }

    public void addToDataBase(String text, String date,String izbor) throws SQLException {

        Connection conn = db.getConnection();
        String sql = "INSERT INTO zadatak VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, text);
        pstmt.setString(2, date);
        pstmt.setString(3, izbor);
        pstmt.executeUpdate();


    }

    public void changeToTableView(ActionEvent event) throws IOException,SQLException
    {
        addToDataBase(text.getText().toString(),date.getValue().toString(),choice.getValue().toString());
        Parent root = FXMLLoader.load(getClass().getResource("punaLista.fxml"));

        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public void cancelChange(ActionEvent event) throws IOException,SQLException
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
