import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

import lib.*;


public class app {
    public static void main(String[] args) {
        RoomSystem roomSystem = new RoomSystem();
        User A = new User(1);
        User B = new User(2);
        roomSystem.registerId(A);
        roomSystem.registerId(B);
        roomSystem.loginId(A);
        Room First = new Room("1-5", 101,150);
        roomSystem.selectRoom(First);
        roomSystem.addBookRoom(LocalTime.of(12, 0), LocalTime.of(13, 0));
        roomSystem.addBookRoom(LocalTime.of(11, 0), LocalTime.of(12, 0));
        roomSystem.addBookRoom(LocalTime.of(10, 0), LocalTime.of(11, 0));
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
        roomSystem.loginId(B);
        roomSystem.selectRoom(First);
        System.out.println("--------------------------------------");
        roomSystem.addBookRoom(LocalTime.of(10, 0), LocalTime.of(11, 0));
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
        System.out.println("--------------------------------------");
        roomSystem.loginId(A);
        roomSystem.setupRoomUser();
        roomSystem.showRoomUser();
    }
}

