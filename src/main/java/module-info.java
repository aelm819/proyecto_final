module es.auditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens es.auditor to javafx.fxml;
    opens es.auditor.controller to javafx.fxml;
    opens es.auditor.model to javafx.base;
    exports es.auditor;
}
