import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * sealed classes
 */
public class Java17 {
    public static void main(String[] args) {
        CustomHashSet<String> testt = new CustomHashSet<String>();
        testt.addAll(List.of("chris", "neve", "jug"));
        System.out.println(testt.getCount());
    }
}


class CustomHashSet<T> extends HashSet<T> {
    private int count = 0;
    @Override
    public boolean add(T t) {
        count++;
        return super.add(t);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        count += c.size();
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }
}

final class Christopher extends Admin implements AdminOps {

}
final class Nicolas extends Admin implements AdminOps {

}
non-sealed class Toto extends Admin {

}
sealed interface AdminOps permits Christopher, Nicolas {

}

abstract sealed class Admin permits Christopher, Nicolas, Toto {

}