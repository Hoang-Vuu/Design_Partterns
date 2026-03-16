package visitor.shapes;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalSizeMb = 0;

    public int getTotalSizeMb() {
        return totalSizeMb;
    }

    @Override
    public void visit(FsFile file) {
        totalSizeMb += file.getSizeMb();
    }

    @Override
    public void visit(Directory directory) {
        // traverse children
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }
}