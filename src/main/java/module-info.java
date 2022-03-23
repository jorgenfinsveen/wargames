module wargames {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens idatx2001.jorgfi.wargamesApp to javafx.fxml;

    exports idatx2001.jorgfi.wargamesApp;
}
