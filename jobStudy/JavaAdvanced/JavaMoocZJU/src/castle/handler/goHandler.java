package castle.handler;

import castle.Game;

/**
 * @author filwsx
 * @create 2022-03-26 13:58
 */
public class goHandler extends Handler{

    Game game = null;

    public goHandler(Game game){
        this.game = game;
    }

    @Override
    public void handle() {
        game.goRoom();
    }

}
