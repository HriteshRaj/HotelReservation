package model;

public class Room implements  IRoom{

    String roomNumber;
    Double price;
    RoomType roomType;


    @Override
    public String getRoomNumber() {
        return "";
    }

    @Override
    public Double getRoomPrice() {
        return 0.0;
    }

    @Override
    public RoomType getRoomType() {
        return null;
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
}
