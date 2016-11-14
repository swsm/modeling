package BuilderPattern.S1;

import java.awt.Graphics;

public class PersonThinBuilder {
    private Graphics g;
    public PersonThinBuilder(Graphics g) {
        this.g = g;
    }
    public void build() {
        g.drawOval(50, 20, 30, 30);
        g.drawRect(60, 50, 10, 50);
        g.drawLine(60, 50, 40, 100);
        g.drawLine(70, 50, 90, 100);
        g.drawLine(60, 100, 45, 150);
        g.drawLine(70, 100, 85, 150);
    }
}
