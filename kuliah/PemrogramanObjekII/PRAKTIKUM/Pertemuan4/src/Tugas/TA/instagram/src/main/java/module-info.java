module org.unjani.ig.instagram {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.unjani.ig.instagram to javafx.fxml;
    exports org.unjani.ig.instagram;
}