package cell.bean;

/**
 * @author filwsx
 * @create 2022-03-27 15:26
 */
public class Animal {
    private boolean alive = false;
    public void die() { alive = false; }
    public void reborn() { alive = true; }
    public boolean isAlive() { return alive; }
}
