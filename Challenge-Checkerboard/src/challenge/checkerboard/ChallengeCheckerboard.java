/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.checkerboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Kolbe
 */
public class ChallengeCheckerboard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AnchorPane root;
        CheckerBoardV2 board = new CheckerBoardV2(10,10,500,500);
        board.build();
        root = board.getBoard();
        
        Scene scene = new Scene(root, board.getWidth(), board.getHeight());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
