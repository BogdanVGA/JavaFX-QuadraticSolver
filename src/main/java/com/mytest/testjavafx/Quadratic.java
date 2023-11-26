package com.mytest.testjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Quadratic extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Quadratic.class.getResource("quadratic-view.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load(), 600, 700);
        primaryStage.setTitle("Quadratic Equation Solver");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
