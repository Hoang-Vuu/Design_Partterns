package pixelart.command;

import pixelart.model.PixelGrid;

public class GenerateCodeCommand implements Command {

    private final PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        System.out.println(grid.generateJavaCode());
    }
}
