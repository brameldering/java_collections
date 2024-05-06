package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookingService {

    private Map<Room, Guest> bookings = new HashMap<>();

    public boolean book(Room room, Guest guest) {

        /*
         * 1. The provided Guest is placed in the bookings Map and
         * associated with the provided room, only if no other guest
         * is associated with the room.
         *
         * Returns a boolean that indicates if the Guest was
         * successfully placed in the room.
         */
        Guest existingGuest = bookings.putIfAbsent(room, guest);
        return (existingGuest == null);
    }

    public double totalRevenue() {

        /*
         * 2. Returns a double that totals the rate of each Room booked
         * in the bookings Map.
         */
//        Set<Map.Entry<Room, Guest>> bookingsSet = bookings.entrySet();
//        double totalRate = 0.0;
//        for (Map.Entry<Room, Guest> booking : bookingsSet) {
//            Room room = booking.getKey();
//            totalRate = totalRate + room.getRate();
//        }
        Set<Room> rooms = bookings.keySet();
        double totalRate = rooms.stream().mapToDouble(Room::getRate).sum();
        return totalRate;
    }

    public Map<Room, Guest> getBookings() {
        return bookings;
    }
}
