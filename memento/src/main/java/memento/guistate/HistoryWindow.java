package memento.guistate;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;

public class HistoryWindow {

    private final Controller controller;
    private final Stage stage;
    private final ListView<IMemento> listView;

    // Keep an internal list so selection maps exactly to mementos
    private List<IMemento> items = new ArrayList<>();

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        this.stage = new Stage();
        this.listView = new ListView<>();

        Label title = new Label("History (click an item to restore):");
        VBox root = new VBox(title, listView);
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                controller.restoreFromHistory(newV);
            }
        });

        stage.setScene(new Scene(root, 520, 400));
        stage.setTitle("Model History");
    }

    public void show() {
        stage.show();
    }

    /**
     * Refresh the window contents.
     * We show: all undo-history states + the current state (at bottom).
     */
    public void refresh(List<IMemento> historySnapshot, IMemento currentState) {
        items = new ArrayList<>(historySnapshot);

        // also display current state so user can always jump back to "now"
        // (optional but useful; still counts as a state)
        items.add(currentState);

        listView.setItems(FXCollections.observableArrayList(items));
    }
}