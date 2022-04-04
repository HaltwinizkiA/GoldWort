module com.example.goldwort {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.goldwort to javafx.fxml;
    exports com.example.goldwort;
    exports com.example.goldwort.controller;
    opens com.example.goldwort.controller to javafx.fxml;


}