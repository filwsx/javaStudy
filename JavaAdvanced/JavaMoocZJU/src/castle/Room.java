package castle;

import java.util.HashMap;

/**
 * @author filwsx
 * @create 2022-03-26 11:15
 */
public class Room {
    private String roomName = null;
    //Room里定义Room，不会递归循环了吗。不会吧，仅仅是一个地址
    private HashMap<String,Room> roomHashMap = new HashMap<>();

    public Room(){
        roomHashMap.put("west",null);
        roomHashMap.put("north",null);
        roomHashMap.put("east",null);
        roomHashMap.put("south",null);
    }

    public Room(String roomName){
        this();
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room getNextRoom(String direction){
        return roomHashMap.get(direction);
    }

    public boolean setNextRoom(String direction,Room nextRoom){
        if(roomHashMap.containsKey(direction)){
            roomHashMap.put(direction,nextRoom);
            return true;
        }else{
            return false;
        }
    }

    public void setAllRoom(Room east,Room south,Room west,Room north){
        setNextRoom("east",east);
        setNextRoom("south",south);
        setNextRoom("west",west);
        setNextRoom("north",north);
    }

    @Override
    public String toString() {
        String exit = "";
        for(String s:roomHashMap.keySet()){
            if(roomHashMap.get(s) != null){
                exit = s + " ";
            }
        }
        return "你现在在：" + roomName + "。\n" +
                "出口有：" + exit + "";
    }

    public Room getWest() {
        return getNextRoom("west");
    }

    public boolean setWest(Room west) {
        return setNextRoom("west",west);
    }

    public Room getNorth() {
        return getNextRoom("north");
    }

    public boolean setNorth(Room north) {
        return setNextRoom("north",north);
    }

    public Room getEast() {
        return getNextRoom("east");
    }

    public boolean setEast(Room east) {
        return setNextRoom("east",east);
    }

    public Room getSouth() {
        return getNextRoom("south");
    }

    public boolean setSouth(Room south) {
        return setNextRoom("south",south);
    }
}
