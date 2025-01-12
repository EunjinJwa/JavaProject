package jinny.study.etc;

import java.util.HashSet;
import java.util.Set;

public class GenericMethod<E> {

    private E status;

    public GenericMethod(E status) {
        this.status = status;
    }

    public void callAny(E status) {
        System.out.println(status);
    }
    public static <E> Set<E> union(Set<E> s1) {
        return s1;
    }

    private void test() {
        Set<String> union = GenericMethod.union(new HashSet<String>());
    }

}
