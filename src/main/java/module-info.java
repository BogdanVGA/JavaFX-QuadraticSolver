module com.mytest.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.mytest.testjavafx to javafx.fxml;
    exports com.mytest.testjavafx;
}