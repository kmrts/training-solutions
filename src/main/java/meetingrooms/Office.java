package meetingrooms;

import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms;

    public Office(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);
//        System.out.println(meetingRooms);
//        System.out.println(meetingRoom);
    }

    public void printNames(){
        for(MeetingRoom room: meetingRooms){
            System.out.println(room.getName());
        }

    }
    public void printNamesReverse(){
        for(int i=meetingRooms.size()-1; i>=0; i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printEventNames(){
        for(int i=1; i<meetingRooms.size(); i+=2){
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printAreas(){
        for(MeetingRoom room: meetingRooms){
            System.out.println("név: "+ room.getName()+ ", szélesség: "+ room.getWidth()
            + ", hosszúság: "+ room.getLength()+ ", terület: "+ room.getArea());
        }
    }
    public void printMeetingRoomsWithName(String name){
        //System.out.println("név: "+ name);
        for(MeetingRoom room: meetingRooms){
            if(room.getName()==name){
                System.out.println("név: "+ room.getName()+ ", szélesség: "+ room.getWidth()
                        + ", hosszúság: "+ room.getLength()+ ", terület: "+ room.getArea());
            }
        }
    }
    public void printMeetingRoomsContains(String part){
        for(MeetingRoom room: meetingRooms){
            if(room.getName().indexOf(part)!=-1){
                System.out.println("név: "+ room.getName()+ ", szélesség: "+ room.getWidth()
                        + ", hosszúság: "+ room.getLength()+ ", terület: "+ room.getArea());
            }
        }
    }
    public void printAreasLargerThan(int area){
        for(MeetingRoom room: meetingRooms){
            if(room.getArea()>area){
                System.out.println("név: "+ room.getName()+ ", szélesség: "+ room.getWidth()
                        + ", hosszúság: "+ room.getLength()+ ", terület: "+ room.getArea());
            }
        }
    }
}
