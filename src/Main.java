public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory();
        directory.addDirectory("My Computer");
        directory.addFile("Image 0");
        directory.getChildren().get(directory.getIndexNumber("My Computer")).addFile("Image 1");
        directory.printDirectoryStructure();
    }
}