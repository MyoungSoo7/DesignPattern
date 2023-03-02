module com.backend.bakckend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.backend.bakckend to javafx.fxml;
    exports com.backend.bakckend;
    exports com.backend.bakckend.test;
    opens com.backend.bakckend.test to javafx.fxml;
    exports com.backend.bakckend.util;
    opens com.backend.bakckend.util to javafx.fxml;
}