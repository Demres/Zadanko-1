package sample;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class MyRectangle {
    Line lineTop, lineBottom, lineLeft, lineRight;
    Circle leftTop, rightTop, leftBottom, rightBottom;
    List<Node> nodeList;

    MyRectangle(double startX, double startY, double height, double width){

        nodeList = new ArrayList<>();

        lineTop = new Line(startX, startY, startX + width, startY);
        lineTop.setStrokeWidth(5);

        lineBottom = new Line(startX, startY + height, startX + width, startY + height);
        lineBottom.setStrokeWidth(5);

        lineLeft = new Line(startX, startY, startX, startY + height);
        lineLeft.setStrokeWidth(5);

        lineRight = new Line(startX + width, startY, startX + width, startY + height);
        lineRight.setStrokeWidth(5);

        leftTop = new Circle(startX, startY, 5, Color.TRANSPARENT);
        leftBottom = new Circle(startX, startY + height, 5, Color.TRANSPARENT);
        rightTop = new Circle(startX + width, startY, 5, Color.TRANSPARENT);
        rightBottom= new Circle(startX + width, startY + height, 5, Color.TRANSPARENT);

        lineTop.setOnMouseDragged(event -> {
            lineTop.setStartY(event.getY());
            lineTop.setEndY(event.getY());
            lineLeft.setStartY(event.getY());
            lineRight.setStartY(event.getY());
            leftTop.setCenterY(event.getY());
            rightTop.setCenterY(event.getY());
        });
        lineTop.setOnMouseEntered(event -> {
            lineTop.setCursor(Cursor.CLOSED_HAND);
        });

        lineBottom.setOnMouseDragged(event -> {
            lineBottom.setStartY(event.getY());
            lineBottom.setEndY(event.getY());
            lineLeft.setEndY(event.getY());
            lineRight.setEndY(event.getY());
            leftBottom.setCenterY(event.getY());
            rightBottom.setCenterY(event.getY());
        });
        lineBottom.setOnMouseEntered(event -> {
            lineBottom.setCursor(Cursor.CLOSED_HAND);
        });

        lineLeft.setOnMouseDragged(event -> {
            lineLeft.setStartX(event.getX());
            lineLeft.setEndX(event.getX());
            lineTop.setStartX(event.getX());
            lineBottom.setStartX(event.getX());
            leftTop.setCenterX(event.getX());
            leftBottom.setCenterX(event.getX());
        });
        lineLeft.setOnMouseEntered(event -> {
            lineLeft.setCursor(Cursor.CLOSED_HAND);
        });

        lineRight.setOnMouseDragged(event -> {
            lineRight.setStartX(event.getX());
            lineRight.setEndX(event.getX());
            lineTop.setEndX(event.getX());
            lineBottom.setEndX(event.getX());
            rightBottom.setCenterX(event.getX());
            rightTop.setCenterX(event.getX());
        });
        lineRight.setOnMouseEntered(event -> {
            lineRight.setCursor(Cursor.CLOSED_HAND);
        });

        leftTop.setOnMouseDragged(event -> {
            lineTop.setStartX(event.getX());
            lineTop.setStartY(event.getY());
            lineTop.setEndY(event.getY());

            lineLeft.setStartX(event.getX());
            lineLeft.setStartY(event.getY());
            lineLeft.setEndX(event.getX());

            lineBottom.setStartX(event.getX());

            lineRight.setStartY(event.getY());

            leftTop.setCenterX(event.getX());
            leftTop.setCenterY(event.getY());

            rightTop.setCenterY(event.getY());
            leftBottom.setCenterX(event.getX());
        });
        leftTop.setOnMouseEntered(event -> {

        });

        rightTop.setOnMouseDragged(event -> {
            lineTop.setEndX(event.getX());
            lineTop.setEndY(event.getY());
            lineTop.setStartY(event.getY());

            lineRight.setStartX(event.getX());
            lineRight.setStartY(event.getY());
            lineRight.setEndX(event.getX());

            lineBottom.setEndX(event.getX());

            lineLeft.setStartY(event.getY());

            rightTop.setCenterX(event.getX());
            rightTop.setCenterY(event.getY());

            rightBottom.setCenterX(event.getX());
            leftTop.setCenterY(event.getY());
        });

        leftBottom.setOnMouseDragged(event -> {
            lineBottom.setStartX(event.getX());
            lineBottom.setStartY(event.getY());
            lineBottom.setEndY(event.getY());

            lineLeft.setEndX(event.getX());
            lineLeft.setEndY(event.getY());
            lineLeft.setStartX(event.getX());

            lineTop.setStartX(event.getX());

            lineRight.setEndY(event.getY());

            leftBottom.setCenterX(event.getX());
            leftBottom.setCenterY(event.getY());

            leftTop.setCenterX(event.getX());
            rightBottom.setCenterY(event.getY());
        });

        rightBottom.setOnMouseDragged(event -> {
            lineBottom.setEndX(event.getX());
            lineBottom.setEndY(event.getY());
            lineBottom.setStartY(event.getY());

            lineRight.setEndX(event.getX());
            lineRight.setEndY(event.getY());
            lineRight.setStartX(event.getX());

            lineTop.setEndX(event.getX());

            lineLeft.setEndY(event.getY());

            rightBottom.setCenterX(event.getX());
            rightBottom.setCenterY(event.getY());

            leftBottom.setCenterY(event.getY());
            rightTop.setCenterX(event.getX());
        });



        nodeList.add(lineTop);
        nodeList.add(lineBottom);
        nodeList.add(lineLeft);
        nodeList.add(lineRight);
        nodeList.add(leftTop);
        nodeList.add(rightTop);
        nodeList.add(leftBottom);
        nodeList.add(rightBottom);

//        lineTop.setOnMouseClicked(event -> {
//            lineTop.setEndX(lineTop.getEndX() + 10);
//        });
    }

    public List<Node> getAllNodes() {
        return nodeList;
    }
}
