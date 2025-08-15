package commandline;

import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {
    AdminResource adminResource =  AdminResource.getInstance();
    HotelResource hotelResource = HotelResource.getInstance();

    public void displayAdminMenu() {
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        while (flag == 1) {


            System.out.println("1. See all customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room ");
            System.out.println("5. Back to Main Menu");


            int adminSelect = sc.nextInt();
            switch (adminSelect) {
                case 1:
                    adminResource.getAllCustomers();
                    break;
                case 2:
                    Collection<IRoom> rooms = adminResource.getAllRooms();
                    rooms.forEach(System.out::println);

                    break;
                case 3:
                    adminResource.displayAllReservations();

                    break;

                case 4:
                    System.out.println("room number");

                    String roomNumber = sc.next().trim();

                    System.out.println("room price ");
                    double roomPrice = sc.nextDouble();

                    System.out.println("press 1 for single press 2 for double");

                    int roomType = sc.nextInt();
                    RoomType rt = (roomType == 1) ? RoomType.SINGLE : RoomType.DOUBLE;


                    Room room = new Room(roomNumber, roomPrice, rt);

                    ArrayList<IRoom> roomAdd = new ArrayList<>();
                    roomAdd.add(room);


                    adminResource.addRoom(roomAdd);


                    break;

                case 5:
                   flag=0;
                    break;


            }


        }
    }

}
