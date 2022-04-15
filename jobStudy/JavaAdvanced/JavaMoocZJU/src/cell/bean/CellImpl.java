package cell.bean;

import java.awt.*;

/**
 * @author filwsx
 * @create 2022-03-27 15:33
 */
public class CellImpl implements Cell{
    private boolean alive = false;

    public void die() { alive = false; }
    public void reborn() { alive = true; }
    public boolean isAlive() { return alive; }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        g.drawRect(x, y, size, size);
        if ( alive ) {
            g.fillRect(x, y, size, size);
        }
    }
}
