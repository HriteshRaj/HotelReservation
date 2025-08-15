package commandline;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    HotelResource hotelResource = HotelResource.getInstance();
    AdminResource adminResource = AdminResource.getInstance();



    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
        AdminMenu adminMenu = new AdminMenu();
        int flag =0;

        while(flag == 0 ) {
            System.out.println("1.find and reserve a room");
            System.out.println("2.see my reservations");
            System.out.println("3.create an account");
            System.out.println("4. Admin");
            System.out.println("5. exit");

            int i = sc.nextInt();


            switch (i) {

                case 1:
                    System.out.println("check in date (yyyy-mm-dd ");
                    String checkIn = sc.next();
                    System.out.println("check out date");
                    String checkOut = sc.next();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date checkInDate;
                    Date checkOutDate;
                    try {
                        checkInDate = format.parse(checkIn);
                        checkOutDate = format.parse(checkOut);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);

                    }


                    Collection<IRoom> availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

                    if (availableRooms.size() == 0) {

                        System.out.println("not available");
                    }


                    for (IRoom room : availableRooms) {
                        System.out.println(room);
                    }
                    System.out.println("press 1 to book other to exit");
                    int input = sc.nextInt();
                    if (input == 1) {

                        System.out.println("email");
                        String email = sc.next();

                        if (hotelResource.getCustomer(email) == null) {
                            System.out.println("not found");
                            break;
                        }
                        System.out.println("room number");
                        String roomNum = sc.next().trim();

                        IRoom roomBook = hotelResource.getRoom(roomNum);
                        System.out.println(roomNum +" check room if null or not");
                        if(roomBook==null){
                            System.out.println("null room ");
                            adminResource.getAllRooms().forEach(r -> System.out.println(r.getRoomNumber()));
                            break;
                        }
                        hotelResource.bookARoom(email, roomBook, checkInDate, checkOutDate);
                        System.out.println("done");


                    }


                    break;

                case 2:
                    System.out.println("enter email ");

                    String email = sc.next();

                    Collection<Reservation> reservations = hotelResource.getCustomersReservations(email);

                    for (Reservation res : reservations) {

                        System.out.println(res);

                    }

                    break;
                case 3:

                    System.out.println("email");

                    String emailAccount = sc.next();

                    System.out.println("first name ");

                    String fn = sc.next();

                    System.out.println("last name ");

                    String ln = sc.next();

                    hotelResource.createACustomer(emailAccount, fn, ln);

                    System.out.println("done");

                    break;
                case 4:
                    flag = 1;

                    adminMenu.displayAdminMenu();
                    flag=0;
                    break;
                case 5:
                    flag=1;
                    break;
                default:
                    System.out.println("try again");
                    break;
            }


        }










    }






}
