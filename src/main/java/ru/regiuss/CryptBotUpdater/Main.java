package ru.regiuss.CryptBotUpdater;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

public class Main {

    public static String version;

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Version not found");
            return;
        }
        version = args[0];
        App.launch(App.class, args);

/*        System.out.println("Загрузка файлов..");

        BufferedInputStream in;
        FileOutputStream out;

        try{
            URL url = new URL("https://github.com/ReGius-igmt/CryptBot/releases/download/" + args[0] + "/CryptBot.jar");
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();

            if (lenghtOfFile < 0) {
                System.out.println("Could not get the file size");
            } else {
                System.out.println("File size: " + lenghtOfFile);
            }

            in = new BufferedInputStream(url.openStream());
            out = new FileOutputStream("CryptBot.jar");
            byte[] data = new byte[1024];
            int count;
            double sumCount = 0.0;
            int precentace;


            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);

                sumCount += count;
                if (lenghtOfFile > 0) {
                    precentace = (int)(sumCount / lenghtOfFile * 100);
                    System.out.print("\rPercentace: " + precentace + "%\t");
                    for (int i = 0; i < precentace/2; i++)System.out.print("█");
                    for (int i = 0; i < 50-precentace/2; i++)System.out.print("░");
                }
            }

            Runtime.getRuntime().exec("cmd /c start cmd /k java -jar " + Paths.get("CryptBot.jar") + " updated");
        }catch (Exception e){
            System.out.println("Ошибка при загрузке файлов");
        }*/
    }
}
