package sample;

import javafx.scene.shape.Line;

public class MyRectangle {
    Line lineTop, lineBottom, lineLeft, lineRight;
//    int startX, startY, height, width;

    MyRectangle(int startX, int startY, int height, int width){
//        this.height = height;
//        this.width = width;
//        this.startX = startX;
//        this.startY = startY;

        lineTop = new Line(startX, startY, startX + width, startY);
        lineTop.setStrokeWidth(10);

        lineTop.setOnMouseClicked(event -> {
            lineTop.setEndX(lineTop.getEndX() + 10);
        });
    }

    public Line getLineTop() {
        return lineTop;
    }
}
