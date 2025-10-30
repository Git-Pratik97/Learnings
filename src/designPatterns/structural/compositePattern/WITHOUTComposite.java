package designPatterns.structural.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class WITHOUTComposite {
    public static void main(String[] args) {
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        Folder folder = new Folder("Documents");
        folder.addFile(file1);
        folder.addFile(file2);

        folder.showDetails();
    }
}

class File{
    String name;

    public File(String name){
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File : " + name);
    }
}

class Folder {
    List<File> files = new ArrayList<>();
    String name;

    public Folder(String name){
        this.name = name;
    }

    public void addFile(File file){
        files.add(file);
    }

    public void showDetails() {
        System.out.println("Folders: " + name);
        for(File file: files){
            file.showDetails();
        }
    }
}
