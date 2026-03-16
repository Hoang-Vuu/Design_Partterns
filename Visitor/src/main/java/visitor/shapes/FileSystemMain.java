package visitor.shapes;

public class FileSystemMain {

    public static void main(String[] args) {
        // Create file system structure:
        // root/
        //   docs/
        //      report.pdf (12)
        //      notes.txt  (3)
        //   src/
        //      Main.java  (1)
        //      Utils.java (2)
        //   README.md     (1)

        Directory root = new Directory("root");

        Directory docs = new Directory("docs");
        docs.add(new FsFile("report.pdf", 12));
        docs.add(new FsFile("notes.txt", 3));

        Directory src = new Directory("src");
        src.add(new FsFile("Main.java", 1));
        src.add(new FsFile("Utils.java", 2));

        root.add(docs);
        root.add(src);
        root.add(new FsFile("README.md", 1));

        // 1) Size calculator visitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size (MB): " + sizeVisitor.getTotalSizeMb());

        // 2) Search visitor (example: find .java files)
        SearchVisitor javaSearch = SearchVisitor.byExtension(".java");
        root.accept(javaSearch);
        System.out.println("Found .java files:");
        for (FsFile f : javaSearch.getMatches()) {
            System.out.println("- " + f.getName() + " (" + f.getSizeMb() + " MB)");
        }

        // Another search: name contains "note"
        SearchVisitor noteSearch = SearchVisitor.nameContains("note");
        root.accept(noteSearch);
        System.out.println("Found files with 'note' in name:");
        for (FsFile f : noteSearch.getMatches()) {
            System.out.println("- " + f.getName());
        }
    }
}