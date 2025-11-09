package uz.ssh.springboottesting.service.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("Photo1.jpg");
        Image image2 = new ImageProxy("Photo2.jpg");

        System.out.println("First call to display Photo1:");
        image1.display(); // Loads only now

        System.out.println("Second call to display Photo1:");
        image1.display(); // Already loaded, no reload

        System.out.println("Displaying Photo2:");
        image2.display(); // Loads now
    }
}