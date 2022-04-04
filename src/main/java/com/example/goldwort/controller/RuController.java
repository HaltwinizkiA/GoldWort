package com.example.goldwort.controller;

import com.example.goldwort.WordService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RuController {

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
        WordService exercises = WordService.getInstance();
        out.setText(String.join(",", exercises.getCurrentWord().getRussian()));
        Enter.setOnAction(event -> {
            info.setText(exercises.ruMode(input.getText()));
            out.setText(String.join(",", exercises.getCurrentWord().getRussian()));
            count.setText(exercises.getCount());
            score.setText("Richtige " + exercises.getRight());
        });

    }
}
