module es.auditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens es.auditor to javafx.fxml;
    exports es.auditor;
}
