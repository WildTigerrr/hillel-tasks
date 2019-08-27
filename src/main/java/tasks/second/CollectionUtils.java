package tasks.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionUtils {

    public <T> Collection<T> merge(Collection<T> collection, Object[] array) {
        collection.addAll(new ArrayList<T>((Collection<? extends T>) Arrays.asList(array)));
        return collection;
    }

}
