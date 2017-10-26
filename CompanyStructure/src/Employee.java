
public abstract class Employee {
    private String name;
    private double baseSalary;
    private static int employeeID = 0;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID++;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String toString(){
        return employeeID + name;
    }

    abstract String employeeStatus();
}
