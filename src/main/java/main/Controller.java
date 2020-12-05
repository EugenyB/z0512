package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import logic.PrimeCalculator;

import java.util.List;
import java.util.Optional;

public class Controller {
    public TextField nField;
    public TextField resultField;

    private PrimeCalculator calculator;

    public void calculate() {
        String text = nField.getText();
        try {
            int n = Integer.parseInt(text);
            if (n<2) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(text + " - is not in range");
                alert.show();
            } else {
                calculator = new PrimeCalculator(n);
                resultField.setText(calculator.getPrimes().toString());
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(text + " - is not a number");
            alert.show();
        }
    }

    public void doTask() {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Input");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter number of prime:");
        List<Integer> primes = calculator.getPrimes();
        Optional<String> result = dialog.showAndWait();
        try {
            if (result.isPresent()) {
                int p = Integer.parseInt(result.get());
                if (p < 0 || p >= primes.size()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("number out of bounds");
                    alert.show();
                } else {
                    Integer answer = primes.get(p);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Result = " + answer);
                    alert.show();
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(result.get() + " - is not a number");
            alert.show();
        }
    }

    public void close() {
        Platform.exit();
    }

//    public void chooseColor() {
//        ColorPicker colorPicker = new ColorPicker();
//        colorPicker.show();
//        Color value = colorPicker.getValue();
//        System.out.println(value);
//    }
}
