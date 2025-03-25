module org.instagramui.instagramui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.instagramui.instagramui to javafx.fxml;
    exports org.instagramui.instagramui;
}