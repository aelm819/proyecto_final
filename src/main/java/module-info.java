module es.iescelia {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens es.Auditor to javafx.fxml;
    exports es.Auditor;
}
