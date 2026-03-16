package visitor.shapes;

public class FsFile implements FileSystemElement {
    private final String name;
    private final int sizeMb;

    public FsFile(String name, int sizeMb) {
        this.name = name;
        this.sizeMb = sizeMb;
    }

    public String getName() {
        return name;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "FsFile{name='" + name + "', sizeMb=" + sizeMb + "}";
    }
}