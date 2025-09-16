package lib;

import java.time.LocalTime;

/**
 * ADI ค่าที่เปลี่ยนแปลงได้ (Mutable) ห้องคาราโอเกะ+เวลาของห้องนั้นๆ
 */
public class RoomTime {
    private final Room room;
    private final LocalTime timeStart;
    private final LocalTime timeEnd;
    private final User user;
    //Rep Invariant (RI)
    //  - room is not null
    //  - timeStart >= 00:00 && timeStart <= 24:00 && นาทีต้องเป็น 0
    //Abstract Function (AF):
    //  - RoomList(Room room, LocalTime localTime) ใส่ห้องและเวลาของห้องนั้น

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(room == null){
            throw new RuntimeException("RI violated: Room cannot be null.");
        }
    }

    /**
     * ตั้งค่าห้องคาราโอเกะ
     * @param room 
     * @param timeStart
     */
    public RoomTime(Room room,User user ,LocalTime timeStart,LocalTime timeEnd){
        this.room = room;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.user = user;
        checkRep();
    }

    /**
     * @return ห้องคาราโอเกะ
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return เวลาของห้องนั้นๆ
     */
    public LocalTime getTimeStart() {
        return timeStart;
    }
    public LocalTime getTimeEnd() {
        return timeEnd;
    }
    public User getUser() {
        return user;
    }

    @Override
    public String toString(){
        return room.getIdRoom()+"("+user.getUserId()+")"+" = "+timeStart+" - "+timeEnd;
    }


}
