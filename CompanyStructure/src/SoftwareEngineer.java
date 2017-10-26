public class SoftwareEngineer extends TechnicalEmployee {
    private int checkIns = 0;
    private boolean codeAccess = false;


    public SoftwareEngineer(String name){
        super(name);
    }

    @Override
    int getSuccessfulCheckins() {
        return checkIns;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access){
        codeAccess = access;
    }

    public boolean checkinCode(){
        if (codeAccess){
            checkIns++;
            return true;
        }
        return false;
    }

}
