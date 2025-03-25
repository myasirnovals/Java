module org.kalkulatortip.kalkulatortip {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.kalkulatortip.kalkulatortip to javafx.fxml;
    exports org.kalkulatortip.kalkulatortip;
}