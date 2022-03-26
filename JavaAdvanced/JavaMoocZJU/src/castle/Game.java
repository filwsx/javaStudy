package castle;

import java.util.Scanner;

/**
 * @author filwsx
 * @create 2022-03-26 11:15
 */
public class Game {

    private Map map = new Map();

    private Room currentRoom = null;

    public Game(){
        currentRoom = map.initMap();
    }

    private void printHelp()
    {
        System.out.print("迷路了吗？你可以做的命令有：go、bye、help");
        System.out.println("go的用法：\tgo east");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println(currentRoom);
        System.out.println();
    }

    private void goRoom(String direction){
        Room nextRoom = currentRoom.getNextRoom(direction);
        if(nextRoom != null){
            currentRoom = nextRoom;
            System.out.println(currentRoom);
        }else{
            System.out.println("那里没有门！");
        }
    }

    public static void play(){
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();

        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            if (words[0].equals("help") ) {
                game.printHelp();
            } else if (words[0].equals("go") ) {
                game.goRoom(words[1]);
            } else if ( words[0].equals("bye") ) {
                break;
            }
        }
        System.out.println("感谢您的光临。再见！");
        in.close();
    }
}
