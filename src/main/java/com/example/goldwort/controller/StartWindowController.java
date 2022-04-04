package com.example.goldwort.controller;

import com.example.goldwort.Starter;
import com.example.goldwort.WordService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deutsch;

    @FXML
    private Button russisch;

    @FXML
    private TextField wordPath;

    @FXML
    void initialize() {
        deutsch.setOnAction(event -> {
            WordService wordService=new WordService(wordPath.getText());
            try {
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("deutsch-window.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 376, 368);
                        stage.setScene(scene);
                        stage.setTitle("Deutsch mode");
                        stage.setResizable(false);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


        );
        russisch.setOnAction(event -> {
            try {
                WordService wordService=new WordService(wordPath.getText());
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("russisch-window.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 376, 368);
                stage.setScene(scene);
                stage.setTitle("Russisch mode");
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}