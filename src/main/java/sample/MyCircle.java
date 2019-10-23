package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class MyCircle {

    Circle circle;
    List<Node> nodeList;

    MyCircle(double centerX, double centerY, double radius){
        nodeList = new ArrayList<>();
        circle = new Circle(centerX, centerY, radius, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);
        circle.setOnMouseDragged(event -> {
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
        });

        nodeList.add(circle);
    }

    public List<Node> getAllNodes(){
        return  nodeList;
    }
}
