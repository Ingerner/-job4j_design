package set;

import java.util.Iterator;
import java.util.Objects;

import  ru.job4j.list.SimpleArrayList;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(5);

    @Override
    public boolean add(T value) {
     boolean rsl = !contains(value);
      if (rsl) {
          set.add(value);
      }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T i : set) {
            if (Objects.equals(i, value)) {
                rsl =  true;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
