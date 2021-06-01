package ru.regiuss.CryptBotUpdater;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

public class DownloadFile extends Thread{
    Text loadText;
    Text errorText;
    ProgressBar loadBar;

    public DownloadFile(Text loadText, Text errorText, ProgressBar loadBar) {
        this.setDaemon(true);
        this.loadText = loadText;
        this.loadBar = loadBar;
        this.errorText = errorText;
    }

    @Override
    public void run() {
        BufferedInputStream in;
        FileOutputStream out;

        try{
            URL url = new URL("https://github.com/ReGius-igmt/CryptBot/releases/download/" + Main.version + "/CryptBot.jar");
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();

            in = new BufferedInputStream(url.openStream());
            out = new FileOutputStream("CryptBot.jar");
            byte[] data = new byte[1024];
            int count;
            double sumCount = 0.0;
            double precentace;


            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);

                sumCount += count;
                if (lenghtOfFile > 0) {
                    double finalSumCount = sumCount;
                    Platform.runLater((() -> loadText.setText(finalSumCount + " / " + lenghtOfFile)));
                    //loadText.setText(sumCount + " / " + lenghtOfFile);
                    precentace = (sumCount / lenghtOfFile);
                    double finalPrecentace = precentace;
                    Platform.runLater((() -> loadBar.setProgress(finalPrecentace)));
                }
            }
            Platform.exit();
            Runtime.getRuntime().exec("cmd /c start cmd /k java -jar " + Paths.get("CryptBot.jar") + " updated");
        }catch (Exception e){
            errorText.setVisible(true);
        }
    }
}
