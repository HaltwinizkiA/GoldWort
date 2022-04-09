package com.example.goldwort.controller;

import com.example.goldwort.service.WordService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RightController {

    @FXML
    private Button Enter;

    @FXML
    private Text count;

    @FXML
    private Text info;

    @FXML
    private TextField input;

    @FXML
    private Text klinger;

    @FXML
    private Text out;

    @FXML
    private Text score;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        WordService wordService = WordService.getInstance();
        out.setText(String.join(",", wordService.getCurrentWord().getRight()));
        Enter.setOnAction(event -> {
            info.setText(wordService.rightMode(input.getText()));
            out.setText(String.join(",", wordService.getCurrentWord().getRight()));
            count.setText(wordService.getCount());
            score.setText("Score " + wordService.getRightCount());
            if (wordService.getCheckAnswer().equals(WordService.getANSWERFALSE())) {
                klinger.setFill(Color.RED);
            } else {
                klinger.setFill(Color.GREEN);
            }
            klinger.setText(wordService.getCheckAnswer());

        });

    }
}
