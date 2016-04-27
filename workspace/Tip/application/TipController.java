import java.awt.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
package application;



public class TipController {
	private final static NumberFormat currency = NumberFormat.getCurrencyInstance(); 
	private final static NumberFormat percent = NumberFormat.getPercentInstance(); 
	
	private BigDecimal tipPercentage = new BigDecimal(0.15);
	@FXML
private TextField amountTextField;
	@FXML 
private Label tipPercentageLabel;
	@FXML 
private TextField tipTextField; 
	@FXML
private TextField totalTextField;
	@FXML
private Slider TipSlider;
	@FXML
	
	@FXML
private void calculateButtonPressed(ActionEvent event){
		figureTotal(); 
	}
	
	public void initialize() {
		currency.setRoundingMode(RoundingMode.HALF_UP);
		
		TipSlider.valueProperty().addListener (
				new ChangeListener<Number>(){
					@Override
					public void changed(ObservableValue<? extends Number> ov,
						Number oldValue, Number newValue) {
						tipPercentage =
								BigDecimal.valueOf(newValue.intValue()/100.0);
						tipPercentageLabel.setText(percent.format(tipPercentage));
						figureTotal();
					}
				} );
	}
	private void figureTotal() {
		try {
			BigDecimal amount = new BigDecimal(amountTextField.getText());
			BigDecimal tip = amount.multiply(tipPercentage);
			BigDecimal total = amount.add(tip);
			
			tipTextField.setText(currency.format(tip));
			totalTextField.setText(currency.format(total));
		} catch (NumberFormatException ex) {
			amountTextField.setText("Enter Amount, please");
			amountTextField.selectAll(); 
			amountTextField.requestFocus(); 
		}
		}
	}
	
}
