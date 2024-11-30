import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root", false);
        root.addDirectory("documents");
        root.addDirectory("music");
        root.addDirectory("downloads");

        Directory documents = root.getChildren().get(root.getIndexNumber("documents"));
        documents.addDirectory("work");
        documents.getChildren().get(documents.getIndexNumber("work")).addFile("report.docx");
        documents.getChildren().get(documents.getIndexNumber("work")).addFile("presentation.pptx");
        documents.addDirectory("personal");
        documents.getChildren().get(documents.getIndexNumber("personal")).addFile("resume.pdf");

        Directory music = root.getChildren().get(root.getIndexNumber("music"));
        music.addDirectory("rock");
        music.addDirectory("pop");

        Directory rock = music.getChildren().get(music.getIndexNumber("rock"));
        rock.addDirectory("album1");
        rock.getChildren().get(rock.getIndexNumber("album1")).addFile("song1.mp3");
        rock.getChildren().get(rock.getIndexNumber("album1")).addFile("song2.mp3");

        Directory pop = music.getChildren().get(music.getIndexNumber("pop"));
        pop.addDirectory("album2");
        pop.getChildren().get(pop.getIndexNumber("album2")).addFile("song3.mp3");

        Directory downloads = root.getChildren().get(root.getIndexNumber("downloads"));
        downloads.addDirectory("software");
        downloads.getChildren().get(downloads.getIndexNumber("software")).addFile("program1.exe");
        downloads.getChildren().get(downloads.getIndexNumber("software")).addFile("program2.exe");
        downloads.addDirectory("images");
        downloads.getChildren().get(downloads.getIndexNumber("images")).addFile("image1.jpg");
        downloads.getChildren().get(downloads.getIndexNumber("images")).addFile("image2.jpg");

        root.addFile("readme.txt");

        root.printDirectoryStructure();

        System.out.println("\nTotal file size: " + root.getSize());

        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        if(root.findFile(fileName) != null){
            System.out.println("\nFile path: " + root.findFile(fileName));
        }
        if(root.findFile(fileName) == null){
            System.out.println(fileName + " not found");
        }
    }
}