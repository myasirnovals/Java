module org.demo.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.demo.demo to javafx.fxml;
    exports org.demo.demo;
}