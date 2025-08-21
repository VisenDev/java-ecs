import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        var ecs = new Ecs();
        for(int i = 0; i < 1000; ++i) {
            System.out.print(ecs.newEntity() + " ");
        }
    }
}


class Ecs implements java.io.Serializable {
    HashMap<String, Object> components = new HashMap<String, Object>();
    Stack<Integer> freeEntities = new Stack<Integer>();
    Integer maxEntity = 0;
    SSet<Object> sets;

    public Integer newEntity() { 
        if(freeEntities.size() <= 0) {
            Integer oldMax = maxEntity;
            maxEntity = (maxEntity + 1) * 2;
            assert(oldMax != maxEntity);
            for(Integer i = maxEntity - 1; i >= oldMax; --i) {
                freeEntities.push(i);
            }
        }
        return freeEntities.pop();
    }

    public void defineComponent(String componentName, Class component) {
         
    }
}

