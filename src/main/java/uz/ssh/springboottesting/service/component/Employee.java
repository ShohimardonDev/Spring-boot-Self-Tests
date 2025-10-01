package uz.ssh.springboottesting.service.component;

public class Employee implements OrganizationUnit {
    private final String name;
    private final String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + " (" + role + ")");
    }
}
