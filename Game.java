//////////////////////////////////////////////////////////////////////////
//Karl Cassel & Yuna Choe
//CruzID: kcassel (Karl)
//CruzID: yuchoe (Yuna)
//Date: Nov 7, 2014
// Game.java
// Where the actual game is played and the file is read. 
//////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.io.BufferedReader;
import static java.lang.System.*;
import java.util.ArrayList;

class Game {
	public static void main(String[] args) throws IOException{
		String fileName = null;
		String temp = null;
		File f;
		BufferedReader systemIn;
		Room insertedRoom = new Room();
		LinkedRoomList adventure = new LinkedRoomList();

		
		if(args.length > 1) 
        {
            System.out.println("Cannot pass more than 1 argument.");
        }
        else if(args.length == 1) 
        {
        	try {
                fileName = args[0];
                f = new File(fileName);
                systemIn = new BufferedReader(new FileReader(f));
                temp = systemIn.readLine();
                while(temp != null) 
                {
	            	if(temp.length() > 1) {
	                    if(temp.substring(0,1).equals("r"))
	                    {
	                    	insertedRoom.roomName = temp.substring(2,temp.length());
	                    }
	                    else if(temp.substring(0,1).equals("d"))
	                    {
	                    	insertedRoom.description.add(temp.substring(2,temp.length()));
	                    }
	                    else if(temp.substring(0,1).equals("o"))
	                    {
	                    	insertedRoom.choiceList.add(temp.substring(2,temp.length()));
	                    }
	                    else if(temp.substring(0,1).equals("t"))
	                    {
	                    	insertedRoom.roomList.add(temp.substring(2,temp.length()));
	                    }
	                    else
	                    {
	                    	// does nothing
	                    }
	                } 
	                else 
	                {
	                	adventure.insertLast(insertedRoom);
	                	insertedRoom.clearRoom();
	                }
                    temp = systemIn.readLine();
                }

            } catch(RuntimeException e) {
                System.out.println("File failed to process.");
            } catch(FileNotFoundException b) {
                System.out.println("File not found.");
            } catch(IOException ex) {
            	System.out.println("End of file.");
            }
        } 
        else 
        {
            System.out.println("No arguments passed.");
        }

        // when the game begins
        while(true)
        {
        	adventure.showRoom();
        }
	}
}