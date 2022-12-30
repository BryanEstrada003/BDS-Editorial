module com.mycompany.editorialsbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires java.desktop;
    requires java.logging;
    opens com.mycompany.editorialsbd to javafx.fxml;
    exports com.mycompany.editorialsbd;
}
