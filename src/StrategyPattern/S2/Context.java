package StrategyPattern.S2;

public class Context {

    Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void ContextInterface() {
        strategy.algorithmInterface();
    }
}
