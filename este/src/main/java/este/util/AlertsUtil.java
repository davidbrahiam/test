package este.util;

import java.util.Optional;
import java.util.function.Consumer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertsUtil {

	// Mostra um alert de Info
	public static void showAlertInfoText(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informe");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	// Mostra um alert de Error
	public static void showAlertErrorText(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	// Mostra um alert de Warning
	public static void showAlertWarningText(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Aviso");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}
}
