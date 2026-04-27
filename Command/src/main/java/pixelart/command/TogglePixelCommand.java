package pixelart.command;

import pixelart.model.PixelGrid;

public class TogglePixelCommand implements Command {

    private final PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.togglePixel();
    }
}