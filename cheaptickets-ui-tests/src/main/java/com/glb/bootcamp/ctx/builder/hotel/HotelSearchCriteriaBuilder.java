package com.glb.bootcamp.ctx.builder.hotel;

import com.glb.bootcamp.ctx.builder.Builder;

import java.util.List;

/**
 * Builds an instance of {@link HotelSearchCriteria} with desirable options to search for hotels.
 */
public final class HotelSearchCriteriaBuilder implements Builder<HotelSearchCriteria> {

    private final HotelSearchCriteria criteria = new HotelSearchCriteria();

    /**
     * Private constructor.
     */
    private HotelSearchCriteriaBuilder() {
    }

    public static HotelSearchCriteriaBuilder hotelSearchCriteriaBuilder() {
        return new HotelSearchCriteriaBuilder();
    }

    public HotelSearchCriteriaBuilder setCity(String city) {
        criteria.setCity(city);
        return this;
    }

    public HotelSearchCriteriaBuilder setCheckIn(String checkIn) {
        criteria.setCheckIn(checkIn);
        return this;
    }

    public HotelSearchCriteriaBuilder setCheckOut(String checkOut) {
        criteria.setCheckOut(checkOut);
        return this;
    }

    public HotelSearchCriteriaBuilder setAdults(String adults) {
        criteria.setAdults(adults);
        return this;
    }

    public HotelSearchCriteriaBuilder setChildes(String childes) {
        criteria.setChilds(childes);
        return this;
    }

    public HotelSearchCriteriaBuilder setChildAges(List<String> childAges) {
        criteria.setChildAges(childAges);
        return this;
    }

    @Override
    public HotelSearchCriteria build() {
        return criteria;
    }
}
