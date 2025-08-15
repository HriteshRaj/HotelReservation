package model;

public class Room implements  IRoom{

    String roomNumber;
    Double price;
    RoomType roomType;

    public Room() {

    }


    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return 0.0;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
       return "room number =" + roomNumber +
               "room price = "+ price
               +" room type = " + roomType;
    }

    public Room(String roomNumber, double price, RoomType roomType){
        this.roomType=roomType;
        this.price=price;
        this.roomNumber=roomNumber;

    }
}
