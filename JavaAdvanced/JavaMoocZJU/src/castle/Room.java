package castle;

import java.util.HashMap;

/**
 * @author filwsx
 * @create 2022-03-26 11:15
 */
public class Room {
    private Room west = null;
    private Room north = null;
    private Room east = null;
    private Room south = null;
    private String roomName = null;
    private HashMap<String,Room> roomHashMap = new HashMap<>();

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }
}
