package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {

    public Button button;
    public Pane pane;

    public void onButtonClick() {
        //Node line = new Line(50, 50, 100, 100);
        Circle circle = new Circle(30, 30,40, Color.RED);
        circle.setOnMouseClicked(event ->{
            System.out.println("I was clicked");
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
        });
        circle.setOnMouseDragged(event -> {
            System.out.println("Drag over");
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
        });
        pane.getChildren().addAll(circle);
    }

}
