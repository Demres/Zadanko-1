package sample;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class Controller {

    public Button drawLineButton, drawCircleButton, drawRectangleButton;
    public Button createLineButton, createCircleButton, createRectangleButton;
    public Button clearButton;
    public Pane pane;
    public TextField lineStartX, lineEndX, lineStartY, lineEndY;
    public TextField rectangleStartX,rectangleStartY, rectangleHeight, rectangleWidth;
    public TextField circleStartX,circleStartY, circleRadius;

    public void drawLine() {
        final MyLine[] myLine = new MyLine[1];

        pane.setOnMousePressed(event -> {
            myLine[0] = new MyLine(event.getX(), event.getY(), event.getX(), event.getY());
            pane.getChildren().addAll(myLine[0].getAllNodes());
        });

        pane.setOnMouseDragged(event -> {
            myLine[0].getCircleEnd().setCenterX(event.getX());
            myLine[0].getCircleEnd().setCenterY(event.getY());
            myLine[0].getLine().setEndX(event.getX());
            myLine[0].getLine().setEndY(event.getY());
        });
    }

    public void createLine(){
        MyLine myLine = new MyLine(Double.parseDouble(lineStartX.getText()), Double.parseDouble(lineStartY.getText()), Double.parseDouble(lineEndX.getText()),
                Double.parseDouble(lineEndY.getText()));
        pane.getChildren().addAll(myLine.getAllNodes());
    }

    public void drawCircle(){

    }

    public void createCircle(){
        MyCircle myCircle = new MyCircle(Double.parseDouble(circleStartX.getText()), Double.parseDouble(circleStartY.getText()), Double.parseDouble(circleRadius.getText()));

        pane.getChildren().addAll(myCircle.getAllNodes());
    }

    public void drawRectangle(){
        MyRectangle myRectangle = new MyRectangle(50, 50, 80, 120);

        pane.getChildren().addAll(myRectangle.getAllNodes());
    }

    public void createRectangle(){
        MyRectangle myRectangle = new MyRectangle(Double.parseDouble(rectangleStartX.getText()), Double.parseDouble(rectangleStartY.getText()),
                Double.parseDouble(rectangleHeight.getText()), Double.parseDouble(rectangleWidth.getText()));

        pane.getChildren().addAll(myRectangle.getAllNodes());
    }

    public void clear(){
        pane.setOnMousePressed(event -> {});
        pane.setOnMouseDragged(event -> {});
    }

    public void deleteAllNodes(){
        pane.getChildren().clear();
    }

    @FXML
    public void initialize() {


    }
}
