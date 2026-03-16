package visitor.shapes;

public interface FileSystemVisitor {
    void visit(FsFile file);
    void visit(Directory directory);
}