import java.awt.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
package application;



public class TipController {
	@FXML
private TextField amountTextField;
	@FXML
private TextField totalTextField;
	@FXML
private void calculateButtonPressed(ActionEvent event){
		Float mealAmount = Float.parseFloat(amountTextField.getText());
		totalTextField.setText(String.valueOf(mealAmount * (1 + .20)));
	}
}
