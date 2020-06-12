package DungeonCrawler;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    private String str;
    private ArrayList<Room> place = new ArrayList<>();

    public ArrayList readFile(String name) throws FileNotFoundException {


        try{
            File file = new File(name);
            Scanner content = new Scanner(file);
            //content.useDelimiter(";");
            //int count = 0;
            while(content.hasNextLine()){
                this.str = content.nextLine();
                this.place.add(parse(str));
                //count++;
            }

        }
        catch(FileNotFoundException ex){
            System.out.println( "The file " +name+" doesnt exist. Please check your spelling or provide a different file name");
        }
    return place;
    }

    public Room parse(String str){
        String name, number, description, win, N, S, E, W;////info;
        boolean winInBoolean;
        Room r = new Room();

        Scanner room = new Scanner(str);

        room.useDelimiter(";");
        while(room.hasNext()){
            name=room.next();
            number=room.next();
            int ID = Integer.parseInt(number);
            description =room.next();

            int north =Integer.parseInt(room.next());
            int south  = Integer.parseInt(room.next());
            int east  = Integer.parseInt(room.next());
            int west  = Integer.parseInt(room.next());

            //info = room.next();

            //Scanner NSEW = new Scanner(info);
            //NSEW.useDelimiter(",");
            //while(NSEW.hasNext()){

            //}

            win=room.next();
            if(win.equals("win")) {
                winInBoolean = true;
            }
            else {
                winInBoolean = false;
            }
             r =  new Room(name,ID,description,north,south,east,west,winInBoolean);
        }
        room.close();
        return r;
    }
}
