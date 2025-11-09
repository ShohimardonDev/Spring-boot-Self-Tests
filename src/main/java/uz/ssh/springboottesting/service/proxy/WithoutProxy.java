package uz.ssh.springboottesting.service.proxy;

/**
 * @author Shokhimardon
 * @since 11/4/25
 */
public class WithoutProxy {
    // Real object
    static class HighResolutionImage {
        private String filename;

        public HighResolutionImage(String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }

        private void loadImageFromDisk() {
            System.out.println("Loading " + filename);
        }

        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    public static void main(String[] args) {
        HighResolutionImage image1 = new HighResolutionImage("Photo1.jpg");
        HighResolutionImage image2 = new HighResolutionImage("Photo2.jpg");
        System.out.println("First call to display Photo1:");
        image1.display();
        System.out.println("First call to display Photo2:");

        image2.display();
    }

}
