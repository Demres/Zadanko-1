package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyLine {
    private Line line;
    private Circle circleStart;
    private Circle circleEnd;
    private List<Node> nodesList;

    MyLine(double startX, double startY, double endX, double endY){
        line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(5);
        circleStart = new Circle(startX, startY, 5, Color.TRANSPARENT);
        circleEnd = new Circle(endX, endY, 5, Color.TRANSPARENT);
        nodesList = new ArrayList<>();
        nodesList.add(line);
        nodesList.add(circleEnd);
        nodesList.add(circleStart);

        contextInit();
        eventInit();
    }

    private void contextInit(){
        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("Edit");
        menuItem1.setOnAction(event -> {

            Dialog<List<String>> dialog = new Dialog<>();
            dialog.setTitle("Edit");
            dialog.setHeaderText("Edit Line");

            ButtonType editButtonType = new ButtonType("Apply", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(editButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField startXField = new TextField();
            startXField.setText(String.valueOf(line.getStartX()));


            TextField startYField = new TextField();
            startYField.setText(String.valueOf(line.getStartY()));

            TextField endXField = new TextField();
            endXField.setText(String.valueOf(line.getEndX()));

            TextField endYField = new TextField();
            endYField.setText(String.valueOf(line.getEndY()));

            grid.add(new Label("StartX:"), 0, 0);
            grid.add(startXField, 1, 0);
            grid.add(new Label("StartY:"), 0, 1);
            grid.add(startYField, 1, 1);
            grid.add(new Label("EndX:"), 0, 2);
            grid.add(endXField, 1, 2);
            grid.add(new Label("EndY:"), 0, 3);
            grid.add(endYField, 1, 3);

            dialog.getDialogPane().setContent(grid);

            Platform.runLater(() -> startXField.requestFocus());

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == editButtonType) {
                    List<String> list = new ArrayList<String>(Arrays.asList(startXField.getText(), startYField.getText(), endXField.getText(), endYField.getText()));
                    return list;
                }
                return null;
            });

            Optional<List<String>> result = dialog.showAndWait();

            result.ifPresent(list -> {
                line.setStartX(Double.parseDouble(list.get(0)));
                line.setStartY(Double.parseDouble(list.get(1)));
                line.setEndX(Double.parseDouble(list.get(2)));
                line.setEndY(Double.parseDouble(list.get(3)));

                circleStart.setCenterX(Double.parseDouble(list.get(0)));
                circleStart.setCenterY(Double.parseDouble(list.get(1)));

                circleEnd.setCenterX(Double.parseDouble(list.get(2)));
                circleEnd.setCenterY(Double.parseDouble(list.get(3)));

            });

        });

        contextMenu.getItems().addAll(menuItem1);

        line.setOnContextMenuRequested(event -> {
            contextMenu.show(line, event.getScreenX(), event.getScreenY());
        });
    }

    private void eventInit(){

        circleStart.setOnMouseDragged(event -> {
            circleStart.setCenterX(event.getX());
            circleStart.setCenterY(event.getY());
            line.setStartX(event.getX());
            line.setStartY(event.getY());
        });

        circleStart.setOnMouseEntered(event -> {
            circleStart.setCursor(Cursor.CLOSED_HAND);
        });

        circleEnd.setOnMouseDragged(event -> {
            circleEnd.setCenterX(event.getX());
            circleEnd.setCenterY(event.getY());
            line.setEndX(event.getX());
            line.setEndY(event.getY());
        });

        circleEnd.setOnMouseEntered(event -> {
            circleEnd.setCursor(Cursor.CLOSED_HAND);
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
