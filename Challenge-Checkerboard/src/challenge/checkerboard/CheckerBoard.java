/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.checkerboard;

import java.awt.Color;
import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kolbe
 */
public class CheckerBoard {

    Color DEFAULT_COLOR_A = Color.black;
    Color DEFAULT_COLOR_B = Color.RED;

    int gridType;
    int dimension;

    private int rows;
    private int cols;
    private double width;
    private double height;
    private Color colorLight, colorDark;
    private AnchorPane root;
    private ArrayList<Rectangle> rectangles;

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        initialize(numRows, numCols, boardWidth, boardHeight);
        this.colorLight = DEFAULT_COLOR_A;
        this.colorDark = DEFAULT_COLOR_B;
    }

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        initialize(numRows, numCols, boardWidth, boardHeight);
        this.colorLight = lightColor;
        this.colorDark = darkColor;
    }

    private void initialize(int numRows, int numCols, double boardWidth, double boardHeight) {
        gridType = 2;
        this.switchType();
        this.rows = numRows;
        this.cols = numCols;
        this.width = boardWidth;
        this.height = boardHeight;
    }

    public void switchType() {
        switch (gridType) {
            case 0:
                dimension = 3;
                break;
            case 1:
                dimension = 8;
                break;
            case 2:
                dimension = 10;
                break;
            case 3:
                dimension = 16;
                break;
        }
    }

    public void build() {
        root = new AnchorPane();
        rectangles = new ArrayList();
        root.setMinSize(600, 600);

        this.width = 600;
        this.height = 600;
        this.setupRectangles();
    }

    public AnchorPane getRoot() {
        return root;
    }

    public int getNumRows() {
        int done = 0;
        switch (gridType) {
            case 0:
                done = 3;
                break;
            case 1:
                done = 8;
                break;
            case 2:
                done = 10;
                break;
            case 3:
                done = 16;
                break;
        }
        return done;
    }

    public int getNumCols() {
        int done = 0;
        switch (gridType) {
            case 0:
                done = 3;
                break;
            case 1:
                done = 8;
                break;
            case 2:
                done = 10;
                break;
            case 3:
                done = 16;
                break;
        }
        return done;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Color getLightColor() {
        return colorLight;
    }

    public Color getDarkColor() {
        return colorDark;
    }

    public double getRectangleWidth() {
        return width / dimension;
    }

    public double getRectangleHeight() {
        return width / height;
    }

//getNumRows(), getNumCols(), getWidth(), getHeight(), getLightColor(), getDarkColor(), getRectangleWidth(), getRectangleHeight()
    //////////////////////////////////
    private void addRectangle(int row, int col) {
        double x = width / dimension * row;
        double y = height / dimension * col;

        Rectangle hold = new Rectangle();
        hold.setX(x);
        hold.setY(y);
        hold.setWidth(width / dimension);
        hold.setHeight(height / dimension);

        rectangles.add(hold);
    }

    private void setupRectangles() {
        for (int i = 0; i < dimension; i++) {
            for (int k = 0; k < dimension; k++) {
                addRectangle(i, k);
            }
        }
        
        int i = 0;
        boolean alt;

        for (int j = 0; j < rectangles.size(); j++) {
            Rectangle curr = rectangles.get(j);
            //add rectangle to scene
            root.getChildren().add(curr);

            //alternate rectangle color;
            Paint light = Paint.valueOf(colorLight.toString());
            Paint dark = Paint.valueOf(colorDark.toString());
         
            if (i % 2 == 0) {
                curr.setFill(light);
            } else {
                curr.setFill(dark);
            }


        }
    }

}
