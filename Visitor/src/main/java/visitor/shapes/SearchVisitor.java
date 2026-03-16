package visitor.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor implements FileSystemVisitor {

    private final Predicate<FsFile> criterion;
    private final List<FsFile> matches = new ArrayList<>();

    public SearchVisitor(Predicate<FsFile> criterion) {
        this.criterion = criterion;
    }

    public List<FsFile> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    @Override
    public void visit(FsFile file) {
        if (criterion.test(file)) {
            matches.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    // Helper factory methods (optional but handy)
    public static SearchVisitor byExtension(String extension) {
        String ext = extension.startsWith(".") ? extension : "." + extension;
        return new SearchVisitor(f -> f.getName().endsWith(ext));
    }

    public static SearchVisitor nameContains(String token) {
        return new SearchVisitor(f -> f.getName().contains(token));
    }
}