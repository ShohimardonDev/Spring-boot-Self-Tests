package uz.ssh.springboottesting.service.builder;

public class Main {
    public static void main(String[] args) {
        // Using the builder to create a computer object
        Computer gamingComputer = new Computer.ComputerBuilder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("MSI Z490")
                .build();

        System.out.println(gamingComputer);

        // Creating a basic computer with only essential parts
        Computer basicComputer = new Computer.ComputerBuilder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println(basicComputer);
    }
}
