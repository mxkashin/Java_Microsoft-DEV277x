import java.util.ArrayList;

/**
 * Created by sierra on 10/18/17.
 */
public class hoho {
    public static void main(String[] args){
        ArrayList<Integer> numb = new ArrayList<Integer>();
        numb.add(1);
        numb.add(2);
        numb.add(3);
        numb.remove(2);
        numb.set(1, 0);
        //numb.add(5);
        //numb.remove(0);
        System.out.print(numb);
    }
}
