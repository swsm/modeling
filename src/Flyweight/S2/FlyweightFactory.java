package Flyweight.S2;

import java.util.Hashtable;

public class FlyweightFactory {
    private Hashtable<String, Flyweight> flyweights = new Hashtable<String, Flyweight>();
    public FlyweightFactory() {
        this.flyweights.put("X", new ConcreteFlyweight());
        this.flyweights.put("Y", new ConcreteFlyweight());
        this.flyweights.put("Z", new ConcreteFlyweight());
    }
    
    public Flyweight getFlyweight(String key) {
        return ((Flyweight)this.flyweights.get(key));
    }
}
