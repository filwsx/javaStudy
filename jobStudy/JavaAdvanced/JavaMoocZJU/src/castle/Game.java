package castle;

import castle.bean.Map;
import castle.bean.Room;
import castle.handler.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author filwsx
 * @create 2022-03-26 11:15
 */
public class Game {

    // 获取地图
    private Map map = new Map();

    // 创建操作容器
    private HashMap<String,Handler> handlerHashMap = new HashMap<>();

    // 保存当前位置
    private Room currentRoom = null;

    // 保存运动方向
    private String direction = null;

    // 初始化初始位置
    public Game(){
        currentRoom = map.initMap();
        handlerHashMap.put("go",new goHandler(this));
        handlerHashMap.put("help",new helpHandler());
        handlerHashMap.put("bye",new byeHandler());
        Handler welcome = new welcomeHandler(currentRoom);
        welcome.handle();
    }

    public void goRoom(){
        Room nextRoom = currentRoom.getNextRoom(direction);
        if(nextRoom != null){
            currentRoom = nextRoom;
            System.out.println(currentRoom);
        }else{
            System.out.println("没门！");
        }
        direction = null;
    }

    // 这里采用了课件提供的代码，几乎无修改，也是巧合了
    // 仅仅看了老师的游戏演示，主要精力花在如何构建地图描述对象上
    public void play(){
        Scanner in = new Scanner(System.in);

        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlerHashMap.get(words[0]);
            if (words.length>1){
                direction = words[1];
            }
            if(handler != null){
                handler.handle();
                // 这里很不优雅
                if(handler.isBye()){
                    break;
                }
            }else{
                System.out.println("命令有误");
            }
        }
        System.out.println("感谢您的光临。再见！");
        in.close();
    }
}
