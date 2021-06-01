package ru.regiuss.CryptBotUpdater.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import ru.regiuss.CryptBotUpdater.DownloadFile;
import ru.regiuss.CryptBotUpdater.Main;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

public class HomeController {
    @FXML
    private Text versionName;

    @FXML
    private ProgressBar loadBar;

    @FXML
    private Text loadText;

    @FXML
    private Text errorText;

    @FXML
    private Button cancelButton;

    @FXML
    void CancelLoad(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void initialize() {
        versionName.setText("CryptBot-"+Main.version);
        DownloadFile downloadFile = new DownloadFile(loadText, errorText, loadBar);
        downloadFile.start();
    }
}
