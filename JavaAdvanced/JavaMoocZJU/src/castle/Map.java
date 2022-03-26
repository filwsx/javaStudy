package castle;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author filwsx
 * @create 2022-03-26 11:15
 */
public class Map {
    private HashMap<String,Room> map = new HashMap<>();

    private HashSet<String> roomNameList = new HashSet<>();

    public Map(){
        addRoomName();
        creatRooms();
        creatConnection();
    }

    // 创建一个房间，并存储
    // 输入为房间名
    private void creatRoom(String roomName){
        Room room = new Room(roomName);
        map.put(roomName,room);
    }

    // 设置某个房间之间的地理关联
    // 输入房间名。依次对应：要设置的房间，东南西北四个方向的房间名字
    private void creatAConnection(String roomName,String east,String south,String west,String north){
        Room room = map.get(roomName);
        Room eastRoom = map.get(east);
        Room southRoom = map.get(south);
        Room westRoom = map.get(west);
        Room northRoom = map.get(north);
        room.setAllRoom(eastRoom,southRoom,westRoom,northRoom);
    }

    // 添加房间名
    private void addRoomName(){
        roomNameList.add("入口");
        roomNameList.add("卧室");
        roomNameList.add("大厅");
        roomNameList.add("地下室");
        roomNameList.add("厨房");
        roomNameList.add("厕所");
        roomNameList.add("恶龙");
        roomNameList.add("虚无");
        roomNameList.add("酒吧");
    }
    
    // 创建多个房间
    private void creatRooms(){
        for(String roomName:roomNameList ){
            creatRoom(roomName);
        }
    }

    //创建所有房间之间的关联
    private void creatConnection(){
        creatAConnection("入口",null,null,"酒吧","大厅");
        creatAConnection("卧室",null,"大厅","厕所",null);
        creatAConnection("大厅","地下室","入口","厨房","卧室");
        creatAConnection("地下室","恶龙",null,"大厅","虚无");
        creatAConnection("厨房","大厅",null,null,null);
        creatAConnection("厕所","卧室",null,null,null);
        creatAConnection("恶龙",null,null,"地下室",null);
        creatAConnection("虚无",null,null,null,null);
        creatAConnection("酒吧","入口",null,null,null);
    }
}
