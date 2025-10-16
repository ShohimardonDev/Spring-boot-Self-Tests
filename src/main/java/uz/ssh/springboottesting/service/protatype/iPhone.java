package uz.ssh.springboottesting.service.protatype;

/**
 * @author Shokhimardon
 * @since 10/14/25
 */
public class iPhone {
    private String model;
    private String color;
    private double price;

    private iPhone(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.price = builder.price;
    }

    public static class Builder {
        private String model;
        private String color;
        private double price;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public iPhone build() {
            return new iPhone(this);
        }
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

    public static void main(String[] args) {
        iPhone iphone = new iPhone.Builder()
                .model("iPhone 15")
                .color("Black")
                .price(999.99)
                .build();


    }
}

