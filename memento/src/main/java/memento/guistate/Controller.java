package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    // Undo history
    private List<IMemento> history;

    // Redo history
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        // New change => redo history becomes invalid
        redoHistory.clear();
        model.setOption(optionNumber, choice);
        notifyHistoryChanged();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        // New change => redo history becomes invalid
        redoHistory.clear();
        model.setIsSelected(isSelected);
        notifyHistoryChanged();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            // Current -> redo
            redoHistory.add(model.createMemento());

            // Undo pop -> restore
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();

            notifyHistoryChanged();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            // Current -> undo
            history.add(model.createMemento());

            // Redo pop -> restore
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();

            notifyHistoryChanged();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    // ===== Support for History Window =====
    public List<IMemento> getHistorySnapshot() {
        return new ArrayList<>(history);
    }

    public IMemento getCurrentState() {
        return model.createMemento();
    }

    public void restoreFromHistory(IMemento memento) {
        // When jumping to a historical state, redo stack is cleared (reasonable default)
        redoHistory.clear();
        model.restoreState(memento);
        gui.updateGui();
        notifyHistoryChanged();
    }

    private void notifyHistoryChanged() {
        gui.onHistoryChanged();
    }
}