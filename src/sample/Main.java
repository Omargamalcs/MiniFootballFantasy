package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mini Football Fantasy");
        primaryStage.setScene(new Scene(root, 1065, 595));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        primaryStage.show();
        playMusic();
    }
    public static void playMusic()
    {
        try {
            File musicpath =new File("Music\\PL.wav");
            if (musicpath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
                Clip clip= AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("can't find file");
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }
}
