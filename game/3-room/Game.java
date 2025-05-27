import java.util.Scanner;

public class Game {
    private static Room currentRoom;

    public static void start() {
        currentRoom = Database.getRoom(1); // Start in room 1
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + currentRoom.name);
            System.out.println(currentRoom.description);
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.startsWith("go ")) {
                move(command.substring(3));
            } else if (command.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    private static void move(String direction) {
        Integer nextRoomId = null;
        switch (direction) {
            case "north": nextRoomId = currentRoom.north; break;
            case "south": nextRoomId = currentRoom.south; break;
            case "east": nextRoomId = currentRoom.east; break;
            case "west": nextRoomId = currentRoom.west; break;
            default: System.out.println("Unknown direction."); return;
        }

        if (nextRoomId != null) {
            currentRoom = Database.getRoom(nextRoomId);
        } else {
            System.out.println("You can't go that way.");
        }
    }
}
