package uz.ssh.springboottesting.service.proxy;

/**
 * @author Shokhimardon
 * @since 11/4/25
 */
public class ImageProxy implements Image {
    private HighResolutionImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new HighResolutionImage(filename); // Lazy loading
        }
        realImage.display();
    }
}
