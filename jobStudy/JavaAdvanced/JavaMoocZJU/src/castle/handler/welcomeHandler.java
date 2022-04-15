package castle.handler;

import castle.bean.Room;

/**
 * @author filwsx
 * @create 2022-03-26 13:58
 */
public class welcomeHandler extends Handler{

    private Room currentRoom = null;

    public welcomeHandler(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    @Override
    public void handle() {
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println(currentRoom);
        System.out.println();
    }
}
