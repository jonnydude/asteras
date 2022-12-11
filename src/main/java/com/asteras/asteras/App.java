//package com.asteras.asteras;
//
//import com.asteras.asteras.files.FileUtils;
//import com.asteras.asteras.files.Researcher;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.List;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// * JavaFX App
// */
//public class App extends Application {
//
//    @Override
//    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
////        launch();
//        try {
//            List<Researcher> researcherList = FileUtils.getInitialData();
//            for (Researcher researcher : researcherList) {
////                System.out.println(researcher);
////                 StandardAnalyzer analyzer = new StandardAnalyzer();
////                Directory index = new ByteBuffersDirectory();
////                IndexWriterConfig config = new IndexWriterConfig(analyzer);
////                IndexWriter w = new IndexWriter(index, config);
//            }
//        } catch (URISyntaxException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//}
