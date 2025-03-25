module org.todolist.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.todolist.demo to javafx.fxml;
    exports org.todolist.demo;
}