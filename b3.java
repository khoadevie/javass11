interface BonusEligible {
    double calculateBonus();
}

abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract double calculateSalary();

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.2;
    }
}

class PartTimeEmployee extends Employee {
    private int workingHour;
    private double ratePerHour;

    public PartTimeEmployee(int id, String name, int workingHour, double ratePerHour) {
        super(id, name);
        this.workingHour = workingHour;
        this.ratePerHour = ratePerHour;
    }

    double calculateSalary() {
        return workingHour * ratePerHour;
    }
}

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[2];

        employees[0] = new FullTimeEmployee(1, "An", 1000);
        employees[1] = new PartTimeEmployee(2, "Binh", 80, 5);

        for (Employee e : employees) {
            e.showInfo();
            System.out.println("Salary: " + e.calculateSalary());

            if (e instanceof BonusEligible) {
                System.out.println("Bonus: " + ((BonusEligible) e).calculateBonus());
            }

            System.out.println();
        }
    }
}
