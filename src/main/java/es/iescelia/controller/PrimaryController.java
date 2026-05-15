package es.iescelia.controller;

import java.io.IOException;

import es.iescelia.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
