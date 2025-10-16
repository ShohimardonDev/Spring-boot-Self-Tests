package uz.ssh.springboottesting.service.protatype;

/**
 * @author Shokhimardon
 * @since 10/14/25
 */
public class iPhoneClone implements Cloneable {
    private String model;
    private String color;
    private double price;

    public iPhoneClone(String model, String color, double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    protected iPhoneClone clone() {
        try {
            return (iPhoneClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        var original = new iPhoneClone("iPhone 15", "Black", 999.99);
        var cloned = original.clone();

        System.out.println("Original: " + original.getModel() + " " + original.getColor() + " " + original.getPrice());
        System.out.println("Cloned: " + cloned.getModel() + " " + cloned.getColor() + " " + cloned.getPrice());
    }
}