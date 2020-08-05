package study1.behavior.objects.StatePattern.S4;

public class Work {
    private State current;
    private double hour;
    private boolean finish = false;
    public Work() {
        current = new ForenoonState();
    }

    public void setState(State s) {
        this.current = s;
    }
    public void writeProgram() {
        current.writeProgram(this);
    }

    public double getHour() {
        return hour;
    }
    public void setHour(double hour) {
        this.hour = hour;
    }
    public boolean isFinish() {
        return finish;
    }
    public void setFinish(boolean finish) {
        this.finish = finish;
    }


}
