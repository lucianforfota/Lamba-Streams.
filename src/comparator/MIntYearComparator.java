package comparator;

import java.util.Comparator;

public class MIntYearComparator implements Comparator<Coin> {
    @Override
    public int compare(Coin c1, Coin c2) {
        //Varianta  1-folosind compareTo
        return Integer.valueOf(c1.getMintYear()).compareTo(Integer.valueOf(c2.getMintYear()));

        //Varianta 2-folosind direct compare
         //return Integer.compare(c1.getMintYear(), c2.getMintYear());
    }
}
