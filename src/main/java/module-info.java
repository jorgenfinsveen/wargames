module wargames {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens idatx2001.jorgfi.wargamesApp.ui to javafx.fxml, javafx.graphics;
    opens idatx2001.jorgfi.wargamesApp;

    exports idatx2001.jorgfi.wargamesApp;
    exports idatx2001.jorgfi.wargamesApp.model;
    exports idatx2001.jorgfi.wargamesApp.ui;
    opens idatx2001.jorgfi.wargamesApp.model;
}
