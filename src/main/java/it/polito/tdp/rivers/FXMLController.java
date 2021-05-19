/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.rivers;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Completamento;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model = new Model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
       
        setCombobox();
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    public void setCombobox() {
    	
    	Collection<River> fiumi = model.getTuttiFiumi();
    	
    	for (River rr: fiumi) {
    		boxRiver.getItems().add(rr);
    	}
    }
    
    @FXML
    void doCompletamento(ActionEvent event) {
    	txtStartDate.clear();
    	txtEndDate.clear();
    	txtNumMeasurements.clear();
    	txtFMed.clear();
    	
    	this.doCompletamento();
    }
    
    public void doCompletamento () {
    	txtStartDate.clear();
    	txtEndDate.clear();
    	txtNumMeasurements.clear();
    	txtFMed.clear();
    	
    	River fiume = boxRiver.getSelectionModel().getSelectedItem();
    	
    	Completamento comp = model.getCompletamento(fiume.getName());
    	String misurazione = Integer.toString(comp.getMisurazioni());
    	String flussoMedio = Float.toString(comp.getMediaFlusso());
    	txtStartDate.appendText(comp.getDataPiccola().toString());;
    	txtEndDate.appendText(comp.getDataGrande().toString());
    	txtNumMeasurements.setText(misurazione);
    	txtFMed.setText(flussoMedio);
    	
    	
    	
    }
}
