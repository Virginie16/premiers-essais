module com.example.partie2exo1liremaxtabentiers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.partie2exo1liremaxtabentiers to javafx.fxml;
    exports com.example.partie2exo1liremaxtabentiers;
}