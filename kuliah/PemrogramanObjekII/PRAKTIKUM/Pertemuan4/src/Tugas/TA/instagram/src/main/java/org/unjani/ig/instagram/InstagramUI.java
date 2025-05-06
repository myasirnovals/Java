package org.unjani.ig.instagram;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstagramUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label logoLabel = new Label("Instagram");
        logoLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        HBox header = new HBox(logoLabel);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #e6e6e6;");

        VBox postArea = new VBox();
        postArea.setPadding(new Insets(10));
        postArea.setSpacing(10);

        for (int i = 1; i <= 3; i++) {
            VBox post = createPost("User" + i, "This is a sample post content from User" + i + ".");
            postArea.getChildren().add(post);
        }

        Button homeButton = new Button("Home");
        Button searchButton = new Button("Search");
        Button profileButton = new Button("Profile");

        HBox footer = new HBox(10, homeButton, searchButton, profileButton);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #e6e6e6;");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(header);
        mainLayout.setCenter(postArea);
        mainLayout.setBottom(footer);

        Scene scene = new Scene(mainLayout, 400, 600);
        primaryStage.setTitle("Instagram UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPost(String username, String content) {
        Label usernameLabel = new Label(username);
        usernameLabel.setStyle("-fx-font-weight: bold;");

        TextArea contentArea = new TextArea(content);
        contentArea.setWrapText(true);
        contentArea.setEditable(false);
        contentArea.setPrefHeight(60);

        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/300"));
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        VBox post = new VBox(5, usernameLabel, imageView, contentArea);
        post.setPadding(new Insets(10));
        post.setStyle("-fx-border-color: #e6e6e6; -fx-border-radius: 5px; -fx-background-color: #ffffff;");
        return post;
    }

    public static void main(String[] args) {
        launch(args);
    }
}