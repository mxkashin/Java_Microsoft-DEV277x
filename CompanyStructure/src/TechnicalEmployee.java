
public abstract class TechnicalEmployee extends Employee {


    public TechnicalEmployee(String name){
        super(name, 75000);
    }

    abstract int getSuccessfulCheckins();

    @Override
    public String employeeStatus() {
        getSuccessfulCheckins();
        return (getEmployeeID() + " " + getName() + " has " + getSuccessfulCheckins() +
                " successful check ins" );
    }
}
