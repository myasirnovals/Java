module org.instagramui.tampilaninstagram {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.instagramui.tampilaninstagram to javafx.fxml;
    exports org.instagramui.tampilaninstagram;
}