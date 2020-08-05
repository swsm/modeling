package study1.behavior.objects.IteratorPattern.S1;

public class ConcreteIterator extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.getOne(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        this.current++;
        if (this.current < this.aggregate.count()) {
            ret = this.aggregate.getOne(this.current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return this.current >= this.aggregate.count() ? true : false;
    }

    @Override
    public Object currentItem() {
        return this.aggregate.getOne(this.current);
    }

}
