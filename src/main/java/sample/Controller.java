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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Controller {

    public Button createLineButton;
    public Button createCircleButton;
    public Button createRectangleButton;
    public Pane pane;

    public void createLine() {
//        Line line = new Line(50, 100, 100, 100);
//        Circle circle = new Circle(30, 30,3, Color.RED);
//        Point2D point = new Point2D(50, 50);
//        circle.setOnMouseClicked(event ->{
//            System.out.println("I was clicked");
//            circle.setCenterX(event.getX());
//            circle.setCenterY(event.getY());
//        });
//        circle.setOnMouseDragged(event -> {
//            System.out.println("Drag over");
//            circle.setCenterX(event.getX());
//            circle.setCenterY(event.getY());
//        });
        MyLine myLine = new MyLine(50, 50, 100, 100);
        pane.getChildren().addAll(myLine.getAllNodes());
    }

    public void createCircle(){
        Circle circle = new Circle(30, 30,3, Color.RED);
        circle.setOnMouseDragged(event -> {
            System.out.println("Drag over");
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
        });

        pane.getChildren().addAll(circle);

    }

    public void createRectangle(){
        MyRectangle myRectangle = new MyRectangle(50, 50, 30, 30);

        pane.getChildren().addAll(myRectangle.getLineTop());
    }

    @FXML
    public void initialize() {


    }
}
