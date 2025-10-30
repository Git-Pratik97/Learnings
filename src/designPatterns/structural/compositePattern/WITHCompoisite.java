package designPatterns.structural.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class WITHCompoisite {
    public static void main(String[] args) {
        FileSystemComponent file1 = new CompositeFile("Document.txt");
        FileSystemComponent file2 = new CompositeFile("Photo.jpg");

        CompositeFolder folder1 = new CompositeFolder("My Documents");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        CompositeFile file3 = new CompositeFile("notes.txt");

        CompositeFolder rootFolder = new CompositeFolder("Root");
        rootFolder.addComponent(folder1);
        rootFolder.addComponent(file3);

        rootFolder.showDetails();

    }
}

// Component Interface
interface FileSystemComponent {
    void showDetails();
}

// Leaf: File (Does not contain other components)
class CompositeFile implements FileSystemComponent {
    private String name;

    public CompositeFile(String name){
        this.name = name;
    }


    /**
     *
     */
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite: Folder (can contain files and other folders)
class CompositeFolder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public CompositeFolder(String name){
        this.name = name;
    }

    public void addComponent(FileSystemComponent component){
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for(FileSystemComponent component: components){
            component.showDetails();
        }
    }
}

