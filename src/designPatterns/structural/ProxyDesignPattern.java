package designPatterns.structural;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("Photo1.jpg");
        Image image2 = new ProxyImage("Photo2.jpg");

        //Image is loaded only when display() is called
        image1.display();
        System.out.println("-------------------------------");
        image1.display(); //This time is not loaded again
    }
}

//Subject Interface (Common Interface)
interface Image{
    void display();
}

//Real Object that loads and displays an image
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk(){
        System.out.println("Loading image: " + fileName);
    }

    /**
     *
     */
    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     */
    @Override
    public void display() {
        if(realImage == null){                          //Lazy Loading
            realImage = new RealImage(fileName);        //Load only when needed
        }
        realImage.display();
    }
}
