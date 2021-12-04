package rooms;
public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;


    public Room(String description) 
    {
        this.description = description;
    }


    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    
    public String getDescription()
    {
        return description;
    }


    public Room getNorthExit() {
        return northExit;
    }


    public void setNorthExit(Room northExit) {
        this.northExit = northExit;
    }


    public Room getSouthExit() {
        return southExit;
    }


    public void setSouthExit(Room southExit) {
        this.southExit = southExit;
    }


    public Room getEastExit() {
        return eastExit;
    }


    public void setEastExit(Room eastExit) {
        this.eastExit = eastExit;
    }


    public Room getWestExit() {
        return westExit;
    }


    public void setWestExit(Room westExit) {
        this.westExit = westExit;
    }

    

}
