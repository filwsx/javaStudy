package cell.bean;

import java.awt.Graphics;

/**
 * @author filwsx
 * @create 2022-03-26 14:53
 */

public interface Cell {

    public void die();

    public void reborn();

    public boolean isAlive();

    public void draw(Graphics g, int x, int y, int size);

}
