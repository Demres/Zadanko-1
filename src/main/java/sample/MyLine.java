package sample;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class MyLine {
    Line line;
    Circle circleStart;
    Circle circleEnd;
    List<Node> nodesList;

    MyLine(int startX, int startY, int endX, int endY){
        line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(5);
        circleStart = new Circle(startX, startY, 5, Color.TRANSPARENT);
        circleEnd = new Circle(endX, endY, 5, Color.TRANSPARENT);
        nodesList = new ArrayList<>();
        nodesList.add(line);
        nodesList.add(circleEnd);
        nodesList.add(circleStart);

        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("menu item 1");
        MenuItem menuItem2 = new MenuItem("menu item 2");
        MenuItem menuItem3 = new MenuItem("menu item 3");

        

        contextMenu.getItems().addAll(menuItem1,menuItem2, menuItem3);

        circleStart.setOnMouseDragged(event -> {
            circleStart.setCenterX(event.getX());
            circleStart.setCenterY(event.getY());
            line.setStartX(event.getX());
            line.setStartY(event.getY());
        });

        circleEnd.setOnMouseDragged(event -> {
            circleEnd.setCenterX(event.getX());
            circleEnd.setCenterY(event.getY());
            line.setEndX(event.getX());
            line.setEndY(event.getY());
        });
    }

    public Line getLine() {
        return line;
    }

    public Circle getCircleStart() {
        return circleStart;
    }

    public Circle getCircleEnd() {
        return circleEnd;
    }

    public List<Node> getAllNodes(){
        return nodesList;
    }
}
