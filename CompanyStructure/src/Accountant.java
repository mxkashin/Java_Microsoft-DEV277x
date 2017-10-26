public class Accountant extends BuisinessEmployee {
    private double bonus = 0;

    public Accountant(String name){
        super(name);
    }

    @Override
    public double getBonusBudget() {
        return bonus;
    }


}
