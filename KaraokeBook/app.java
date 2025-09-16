import java.time.LocalTime;

import lib.*;


public class app {
    public static void main(String[] args) {
        RoomSystem roomSystem = new RoomSystem();
        User A = new User(1);
        User B = new User(2);
        roomSystem.register(A);
        roomSystem.register(B);
        roomSystem.login(A);
        Room First = new Room("1-5", 101);
        roomSystem.addBookRoom(First,LocalTime.of(12, 0), LocalTime.of(13, 0));
        roomSystem.addBookRoom(First,LocalTime.of(11, 0), LocalTime.of(12, 0));
        roomSystem.addBookRoom(First,LocalTime.of(10, 0), LocalTime.of(11, 0));
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
        roomSystem.login(B);
        System.out.println("--------------------------------------");
        roomSystem.addBookRoom(First,LocalTime.of(10, 0), LocalTime.of(11, 0));
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
        System.out.println("--------------------------------------");
        roomSystem.login(A);
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
    }
}

