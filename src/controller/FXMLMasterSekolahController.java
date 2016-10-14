/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Sekolah;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.SekolahM;

/**
 * FXML Controller class
 *
 * @author hanif
 */
public class FXMLMasterSekolahController implements Initializable {

    @FXML
    private Button bSave, bUpdate, bDelete, bClearField;
    @FXML
    private TextField tNpsn, tNama, tCari, tGugus, tKab_Kota;
    @FXML
    private TextArea txAlamat;
    @FXML
    TableView<Sekolah> tvMasterSekolah;
    @FXML
    TableColumn<Sekolah, String> id, npsn, nama, gugus, kabKota, alamat;

    SekolahM m = new SekolahM();
    ObservableList ols = FXCollections.observableArrayList();
    String key = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        read();
        selectrow();
        save();
        update();
        delete();
        clearField();
        find();

    }

    public void read() {
        tvMasterSekolah.getItems().clear();
        List<Sekolah> ls = m.read();
        for (Sekolah l : ls) {
            ols.add(l);

        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        npsn.setCellValueFactory(new PropertyValueFactory<>("npsn"));
        nama.setCellValueFactory(new PropertyValueFactory<>("namaSekolah"));
        kabKota.setCellValueFactory(new PropertyValueFactory<>("kabKota"));
        gugus.setCellValueFactory(new PropertyValueFactory<>("gugus"));
        alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));

        tvMasterSekolah.setItems(ols);

    }

    public void save() {
        bSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Sekolah b = new Sekolah();
                // b.setId(Integer.parseInt(key));
                b.setNpsn(tNpsn.getText());
                b.setNamaSekolah(tNama.getText());
                b.setGugus(tGugus.getText());
                b.setKabKota(tKab_Kota.getText());
                m.save(b);
                clear();
                read();
            }
        });
    }

    public void update() {
        bUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Sekolah b = new Sekolah();
                b.setId(Integer.parseInt(key));
                b.setNpsn(tNpsn.getText());
                b.setNamaSekolah(tNama.getText());
                b.setGugus(tGugus.getText());
                b.setKabKota(tKab_Kota.getText());
                b.setAlamat(txAlamat.getText());
                m.update(b);
                clear();
                read();
            }
        });
    }

    public void delete() {
        bDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Sekolah b = new Sekolah();
                b.setId(Integer.parseInt(key));
                m.delete(b);
                clear();
                read();
            }
        });
    }

    public void clearField() {
        bClearField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //  Sekolah b = new Sekolah();
                clear();

            }
        });
    }

    public void selectrow() {
        tvMasterSekolah.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int i = tvMasterSekolah.getSelectionModel().getSelectedIndex();
                key = String.valueOf(id.getCellData(i));
                tNama.setText(nama.getCellData(i));
                tNpsn.setText(npsn.getCellData(i));
                tGugus.setText(gugus.getCellData(i));
                tKab_Kota.setText(kabKota.getCellData(i));
                txAlamat.setText(alamat.getCellData(i));

            }
        });

    }

    public void find() {
        tCari.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                tvMasterSekolah.getItems().clear();
                List<Sekolah> ls = m.find(tCari.getText());
                for (Sekolah l : ls) {
                    ols.add(l);

                }
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                npsn.setCellValueFactory(new PropertyValueFactory<>("npsn"));
                nama.setCellValueFactory(new PropertyValueFactory<>("namaSekolah"));
                gugus.setCellValueFactory(new PropertyValueFactory<>("gugus"));
                kabKota.setCellValueFactory(new PropertyValueFactory<>("kabKota"));
                alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
                tvMasterSekolah.setItems(ols);
            }
        });
    }

    public void clear() {
        key = null;
        tNpsn.clear();
        tNama.clear();
        tGugus.clear();
        tKab_Kota.clear();
        txAlamat.clear();
    }
}
