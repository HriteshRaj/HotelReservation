package model;

import java.util.Date;

public class Reservation {



    Customer customer;
    IRoom room;
    Date checkIntDate;
    Date checkOutDate;
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckIntDate() {
        return checkIntDate;
    }

    public void setCheckIntDate(Date checkIntDate) {
        this.checkIntDate = checkIntDate;
    }



    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer=customer;
        this.room=room;
        this.checkIntDate=checkInDate;
        this.checkOutDate=checkOutDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
