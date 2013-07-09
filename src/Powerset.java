import java.util.*;


public class Powerset<T> {


    public Set<Set<T>> findPowerset(Set<T> input){
        Set<Set<T>> result = new HashSet<Set<T>>();
        result.add(new HashSet<T>()); //Add Empty Set
        for(T x : input){
            for(Set<T> set : new HashSet<Set<T>>(result)){
                Set<T> incl = new HashSet<T>(set);
                incl.add(x);
                result.add(incl);
            }
        }
        return result;
    }

    public Set<Set<T>> findPowersetRecursive(List<T> input){
        Set<Set<T>> result = new HashSet<Set<T>>();

        if(input.isEmpty()){
            result.add(new HashSet<T>());
            return result;
        }

        T head = input.remove(0);
        Set<Set<T>> tailPowerset = findPowersetRecursive(input);
        result.addAll(tailPowerset);
        for(Set<T> tailSet : tailPowerset){
            Set<T> headSet = new HashSet<T>(tailSet);
            headSet.add(head);
            result.add(headSet);
        }
        return result;
    }
}
