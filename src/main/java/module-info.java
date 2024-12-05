module de.bbq.popout.minibrowser {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.web;

    opens de.bbq.popout.minibrowser to javafx.fxml;
    exports de.bbq.popout.minibrowser;
}
