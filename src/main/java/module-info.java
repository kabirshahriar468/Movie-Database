module JavaFX {
    requires javafx.controls;
    requires javafx.fxml;

    opens singlescene to javafx.fxml;
    opens multiplescene to javafx.fxml;
    opens controls to javafx.fxml;
    opens animation to javafx.fxml;
    exports singlescene;
    exports multiplescene;
    exports controls;
    exports animation;
    exports multiplescene.clientmain;
}