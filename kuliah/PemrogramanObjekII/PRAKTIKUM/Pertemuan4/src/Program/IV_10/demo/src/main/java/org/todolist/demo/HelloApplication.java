package org.todolist.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane p = new BorderPane( );
        Text t = new Text ("Hello FX");
        t.setFont(Font.font("Arial", 60));
        p.setCenter(t);
        stage.setScene(new Scene(p));
        stage.show( );
    }

    public static void main(String[] args) {
        launch();
    }
}