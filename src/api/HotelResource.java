package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class HotelResource {


    private final CustomerService customerService = CustomerService.getInstance();


    private final ReservationService reservationService= ReservationService.getInstance();

    private  HotelResource(){

    }
    private final static  HotelResource instance = new HotelResource();
    public  static HotelResource getInstance(){
        return instance;
    }


    public Customer getCustomer(String email){


    return  customerService.getCustomer(email);


    }
    public void createACustomer(String email,String firstName,String lastName){


        customerService.addCustomer(email,firstName,lastName);



    }
    public IRoom getRoom(String roomNumber){



    return reservationService.getARoom(roomNumber);



    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = customerService.getCustomer(customerEmail);


        if(customer==null){

            System.out.println("data not found");


        }

        return reservationService.reserveARoom(customer,room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomersReservations(String customerEmail){


    Customer customer = customerService.getCustomer(customerEmail);

    if(customer==null){

        System.out.println("data not found");

    }
    return reservationService.getCustomersReservation(customer);


    }
    public Collection<IRoom> findARoom(Date checkIn,Date checkOut){
        Collection<IRoom> availableRoom = reservationService.findRooms(checkIn,checkOut);

        if(availableRoom.size()!=0){
            return  availableRoom;
        }
        if(availableRoom.size()==0){
            System.out.println("apology for room not available");
        }

        long  days= 7L * 24 * 60 * 60 *1000;
        Date newCheckIn = new Date(checkIn.getTime() + days);
        Date newCheckOut = new Date(checkOut.getTime() + days);


        Collection<IRoom> otherRoom = reservationService.findRooms(newCheckIn,newCheckOut);

        if(otherRoom.size()!=0){
            return otherRoom;
        }else{
            System.out.println(" sorry try after 7 days");
        }



        return  availableRoom;
    }









}
