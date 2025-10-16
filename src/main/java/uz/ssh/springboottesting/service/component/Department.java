package uz.ssh.springboottesting.service.component;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationUnit {
    private final String name;
    private final List<OrganizationUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addUnit(OrganizationUnit unit) {
        children.add(unit);
    }

    public void removeUnit(OrganizationUnit unit) {
        children.remove(unit);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (OrganizationUnit unit : children) {
            unit.showDetails(); // uniform treatment
        }
    }

    public OrganizationUnit[] getChildren() {
        return children.toArray(new OrganizationUnit[0]);
    }
}
