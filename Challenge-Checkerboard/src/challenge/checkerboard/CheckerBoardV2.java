/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kolbe
 */
public class CheckerBoardV2 {

    private AnchorPane root;
    private int boardRows, boardCols;
    private Color light, dark;
    private double boardWidth, boardHeight;
    private Rectangle[][] rectangles;

    private final Color DEFAULT_LIGHT = Color.web("red");
    private final Color DEFAULT_DARK = Color.web("black");
    private final double[] DEFAULT_DIMENSIONS = {3, 8, 10, 16};

    public CheckerBoardV2(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.initialize(numRows, numCols, boardWidth, boardHeight);
        light = DEFAULT_LIGHT;
        dark = DEFAULT_DARK;
    }

    public CheckerBoardV2(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.initialize(numRows, numCols, boardWidth, boardHeight);
        light = lightColor;
        dark = darkColor;
    }

    //Class Functions///////////////////////////////////////////////////////////
    public void build() {
        if(root == null)
            root = new AnchorPane();
        root.getChildren().clear();
        root.setPrefSize(boardWidth, boardHeight);
        setupRectangles();
    }

    public AnchorPane getBoard() {
        return root;
    }

    //Getter Functions//////////////////////////////////////////////////////////
    public int getNumRows() {
        return boardRows;
    }

    public int getNumCols() {
        return boardCols;
    }

    public double getWidth() {
        return boardWidth;
    }

    public double getHeight() {
        return boardHeight;
    }

    public Color getLightColor() {
        return light;
    }

    public Color getDarkColor() {
        return dark;
    }

    public double getRectangleWidth() {
        return boardWidth / boardCols;
    }

    public double getRectangleHeight() {
        return boardHeight / boardRows;
    }

    //Set functions
    public void setDimension(int choice) {
        switch (choice) {
            case 0:
                this.boardRows = 16;
                this.boardCols = 16;
                break;
            case 1:
                this.boardRows = 10;
                this.boardCols = 10;
                break;
            case 2:
                this.boardRows = 8;
                this.boardCols = 8;
                break;
            case 3:
                this.boardRows = 3;
                this.boardCols = 3;
                break;
            default:
                this.boardRows = 16;
                this.boardCols = 16;
                break;
        }
        this.build();
    }

    public void setColor(int choice) {
        switch (choice) {
            case 0:
                light = this.DEFAULT_LIGHT;
                dark = this.DEFAULT_DARK;
                break;
            case 1:
                light = Color.SKYBLUE;
                dark = Color.DARKBLUE;
                break;
            default:
                light = this.DEFAULT_LIGHT;
                dark = this.DEFAULT_DARK;
                break;
        }
        this.build();
    }

    //Helper Functions//////////////////////////////////////////////////////////
//Initializes board state
    private void initialize(int rows, int cols, double width, double height) {
        if (rows <= 0 || cols <= 0 || width <= 0 || height <= 00) {
            System.out.println("Invalid initalization values may result in unintended results.");
        } else {
            this.boardRows = rows;
            this.boardCols = cols;
            this.boardWidth = width;
            this.boardHeight = height;
        }
    }

//Setup rectangles and position them in pane
    private void setupRectangles() {
        rectangles = new Rectangle[boardCols][boardRows];

        for (int i = 0; i < boardCols; i++) {
            for (int k = 0; k < boardRows; k++) {
                //create new rectangle
                Rectangle curr = new Rectangle();
                //calculate position for placement
                double xPos = i * boardWidth / boardCols;
                double yPos = k * boardHeight / boardRows;
                //initalize with values
                curr.setX(xPos);
                curr.setY(yPos);
                curr.setWidth(boardWidth / boardCols);
                curr.setHeight(boardHeight / boardRows);

                //set current rectangle color
                if ((i + k) % 2 == 0) {
                    curr.setFill(light);
                } else {
                    curr.setFill(dark);
                }
                //add to array
                rectangles[i][k] = curr;
                //add to root pane
                root.getChildren().add(curr);
            }
        }
    }
}
