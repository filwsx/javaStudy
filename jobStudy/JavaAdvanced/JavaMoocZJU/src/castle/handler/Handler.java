package castle.handler;

/**
 * @author filwsx
 * @create 2022-03-26 13:53
 */
public abstract class Handler {

    public abstract void handle();

    public boolean isBye(){
        return false;
    }
}
