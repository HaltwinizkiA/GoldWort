package com.example.goldwort.controller;

import com.example.goldwort.Starter;
import com.example.goldwort.service.WordService;
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
    private Button left;

    @FXML
    private Button right;

    @FXML
    private TextField wordPath;

    @FXML
    void initialize() {
        left.setOnAction(event -> {
                    WordService wordService = new WordService(wordPath.getText());
                    try {
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("left-window.fxml"));
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
        right.setOnAction(event -> {
            try {
                String s = wordPath.getText();
                WordService wordService = new WordService(wordPath.getText());
                if (wordService.getWordList() == null) {
                    wordService = new WordService();
                }
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("right-window.fxml"));
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