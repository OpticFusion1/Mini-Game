package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Create extends Read {

    private ArrayList<Room> allRooms = new ArrayList<>();
    private ArrayList<Item> allItems = new ArrayList<>();
    public void createRooms(String roomInfo, String itemInfo) {
        Read fileInfo = new Read();
        this.allRooms = fileInfo.readFile(roomInfo,itemInfo);
        this.allItems = fileInfo.things;
    }


    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }
}
