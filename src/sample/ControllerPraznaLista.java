package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerPraznaLista {

    private ControllerDodavanjeListe cdl = new ControllerDodavanjeListe();
    public void change(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("dodajListu.fxml"));


        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }



}
