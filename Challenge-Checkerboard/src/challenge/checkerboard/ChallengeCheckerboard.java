/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.checkerboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Kolbe
 */
public class ChallengeCheckerboard extends Application {

    @Override
    public void start(Stage primaryStage) {

        //setup board
        AnchorPane boardPane;
        CheckerBoardV2 board = new CheckerBoardV2(10, 10, 500, 500);
        board.build();
        boardPane = board.getBoard();

        //setup menu
        MenuBar menuBar = new MenuBar();

        //create menu items
        Menu grid = new Menu("Grid");
        Menu color = new Menu("Color");

        //create menu items
        MenuItem gridA = new MenuItem("16x16");
        MenuItem gridB = new MenuItem("10x10");
        MenuItem gridC = new MenuItem("8x8");
        MenuItem gridD = new MenuItem("3x3");

        MenuItem colorA = new MenuItem("Default");
        MenuItem colorB = new MenuItem("Blue");

        //setup action handlers
        gridA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setDimension(0);
            }
        });
        gridB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setDimension(1);
            }
        });
        gridC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setDimension(2);
            }
        });
        gridD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setDimension(3);
            }
        });

        colorA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setColor(0);
            }
        });
        colorB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                board.setColor(1);
            }
        });

        //finalize menu bar
        grid.getItems().addAll(gridA, gridB, gridC, gridD);
        color.getItems().addAll(colorA, colorB);
        menuBar.getMenus().addAll(grid, color);

        //setup final pane
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(boardPane);

        Scene scene = new Scene(root, 600, 600);
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
