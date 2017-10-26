public abstract class BuisinessEmployee extends Employee {

    public BuisinessEmployee(String name){
        super(name, 50000);
    }

    abstract double getBonusBudget();

    @Override
    String employeeStatus() {
        return (getEmployeeID() + " " + getName() + " with a budget of "
                + getBonusBudget());
    }
}
