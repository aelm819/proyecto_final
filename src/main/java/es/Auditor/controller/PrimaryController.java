package es.Auditor.controller;

import java.io.IOException;

import es.Auditor.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
