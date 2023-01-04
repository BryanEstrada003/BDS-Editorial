module com.mycompany.proyectoeditorialsbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires java.desktop;
    requires java.logging;
    opens com.mycompany.proyectoeditorialsbd to javafx.fxml;
    exports com.mycompany.proyectoeditorialsbd;
    opens Clases to javafx.base;
}
