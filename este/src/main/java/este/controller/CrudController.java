/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package este.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import este.dao.CrudDAO;
import este.exceptions.CrudInsertException;
import este.exceptions.CrudListException;
import este.exceptions.CrudRemoveException;
import este.model.Crud;
import este.util.AlertsUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Machado
 */
public class CrudController implements Initializable {
	@FXML
	TableView<Crud> crudTableView;
	@FXML
	TableColumn<Crud, String> nomeTableColumn;
	@FXML
	private TextField nomeTextField;
	@FXML
	private Button removeCrudButton;
	@FXML
	private Button editCrudButton;
	@FXML
	private Button updateCrudButton;
	@FXML
	private Button addCrudButton;
	
	CrudDAO dao = new CrudDAO();
	Crud person = new Crud();
	private ObservableList<Crud> crudO = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resources) {
		updateCrudButton.setVisible(false);
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Crud, String>("nome"));
		crudTableView.setItems(getCrud());
	}

	public void addOrUpdateCrud(ActionEvent event) {
		String nome = nomeTextField.getText();

		if (!nome.isEmpty()) {
			person.setNome(nome);
			if (this.addCrudButton.isVisible()) {
				try {
					dao.insertCrud(person);
				} catch (CrudInsertException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (this.updateCrudButton.isVisible()) {
				try {
					dao.updateCrud(person);
					addCrudButton.setVisible(true);
					updateCrudButton.setVisible(false);
				} catch (CrudInsertException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			person = null;
			nomeTextField.setText("");
		} else if (nome.isEmpty()) {
			AlertsUtil.showAlertWarningText("Por favor informe o nome da instituição.");
		}
	}
	
	@FXML
	public void changeCrud() {
		 person = crudTableView.getSelectionModel().getSelectedItem();
		if(person.equals(null)) return;
		nomeTextField.setText(person.getNome());
		if(addCrudButton.isVisible()) {
			addCrudButton.setVisible(false);
			updateCrudButton.setVisible(true);
		}else {
			addCrudButton.setVisible(true);
			updateCrudButton.setVisible(false);	
		}
	}
	
	@FXML
	public void removeCrud() {
		 person = crudTableView.getSelectionModel().getSelectedItem();
		if (person != null) {
			try {
				dao.removeCrud(person);
				crudO.remove(person);
				AlertsUtil.showAlertInfoText("Instituição removida com sucesso!");
			} catch (CrudRemoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ObservableList<Crud> filterCrud() throws CrudListException {
		this.crudO.clear();
		return this.crudO;
	}

	public ObservableList<Crud> getCrud() {
		this.crudO.clear();
		List<Crud> lista;
		try {
			String query = "from Crud";
			lista = dao.listCrud(query);
			for (Crud i : lista) {
				this.crudO.add(i);
			}
			
		} catch (CrudListException e) {
			e.printStackTrace();
			AlertsUtil.showAlertErrorText("Erro na listagem do Crud.");
		}

		return this.crudO;
	}
}
