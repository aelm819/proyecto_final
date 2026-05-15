package es.iescelia.controller;

import java.io.IOException;

import es.iescelia.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}