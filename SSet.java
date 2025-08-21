import java.util.*;
import java.io.*;

public class SSet<T> implements Serializable {
    ArrayList<T> dense = new ArrayList<T>();
    ArrayList<Optional<Integer>> sparse = new ArrayList<Optional<Integer>>();
    //Optional<Integer> dense_top_to_sparse = Optional.empty();
   
    public void extendSparse(Integer newMax) {
        for(Integer i = sparse.size(); i < newMax; ++i) {
            sparse.add(Optional.empty());
        }
    }

    private void ensureValidIndex(Integer index) {
        assert(index >= 0);
        if(index + 1 > sparse.size()) {
            int oldsize = sparse.size();
            extendSparse(sparse.size() * 2 + 1);
            assert(sparse.size() > oldsize);
        }
    }

    private Integer denseAppend(Integer sparse_index, T value) {
        Integer len = dense.size();
        dense.add(value);
        assert(dense.get(len) == value);
        dense_top_to_sparse = sparse_index;
        return len;
    }


    public void set(Integer index, T value) {
        ensureValidIndex(index);
        Optional<Integer> di = sparse.get(index);

        if(di.isEmpty()) {
            sparse.set(index, Optional.of(denseAppend(value)));
        } else {
            dense.set(di.get(), value);
        }
        assert(sparse.get(dense_top_to_sparse).get() == dense.size() - 1);
    }

    public void unset(Integer index, T value) {
        ensureValidIndex(index);
        Optional<Integer> di = sparse.get(index);
        if(di.isEmpty()) return;

        if(dense.size() == 1) {
            
        }

    }

}
