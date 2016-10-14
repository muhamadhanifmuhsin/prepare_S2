/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hanif
 */
public class FXMLMainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ListView<String> lvMaster;
    @FXML
    private TabPane tPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadListView();
        selectMenu();
    } 
    
    private void loadListView(){
        ObservableList<String> ols = FXCollections.observableArrayList();
        ols.add("Data Sekolah");
        ols.add("Data Guru");
        lvMaster.setItems(ols);
    }
    
    private void selectMenu(){
        lvMaster.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            int i = lvMaster.getSelectionModel().getSelectedIndex();
            if(i==0){
                try {
                    Node node = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLMasterSekolah.fxml"));
                    Tab tb = new Tab("Data Sekolah",node);
                    tPane.getTabs().add(tb);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
            });
    }
    
    
    
}
