package lib;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * ระบบการใช้งานการจอง
 */
public class RoomSystem {
    private File fileRoomList = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomSystem() {
        fileRoomList = new File("./file/RoomTimes.csv");
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * Method สำหรับการจองห้อง
     * @param room  ใส่ห้องที่จะจอง
     * @param user  ใส่ข้อมูลผู้ใช้
     * @param start เวลาที่เริ่มจอง
     * @param end   เวลาที่จบ
     */
    public void addBookRoom(Room room, User user, LocalDateTime start, LocalDateTime end) {
        //ต้องเช็กด้วยว่ามีค่านั้นไหม
        try {
            fw = new FileWriter(fileRoomList, true);
            bw = new BufferedWriter(fw);
            bw.write(new RoomTime(room, user, start, end).toString() + "\n"); // เขียนไฟล์ในRoomTimes.csv
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Method สำหรับการลบข้อมูลการจอง
     * 
     * @param room  ใส่ห้องที่จะจอง
     * @param user  ใส่ข้อมูลผู้ใช้
     * @param start เวลาที่เริ่มจอง
     * @param end   เวลาที่จบ
     */
    public void removeBookRoom(Room room, User user, LocalDateTime start, LocalDateTime end) {
        try {
            String tempS;
            String tempRoomTimes = "";
            RoomTime roomCheck = new RoomTime(room, user, start, end);
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                if(!(roomCheck.toString().equals(tempS))){ 
                    tempRoomTimes += tempS+"\n";
                }
            }
            fw = new FileWriter(fileRoomList,false); //เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(tempRoomTimes);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Method ในการคำนวณว่าผู้ใช้คนนั้นๆต้องจ่ายเงินเท่าไหร่
     * 
     * @return ผลรวมทั้งหมด
     */
    public double CalculatorRoom(User user) {
        double sum = 0;
        try {
            String tempS;
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                //[0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13 [12]00 [13]00 [14]150.0
                sum = sum + Double.parseDouble(tempSplit[14]);//เลือกแค่Price
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return sum;
    }

    public boolean checkLocalDateTimeIsSame(Room room,LocalDateTime timeStart) {
        boolean tempBool = false;
        try {
            String tempS;
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                //[0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13 [12]00 [13]00 [14]150.0
                if((String.valueOf(timeStart.getHour()).equals(tempSplit[5])) && room.getIdRoom() == Integer.parseInt(tempSplit[0])){ 
                   tempBool = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return tempBool;
    }
}
