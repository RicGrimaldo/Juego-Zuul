package rooms;
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;


    public Room(String description) 
    {
        this.description = description;
    }
     
    public String getDescription()
    {
        return description;
    }

    public void setNorthExit(Room northExit) {
        this.northExit = northExit;
    }

    public void setSouthExit(Room southExit) {
        this.southExit = southExit;
    }

    public void setEastExit(Room eastExit) {
        this.eastExit = eastExit;
    }

    public void setWestExit(Room westExit) {
        this.westExit = westExit;
    }

    public Room getNorthExit() {
        return northExit;
    }

    public Room getSouthExit() {
        return southExit;
    }

    public Room getEastExit() {
        return eastExit;
    }

    public Room getWestExit() {
        return westExit;
    }
}
