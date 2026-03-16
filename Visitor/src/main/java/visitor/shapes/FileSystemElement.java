package visitor.shapes;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}