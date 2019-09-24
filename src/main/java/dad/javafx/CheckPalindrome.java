package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindrome extends Application {

	private TextField sentenciaText;
	private Button comprobarButton;
	private Label checkLabel;

	public void start(Stage primaryStage) throws Exception {
		sentenciaText = new TextField();
		sentenciaText.setPromptText("Introduce una sentencia: ");
		sentenciaText.setMaxWidth(150);
		
		checkLabel = new Label ("¿Es palindromo?");
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(sentenciaText, comprobarButton, checkLabel);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Hola JavaFX Mejorado");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	boolean checkPalindrome(String inputString) {
	return inputString.equals(new StringBuilder(inputString).reverse().toString());
	}
	
	private void onComprobarButtonAction(ActionEvent e) {
		
		String sentencia = sentenciaText.getText();
		
		if (checkPalindrome(sentencia)) {
			checkLabel.setText("Es palindromo");
			checkLabel.setStyle("-fx-text-fill: green;-fx-font: italic bold 30 consolas;");
		}
		
		else {
			checkLabel.setText("No es palindromo");
			checkLabel.setStyle("-fx-text-fill: red;-fx-font: italic bold 30 consolas;");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
