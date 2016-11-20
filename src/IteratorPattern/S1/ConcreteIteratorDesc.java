package IteratorPattern.S1;

public class ConcreteIteratorDesc extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;
    
    public ConcreteIteratorDesc(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        current = this.aggregate.count() - 1;
    }

    @Override
    public Object first() {
        return aggregate.getOne(this.aggregate.count() - 1);
    }

    @Override
    public Object next() {
        Object ret = null;
        this.current--;
        if (this.current >= 0) {
            ret = this.aggregate.getOne(this.current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return this.current < 0 ? true : false;
    }

    @Override
    public Object currentItem() {
        return this.aggregate.getOne(this.current);
    }

}
