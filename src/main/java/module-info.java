module es.iescelia {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens es.iescelia to javafx.fxml;
    exports es.iescelia;
}
