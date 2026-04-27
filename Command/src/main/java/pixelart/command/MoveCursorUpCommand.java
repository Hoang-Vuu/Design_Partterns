package pixelart.command;

import pixelart.model.PixelGrid;

public class MoveCursorUpCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveUp();
    }
}