module wargames {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens idatx2001.jorgfi.wargamesApp.controller to javafx.fxml;
    opens idatx2001.jorgfi.wargamesApp.model to javafx.fxml;

    exports idatx2001.jorgfi.wargamesApp.controller;
    exports idatx2001.jorgfi.wargamesApp.model;
}
