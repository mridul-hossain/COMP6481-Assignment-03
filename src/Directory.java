import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private boolean isFile;
    private List<Directory> children;
    public String space = "";

    public Directory(){
        this.name = "";
        this.isFile = false;
        this.children = new ArrayList<>();
    }

    public Directory(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.children = isFile ? null : new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void seIstFile(boolean isFile) {
        isFile = isFile;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setChildren(List<Directory> children) {
        this.children = children;
    }

    public List<Directory> getChildren() {
        return children;
    }

    public void addFile(String fileName) {
        children.add(new Directory(fileName, true));
    }

    public void addDirectory(String dirName) {
        children.add(new Directory(dirName, false));
    }

    public void printDirectoryStructure() {
        System.out.println(name);
        printDirectoryStructureHelper("\t");
    }

    private void printDirectoryStructureHelper(String space) {
        for (Directory child : children) {
            System.out.println(space + child.name);
            if (!child.isFile) {
                child.printDirectoryStructureHelper(space + "\t");
            }
        }
    }

    public int getSize() {
        if (isFile) {
            return 1; // Each file has a size of 1
        }
        int totalSize = 0;
        for (Directory child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public int getIndexNumber(String name){
        int indexNumber = 0;
        for(int i = 0; i < children.size(); i++){
            if(children.get(i).name.equals(name)){
                indexNumber = i;
            }
        }
        return indexNumber;
    }

    public String findFile(String fileName, String currentPath) {
        if (isFile && name.equals(fileName)) {
            return currentPath + "/" + name;
        } else if (!isFile) {
            for (Directory child : children) {
                String result = child.findFile(fileName, currentPath + "/" + name);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public String findFile(String fileName) {
        return findFile(fileName, "");
    }
}
