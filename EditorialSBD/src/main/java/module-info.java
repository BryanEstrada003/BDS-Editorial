module com.mycompany.editorialsbd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.editorialsbd to javafx.fxml;
    exports com.mycompany.editorialsbd;
}
