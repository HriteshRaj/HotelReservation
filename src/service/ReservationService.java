package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    ArrayList<Reservation> storeReservation = new ArrayList<>();


    HashMap<String,IRoom> rooms = new HashMap<>();


    private static ReservationService instance = new ReservationService();


    public static ReservationService getInstance(){

        return instance;
    }



    public void addRoom(IRoom room){
    rooms.put(room.getRoomNumber(),room);
    }

    public IRoom getARoom(String roomId){
       return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){


        Reservation res = new Reservation(customer,room,checkInDate,checkOutDate);


         storeReservation.add(res);

         return  res;

    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        Collection<IRoom> availableRooms = new ArrayList<>();

        for(IRoom room:rooms.values()){

        int flag=1;

        for(Reservation res: storeReservation){

            if(res.getRoom().getRoomNumber().equals(room.getRoomNumber())){
                flag=0;

                break;
            }

        }
        if(flag==1){

            availableRooms.add(room);
        }
    }
    return  availableRooms;




    }
    public Collection<Reservation> getCustomersReservation(Customer customer){

        Collection<Reservation> custReservations = new ArrayList<>();

        for(Reservation res: storeReservation){

            if(res.getCustomer().equals(customer)){

                custReservations.add(res);
        }
    }

        return  custReservations;
    }
    public void printAllReservation(){

        if(storeReservation.size()==0){

        System.out.println("could not find any results");
    }

    for(Reservation res:storeReservation){

        System.out.println(res);
    }

    }

    public Collection<IRoom>getAllRooms(){

        return rooms.values();
    }




}
