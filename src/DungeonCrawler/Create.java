package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Create extends Read {

    private ArrayList<Room> allRooms = new ArrayList<>();

    public void createRooms(String info) throws FileNotFoundException {
        Read fileInfo = new Read();
        this.allRooms = fileInfo.readFile(info);
    }

    public ArrayList<Room> getAllRooms() {
        return allRooms;
    }
}
