package com.glb.bootcamp.ctx.builder.hotel;

import java.util.List;

/**
 * HotelSearchCriteria is used to search for hotels based on the criteria defined.
 */
public class HotelSearchCriteria {

    private String city;

    private String checkIn;

    private String checkOut;

    private String adults;

    private String childes;

    private List<String> childAges;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChilds() {
        return childes;
    }

    public void setChilds(String childs) {
        this.childes = childs;
    }

    public List<String> getChildAges() {
        return childAges;
    }

    public void setChildAges(List<String> childAges) {
        this.childAges = childAges;
    }
}
