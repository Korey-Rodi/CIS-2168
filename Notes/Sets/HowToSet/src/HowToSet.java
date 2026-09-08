import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HowToSet {
    public static <E> boolean containsDuplicates(List<E> list){
        Set<E> seen= new HashSet<>();
        for(E item: list){
            if(seen.add(item)){
                return true;
            }
        }
        return false;
    }

}
