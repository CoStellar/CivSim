module com.example.civsim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.civsim to javafx.fxml;
    exports com.civsim;
}