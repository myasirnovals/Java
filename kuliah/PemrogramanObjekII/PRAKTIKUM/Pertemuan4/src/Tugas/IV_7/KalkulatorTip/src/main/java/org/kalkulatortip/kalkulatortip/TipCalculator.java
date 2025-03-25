package org.kalkulatortip.kalkulatortip;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label billLabel = new Label("Bill Amount:");
        TextField billField = new TextField();

        Label tipLabel = new Label("Tip Percentage:");
        Slider tipSlider = new Slider(0, 30, 10);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setMinorTickCount(1);

        Label tipValueLabel = new Label("10%");
        tipSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            tipValueLabel.setText(String.format("%.0f%%", newValue));
        });

        Label totalLabel = new Label("Total Amount:");
        TextField totalField = new TextField();
        totalField.setEditable(false);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            try {
                double billAmount = Double.parseDouble(billField.getText());
                double tipPercentage = tipSlider.getValue();
                double tipAmount = billAmount * (tipPercentage / 100);
                double totalAmount = billAmount + tipAmount;
                totalField.setText(String.format("%.2f", totalAmount));
            } catch (NumberFormatException ex) {
                totalField.setText("Invalid Input");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(billLabel, 0, 0);
        grid.add(billField, 1, 0);
        grid.add(tipLabel, 0, 1);
        grid.add(tipSlider, 1, 1);
        grid.add(tipValueLabel, 2, 1);
        grid.add(totalLabel, 0, 2);
        grid.add(totalField, 1, 2);
        grid.add(calculateButton, 1, 3);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}