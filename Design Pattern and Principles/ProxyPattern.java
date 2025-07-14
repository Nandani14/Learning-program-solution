// Proxy Pattern Example - Lazy loading images

// Step 1: Subject Interface
interface Image {
    void display();
}

// Step 2: RealImage - the actual heavy object
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();  // expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Step 3: ProxyImage - placeholder for RealImage
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);  // Lazy loading
        }
        realImage.display();
    }
}

// Step 4: Main App
public class ProxyPattern {
    public static void main(String[] args) {
        System.out.println("Abhinav opens the gallery...");

        Image image1 = new ProxyImage("college_farewell.jpg");
        Image image2 = new ProxyImage("project_demo.png");

        System.out.println("\nAbhinav views the first image:");
        image1.display();  // Loads + Displays

        System.out.println("\nAbhinav views the first image again:");
        image1.display();  // Only Displays

        System.out.println("\nAbhinav now views the second image:");
        image2.display();  // Loads + Displays
    }
}

