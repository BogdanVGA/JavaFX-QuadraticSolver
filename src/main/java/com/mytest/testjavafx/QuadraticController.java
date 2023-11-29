package com.mytest.testjavafx;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuadraticController {
    @FXML
    private Button exitButton;
    @FXML
    private Label firstRoot;
    @FXML
    private Label secondRoot;
    @FXML
    private Text warning;
    @FXML
    private TextField firstValueField;
    @FXML
    private TextField secondValueField;
    @FXML
    private TextField thirdValueField;
    @FXML
    private LineChart<Number,Number> lineGraph;

    @FXML
    private void pressSolveBtn() {
        String[] getFields = new String[3];
        getFields[0] = firstValueField.getText();
        getFields[1] = secondValueField.getText();
        getFields[2] = thirdValueField.getText();

        double[] validInput = validateInput(getFields);
        Equation quadratic = new Equation(validInput);
        String[] out = quadratic.solveEquation();

        warning.setText("Note: " + out[0]);
        firstRoot.setText(out[1]);
        secondRoot.setText(out[2]);
    }
    @FXML
    private void pressGraphBtn() {
        String[] getFields = new String[3];
        getFields[0] = firstValueField.getText();
        getFields[1] = secondValueField.getText();
        getFields[2] = thirdValueField.getText();

        double[] validInput = validateInput(getFields);
        QuadFunction quad = new QuadFunction(validInput);

        double range = 20;
        LineChart.Series<Number, Number> series = new LineChart.Series<>();
        for (double x = -range; x <= range; x = x + 0.1) {
            XYChart.Data<Number, Number> chartData = new XYChart.Data<>(x, quad.evaluateFunction(x));
            series.getData().add(chartData);
        }
        lineGraph.getData().add(series);
    }
    @FXML
    private void pressResetBtn() {
        firstValueField.clear();
        secondValueField.clear();
        thirdValueField.clear();
        firstRoot.setText("");
        secondRoot.setText("");
        warning.setText("");
        lineGraph.getData().clear();
    }
    @FXML
    private void pressExitBtn() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private double[] validateInput(String[] inputString) {
        double[] validated = {0, 0, 0};
        for(int i = 0; i < 3; i++) {
            // if data type mismatch, make the coefficient 0
            try {
                validated[i] = Double.parseDouble(inputString[i]);
            } catch (Exception e) {
                validated[i] = 0;
            }
        }
        return validated;
    }
}