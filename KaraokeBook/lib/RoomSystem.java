package lib;

import java.time.LocalTime;
import java.util.ArrayList;

public class RoomSystem {
    private ArrayList<RoomTime> roomTimes = new ArrayList<>();
    private ArrayList<RoomTime> roomUser = new ArrayList<>(); 
    private ArrayList<User> user = new ArrayList<>();
    private User userLogin;
    public void register(User userId){
        user.add(userId);
    }
    public void login(User userId){
        for(int i = 0 ; i<user.size();i++){
            if(userId.equals(user.get(i))){
                userLogin = userId;
            }
        }
    }
    public void showRoom(){
        for(int i =0 ;i<roomTimes.size();i++){
            System.out.println(roomTimes.get(i).toString()+"\n");
        }
    }
    public void showRoomUser(){
        for(int i =0 ;i<roomUser.size();i++){
            System.out.println(roomUser.get(i).toString()+"\n");
        }
    }
    public void setupRoomUser(){
        roomUser.clear();
        for(int i =0 ;i<roomTimes.size();i++){
            if(roomTimes.get(i).getUser().equals(userLogin)){
                roomUser.add(roomTimes.get(i));
            }
        }
    }
    public void addBookRoom(Room room,LocalTime start,LocalTime end){
        RoomTime roomTime = new RoomTime(room, userLogin, start,end);
        roomTime.getRoom().setStatus(true);
        roomTimes.add(roomTime);
    }

    public void removeBookRoom(Room room,LocalTime start,LocalTime end){
        for(int i =0;i<roomTimes.size() ;i++)
        {
            if(roomTimes.get(i).equals(new RoomTime(room, userLogin, start, end))){
                roomTimes.remove(i);
            }
        }
        RoomTime roomTime = new RoomTime(room, userLogin, start,end);
        roomTime.getRoom().setStatus(false);
        roomTimes.add(roomTime);
    }
}
