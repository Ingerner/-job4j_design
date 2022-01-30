package set;

import java.util.Iterator;
import java.util.Objects;

import  ru.job4j.list.SimpleArrayList;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(5);

    @Override
    public boolean add(T value) {
      if (!contains(value)) {
          set.add(value);
          return true;
      }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T i : set) {
            if (Objects.equals(i, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
