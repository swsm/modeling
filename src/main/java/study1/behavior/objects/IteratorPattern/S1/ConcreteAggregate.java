package study1.behavior.objects.IteratorPattern.S1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate {
    private List<Object> items = new ArrayList<Object>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count() {
        return this.items.size();
    }

    public Object getOne(int index) {
        return this.items.get(index);
    }

    public void insertOne(int index, Object o) {
        this.items.add(index, o);
    }


}
