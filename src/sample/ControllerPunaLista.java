package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ControllerPunaLista implements Initializable{

    ControllerDodavanjeListe cdl =  new ControllerDodavanjeListe();
    @FXML private TableView<TaskDetails> taskTable;

    @FXML private TableColumn<TaskDetails,String> nameColumn;
    @FXML private TableColumn<TaskDetails,String> dateColumn;
    @FXML private TableColumn<TaskDetails, String> categoryColumn;
    private String choice;

    private ObservableList<TaskDetails> data;
    private DBConnection db;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));


        taskTable.setItems(data);
    }

    public void addNewTask(javafx.event.ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("dodajListu.fxml"));


        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public void removeTask(javafx.event.ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("RemoveTaskView.fxml"));


        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    public void filterSve()
    {
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        taskTable.setItems(data);
    }
    public void filterDefault()
    {
        choice = "Default";
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak where kategorija = '" + choice + "'");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));


        taskTable.setItems(data);
    }
    public void filterŠoping()
    {
        choice = "Šoping";
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak where kategorija = '" + choice + "'");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));


        taskTable.setItems(data);
    }
    public void filterPoslovno()
    {
        choice = "Poslovno";
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak where kategorija = '" + choice + "'");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));


        taskTable.setItems(data);
    }
    public void filterOsobno()
    {
        choice = "Osobno";
        db = new DBConnection();
        try {
            Connection conn = db.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("Select * from zadatak where kategorija = '" + choice + "'");

            while(rs.next())
            {
                data.add(new TaskDetails(rs.getString(1),rs.getString(2), rs.getString(3)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set cell value factory to tableview

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));


        taskTable.setItems(data);
    }
}
