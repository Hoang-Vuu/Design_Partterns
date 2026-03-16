package visitor.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    public List<FileSystemElement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Directory{name='" + name + "', children=" + children.size() + "}";
    }
}