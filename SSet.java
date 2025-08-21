import java.util.*;
import java.io.*;

public class SSet<T> implements Serializable {
    ArrayList<T> dense;
    ArrayList<Optional<Integer>> sparse;
   
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

    public void set(Integer index, T value) {
        ensureValidIndex(index);
        Optional<Integer> di = sparse.get(index);

        if(di.isEmpty()) {
            
        }

        


    }

}
