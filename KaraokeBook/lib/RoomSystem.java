package lib;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * ระบบการใช้งานการจอง
 */
public class RoomSystem {
    
    private ArrayList<RoomTime> roomTimes = new ArrayList<>();
    private ArrayList<RoomTime> roomUser = new ArrayList<>(); 
    private ArrayList<User> user = new ArrayList<>();
    private User userLogin;
    private Room room;
    private static String date;

    public RoomSystem(){
        //timeNow();
    }
    public void timeNow(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime t = LocalDateTime.now();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                setDate(t.format(formatter1));
                System.out.println(getDate());
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    public void registerId(User userId){
        user.add(userId);
    }
    public void loginId(User userId){
        for(int i = 0 ; i<user.size();i++){
            if(userId.equals(user.get(i))){
                userLogin = userId;
                setupRoomUser();
            }
        }
    }
    public void selectRoom(Room room){
        this.room = room;
    }
    public void showRoom(){
        for(int i =0 ;i<roomTimes.size();i++){
            System.out.println(roomTimes.get(i).toString()+"\n");
        }
    }
    /**
     * Method ที่แสดงว่ามีข้อมูลห้องของผู้ใช้คนนั้นๆมีอะไรบ้าง
     */
    public void showRoomUser(){
        System.out.println("----------------------------------------------");
        for(int i =0 ;i<roomUser.size();i++){
            System.out.println(roomUser.get(i).toString());
        }
    }
    /**
     * Method ในการจัดเรียงข้อมูลห้องของผู้ใช้คนนั้นๆมารวมที่เดียว
     */
    public void setupRoomUser(){
        roomUser.clear();
        for(int i =0 ;i<roomTimes.size();i++){
            if(roomTimes.get(i).getUser().equals(userLogin)){
                roomUser.add(roomTimes.get(i));
            }
        }
    }
    /**
     * Method สำหรับการจองห้อง
     * @param room ใส่ห้องที่จะจอง
     * @param start เวลาที่เริ่มจอง
     * @param end เวลาที่จบ
     */
    public void addBookRoom(LocalTime start,LocalTime end){
        RoomTime roomTime = new RoomTime(room, userLogin, start,end);//ถ้าคลิกปุ่มแล้วจะส่งค่าRoomไปให้ทีหลัง
        roomTime.getRoom().setStatus(true);
        roomTimes.add(roomTime);
    }
    /**
     * Method สำหรับการลบข้อมูลการจอง
     * @param room ใส่ห้องที่จะจอง
     * @param start เวลาที่เริ่มจอง
     * @param end เวลาที่จบ
     */
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
    /**
     * Method ในการคำนวณว่าผู้ใช้คนนั้นๆต้องจ่ายเงินเท่าไหร่
     * @return ผลรวมทั้งหมด
     */
    public double CalculatorRoom(){
        double sum = 0;
        for(int i=0;i<roomUser.size();i++){
            sum += roomUser.get(i).getRoom().getPrice();
        }
        return sum;
    }
    public boolean checkTimeIsSame(LocalTime time){
        for (int i = 0; i < roomTimes.size(); i++) {
            if(time == roomTimes.get(i).getTimeStart() && room.equals(roomTimes.get(i).getRoom())){
                return true;
            }   
        }
        return false;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public static String getDate() {
        return date;
    }
}
