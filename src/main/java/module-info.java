module com.example.goldwort {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.goldwort to javafx.fxml;
    exports com.example.goldwort;
    exports com.example.goldwort.controller;
    opens com.example.goldwort.controller to javafx.fxml;
    exports com.example.goldwort.service;
    opens com.example.goldwort.service to javafx.fxml;
    exports com.example.goldwort.entity;
    opens com.example.goldwort.entity to javafx.fxml;
    exports com.example.goldwort.util;
    opens com.example.goldwort.util to javafx.fxml;


}