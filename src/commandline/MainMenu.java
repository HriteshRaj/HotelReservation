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
                    System.out.println("check in date yyyy-mm-dd ");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    format.setLenient(false);
                    Date checkInDate=null;
                    Date checkOutDate=null;
                    while(checkInDate==null) {
                        System.out.println("enter check in date yyyy-MM-dd");
                        String checkIn = sc.next();
                        try {
                            checkInDate = format.parse(checkIn);
                        } catch (ParseException e) {
                            System.out.println("invalid format. correct formet  = 2025-08-17");
                        }
                    }

                        while (checkOutDate == null) {

                            System.out.println("enter checkout date yyyy-MM-dd");
                            String checkOut = sc.next();

                            try {

                                checkOutDate = format.parse(checkOut);
                            } catch (ParseException e) {
                                System.out.println("invalid format. correct formet  = 2025-08-18");

                            }
                        }
                    if (!checkOutDate.after(checkInDate)) {
                        System.out.println(" Check-out date must be after check-in date.");
                        break;
                    }



                    Collection<IRoom> availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

                    if (availableRooms.size() == 0) {

                        System.out.println("not available. searching +7 days later wait.....");

                        Date checkInafter7days = new Date(checkInDate.getTime() + 7L * 24 * 60 * 60 * 1000);
                        Date checkOutAfter7days = new Date(checkOutDate.getTime() + 7L * 24 * 60 * 60 * 1000);

                        Collection<IRoom> otherRoom = hotelResource.findARoom(checkInafter7days, checkOutAfter7days);

                        if (otherRoom.size() == 0) {
                            System.out.println("sorry.....no room even after +7 days...");
                            break;
                        } else {

                            System.out.println("room available after 7 days");

                            for (IRoom room : otherRoom) {
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
                                System.out.println(roomNum + " check room if null or not");
                                if (roomBook == null) {
                                    System.out.println("null room ");
                                    adminResource.getAllRooms().forEach(r -> System.out.println(r.getRoomNumber()));
                                    break;
                                }
                                hotelResource.bookARoom(email, roomBook, checkInafter7days, checkOutAfter7days);
                                System.out.println("room book success");


                            }
                        }
                    }else{
                        for(IRoom room:availableRooms){
                            System.out.println(room);
                        }
                        System.out.println("press 1 to book a room");
                        int input = sc.nextInt();
                        if(input==1){

                            String email;
                            while(true){
                                System.out.println("email");

                               email= sc.next();

                                if(hotelResource.getCustomer(email)!=null){
                                    break;
                                }else{
                                    System.out.println("customer data not found");
                                }

                            }

                            System.out.println("room number");
                            String roomNumber = sc.next();

                            IRoom roomBook = hotelResource.getRoom(roomNumber);
                            if(roomBook==null){
                                System.out.println("invalid room");
                                break;
                            }
                            hotelResource.bookARoom(email,roomBook,checkInDate,checkOutDate);
                            System.out.println("room book success");
                        }
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

                    String emailAccount;
                    while(true) {
                        System.out.println("email : format should be name@domain.com");
                        emailAccount = sc.next();

                        System.out.println("first name ");

                        String fn = sc.next();

                        System.out.println("last name ");

                        String ln = sc.next();
                        try {
                            hotelResource.createACustomer(emailAccount, fn, ln);
                            System.out.println("account created success");
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("please try again");
                        }
                    }
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
