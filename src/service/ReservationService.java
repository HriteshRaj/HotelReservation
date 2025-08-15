package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.sql.SQLOutput;
import java.util.*;

public class ReservationService {

    ArrayList<Reservation> storeReservation = new ArrayList<>();


   private final HashMap<String,IRoom> rooms = new HashMap<>();


    private static final ReservationService instance = new ReservationService();
    private final String id = UUID.randomUUID().toString();
    private ReservationService(){
        System.out.println("reservation id in constructpr" +id);
    }

    public static ReservationService getInstance(){
        System.out.println("reservation id in constructpr" +instance.id);
        return instance;
    }



    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
        System.out.println("Added room: " + room.getRoomNumber());
        System.out.println("Current rooms in system: " + rooms.keySet());

    }

    public IRoom getARoom(String roomId){
        System.out.println("Looking for room number: '" + roomId + "'");
        System.out.println("Available rooms: " + rooms.keySet());
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
