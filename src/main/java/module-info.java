module edu.espol.proyectoiipoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires java.logging;

    opens edu.espol.proyectoiipoo to javafx.fxml;
    exports edu.espol.proyectoiipoo;
}