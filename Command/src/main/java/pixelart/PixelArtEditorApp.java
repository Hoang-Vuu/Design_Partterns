package pixelart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import pixelart.command.*;
import pixelart.model.PixelGrid;

public class PixelArtEditorApp extends Application {

    private static final int CELL_SIZE = 40;

    private PixelGrid pixelGrid;
    private Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {
        pixelGrid = new PixelGrid();

        GridPane gridPane = createGrid();
        Button generateCodeBtn = new Button("Create Code");

        Command generateCodeCommand =
                new GenerateCodeCommand(pixelGrid);
        generateCodeBtn.setOnAction(e -> generateCodeCommand.execute());

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(generateCodeBtn);

        Scene scene = new Scene(root, 400, 420);

        setupKeyboard(scene);

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        refresh();
    }

    private GridPane createGrid() {
        GridPane pane = new GridPane();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setStroke(Color.GRAY);
                cells[row][col] = cell;
                pane.add(cell, col, row);
            }
        }
        return pane;
    }

    private void setupKeyboard(Scene scene) {

        Command up = new MoveCursorUpCommand(pixelGrid);
        Command down = new MoveCursorDownCommand(pixelGrid);
        Command left = new MoveCursorLeftCommand(pixelGrid);
        Command right = new MoveCursorRightCommand(pixelGrid);
        Command toggle = new TogglePixelCommand(pixelGrid);

        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();

            if (code == KeyCode.UP) up.execute();
            else if (code == KeyCode.DOWN) down.execute();
            else if (code == KeyCode.LEFT) left.execute();
            else if (code == KeyCode.RIGHT) right.execute();
            else if (code == KeyCode.SPACE) toggle.execute();

            refresh();
        });
    }

    private void refresh() {
        int[][] grid = pixelGrid.getGrid();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (grid[r][c] == 1) {
                    cells[r][c].setFill(Color.BLACK);
                } else {
                    cells[r][c].setFill(Color.WHITE);
                }

                if (r == pixelGrid.getCursorRow()
                        && c == pixelGrid.getCursorCol()) {
                    cells[r][c].setStroke(Color.RED);
                    cells[r][c].setStrokeWidth(2);
                } else {
                    cells[r][c].setStroke(Color.GRAY);
                    cells[r][c].setStrokeWidth(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}