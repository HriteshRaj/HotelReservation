package commandline;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    HotelResource hotelResource = new HotelResource();
    AdminResource adminResource = AdminResource.getInstance();


    public void mainMenu(){
        System.out.println("1.find and reserve a room");
        System.out.println("2.see my reservations");
        System.out.println("3.create an account");
        System.out.println("4. Admin");
        System.out.println("5. exit");


        Scanner sc = new Scanner(System.in);

        int i= sc.nextInt();
        int flag=0;

        switch (i){

            case 1:
                System.out.println("check in date (yyyy-mm-dd ");
                String checkIn =sc.next();
                System.out.println("check out date");
                String checkOut = sc.next();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date checkInDate;
                Date checkOutDate;
                try{
                    checkInDate = format.parse(checkIn);
                    checkOutDate= format.parse(checkOut);
                } catch (ParseException e) {
                    throw new RuntimeException(e);

                }

                Collection<IRoom>  availableRooms =  hotelResource.findARoom(checkInDate,checkOutDate);

                if(availableRooms.size()==0){

                    System.out.println("not available");
                }


                for(IRoom room: availableRooms){
                    System.out.println(room);
                }


                break;





                case 2:
            case 3:
            case 4:
                flag=1;
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.displayAdminMenu();

            break;

            case 5:
            default:
                break;
        }





















    }






}
