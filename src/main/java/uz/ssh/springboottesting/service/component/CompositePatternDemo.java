package uz.ssh.springboottesting.service.component;

import java.util.Arrays;
import java.util.List;

public class CompositePatternDemo {
    static List<Employee> employees;
    static List<Department> departments;

    static {
        Employee e1 = new Employee("Alice", "Developer");
        Employee e2 = new Employee("Bob", "Tester");
        Employee e3 = new Employee("Charlie", "Manager");
        employees = Arrays.asList(e1, e2, e3);

        // Composite objects
        Department devTeam = new Department("Development Team");
        devTeam.addUnit(e1);
        devTeam.addUnit(e2);

        Department management = new Department("Management");
        management.addUnit(e3);

        Department headOffice = new Department("Head Office");
        headOffice.addUnit(devTeam);
        headOffice.addUnit(management);
        departments = Arrays.asList(headOffice, devTeam, management);
    }

    public static void main(String[] args) {
        withComposite();
        withoutComposite();
    }


    static void withComposite() {
        System.out.println("=== With Composite Pattern ===");
        // We don't care if it's a leaf (Employee) or composite (Department)
        departments.get(0).showDetails();
    }


    static void withoutComposite() {
        System.out.println("\n=== Without Composite Pattern ===");

        for (Department department : departments) {
            System.out.println("Department: " + department.getName());

            // Now we need to manually dig into children
            for (OrganizationUnit unit : department.getChildren()) {
                if (unit instanceof Employee) {
                    Employee emp = (Employee) unit;
                    System.out.println("Employee: " + emp.getName());
                } else if (unit instanceof Department) {
                    Department subDept = (Department) unit;
                    System.out.println("Sub Department: " + subDept.getName());

                    // And again recurse manually...
                    for (OrganizationUnit subUnit : subDept.getChildren()) {
                        if (subUnit instanceof Employee) {
                            Employee emp = (Employee) subUnit;
                            System.out.println("Employee: " + emp.getName());
                        }
                    }
                }
            }
        }
    }


}
