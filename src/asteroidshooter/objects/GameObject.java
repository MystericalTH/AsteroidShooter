package asteroidshooter.objects;
import java.awt.Graphics;

import asteroidshooter.main.Game;
public abstract class GameObject extends Point {
    protected Game game;
    protected double theta = 0;
    public abstract void update();
    protected abstract void updatePos();
    public abstract void render(Graphics g);
    // public abstract void isCollided(Object o);

    GameObject() {
        super(0,0);
    }

    GameObject(double x, double y) {
        super(x,y);
    }
    GameObject(double x, double y, double theta) {
        super(x,y);
        this.theta = theta;
    }

    GameObject(Game game) {
        this();
        this.game=game;
    }

}

