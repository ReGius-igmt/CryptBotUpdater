package ru.regiuss.CryptBotUpdater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.regiuss.CryptBotUpdater.controllers.HomeController;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Stage stage = stage2;
        FXMLLoader loader = new FXMLLoader( getClass().getResource("/fxml/home.fxml") );
        //((HomeController)loader.getController()).SetVersion(ar);
        Parent root = loader.load();
        stage.setTitle("Обновление");
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/logo.png")));
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
