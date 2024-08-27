package threads.producerconsumer;

import constructorChaining.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

    private int maxSize;
    private List<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        items = Collections.synchronizedList(new ArrayList<>());
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}
