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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.SekolahM;

/**
 *
 * @author hanif
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button bSave, bUpdate, bDelete, bClear;
    @FXML
    private TextField tnpsn, tnama, tCari, tGugus, tKab_Kota;
    @FXML
    TableView<Sekolah> tv;
    @FXML
    TableColumn<Sekolah, String> id, npsn, nama, gugus, kab_kota;

    SekolahM m = new SekolahM();
    ObservableList ols = FXCollections.observableArrayList();
    String key = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        read();
        save();
        update();
        clearField();
        find();
        delete();
        selectrow();
    }

    public void save() {
        bSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Sekolah b = new Sekolah();
                // b.setId(Integer.parseInt(key));
                b.setNpsn(tnpsn.getText());
                b.setNamaSekolah(tnama.getText());
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
                b.setNpsn(tnpsn.getText());
                b.setNamaSekolah(tnama.getText());
                b.setGugus(tGugus.getText());
                b.setKabKota(tKab_Kota.getText());
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
        bClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //  Sekolah b = new Sekolah();
                clear();

            }
        });
    }

    public void selectrow() {
        tv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int i = tv.getSelectionModel().getSelectedIndex();
                key = String.valueOf(id.getCellData(i));
                tnama.setText(nama.getCellData(i));
                tnpsn.setText(npsn.getCellData(i));
                tGugus.setText(gugus.getCellData(i));
                tKab_Kota.setText(kab_kota.getCellData(i));

            }
        });

    }

    public void find() {
        tCari.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                tv.getItems().clear();
                List<Sekolah> ls = m.find(tCari.getText());
                for (Sekolah l : ls) {
                    ols.add(l);

                }
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                npsn.setCellValueFactory(new PropertyValueFactory<>("npsn"));
                nama.setCellValueFactory(new PropertyValueFactory<>("namaSekolah"));
                gugus.setCellValueFactory(new PropertyValueFactory<>("gugus"));
                kab_kota.setCellValueFactory(new PropertyValueFactory<>("kabKota"));
                tv.setItems(ols);
            }
        });
    }

    public void read() {
        tv.getItems().clear();
        List<Sekolah> ls = m.read();
        for (Sekolah l : ls) {
            ols.add(l);

        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        npsn.setCellValueFactory(new PropertyValueFactory<>("npsn"));
        nama.setCellValueFactory(new PropertyValueFactory<>("namaSekolah"));
        kab_kota.setCellValueFactory(new PropertyValueFactory<>("kabKota"));
        gugus.setCellValueFactory(new PropertyValueFactory<>("gugus"));
        tv.setItems(ols);

    }

    public void clear() {
        key = null;
        tnpsn.clear();
        tnama.clear();
        tGugus.clear();
        tKab_Kota.clear();
    }
}
