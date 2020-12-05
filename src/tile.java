public class tile{

    public enum type {
        WATER, SHIPTRUE, SHIPFALSE, HIT, MISS, NEITHER
    }

    public enum shipSize {
        CARRIER,            // size 5
        BATTLESHIP,         // size 4
        DESTROYER,          // size 3
        SUBMARINE,          // size 3
        PATROL,             // size 2
        NEITHER             // for when you dont wanna
    }
}

