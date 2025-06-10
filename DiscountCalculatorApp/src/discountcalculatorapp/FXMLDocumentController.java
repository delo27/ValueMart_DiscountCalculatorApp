package discountcalculatorapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLDocumentController {

    @FXML
    private TextField totalAmountField; // Updated fx:id to match FXML

    @FXML
    private Text discountText; // Updated to match FXML

    @FXML
    private Text totalText; // Updated to match FXML

    @FXML
    private Button clearButton;

    @FXML
    private Button calculateButton;

    // Method for discount calculation
    @FXML
    private void calculateDiscount() {
        if (totalAmountField == null) {
            System.out.println("Error: totalAmountField is null.");
            return;
        }

        String totalTextValue = totalAmountField.getText();
        if (totalTextValue == null || totalTextValue.trim().isEmpty()) {
            discountText.setText("Enter a value");
            totalText.setText("Enter a value");
            return;
        }

        try {
            double total = Double.parseDouble(totalTextValue);

            // Discount calculation standards
            double discountPrec;
            if (total < 5000) {
                discountPrec = 0.0;
            } else if (total < 10000) {
                discountPrec = 0.03;
            } else if (total < 20000) {
                discountPrec = 0.10;
            } else {
                discountPrec = 0.15;
            }

            // Calculate discount and final total
            double discount = total * discountPrec;
            double finalTotal = total - discount;

            // Update UI elements
            discountText.setText(String.format("%.2f", discount));
            totalText.setText(String.format("%.2f", finalTotal));
        } catch (NumberFormatException e) {
            discountText.setText("Invalid Input");
            totalText.setText("Invalid Input");
        }
    }

    // Method for clearing all fields
    @FXML
    private void clearFields() {
        totalAmountField.clear();
        discountText.setText("-");
        totalText.setText("-");
    }

    @FXML
    public void initialize() {
        System.out.println("Initializing...");
        System.out.println("totalAmountField: " + totalAmountField);
        System.out.println("discountText: " + discountText);
        System.out.println("totalText: " + totalText);
        assert totalAmountField != null : "fx:id=\"totalAmountField\" was not injected!";
        assert discountText != null : "fx:id=\"discountText\" was not injected!";
        assert totalText != null : "fx:id=\"totalText\" was not injected!";
    }
}
