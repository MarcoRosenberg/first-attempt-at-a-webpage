public class Room {
    public int id;
    public String name;
    public String description;
    public Integer north, south, east, west;

    public Room(int id, String name, String description, Integer north, Integer south, Integer east, Integer west) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
}
