package kz.edu.nu.cs.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/clerk")
public class ClerkService {
	private List<Reservation> reservations;
	
    public ClerkService() {
    	reservations = new ArrayList<Reservation>();
    	//Query to database to get all reservations
    }

    @GET
    public Response processBookings(@QueryParam("method") String method, @QueryParam("old_guestEmail") String old_guestEmail, @QueryParam("old_roomNumber") Integer old_roomNumber,  @QueryParam("old_floorNumber") Integer old_floorNumber, @QueryParam("old_hotelID") Integer old_hotelID, @QueryParam("old_checkInDate") String old_checkInDate, @QueryParam("old_checkOutDate") String old_checkOutDate,
    		@QueryParam("guestEmail") String guestEmail, @QueryParam("roomNumber") Integer roomNumber,  @QueryParam("floorNumber") Integer floorNumber, @QueryParam("hotelID") Integer hotelID, @QueryParam("checkInDate") String checkInDate, @QueryParam("checkOutDate") String checkOutDate) {
    	Gson gson = new Gson();
        String json;
        //Query to database to find guestID by guestEmail
		int guestID = 2;
    	
		if (method.equals("addBooking")) {
    		
    		reservations.add(new Reservation(guestEmail, guestID, hotelID, roomNumber, floorNumber, checkInDate, checkOutDate));
    		//Query to add Booking
    	}
    	if (method.equals("modifyBooking")) {
    		//Query database to find old_guestID by old_guestEmail
    		int old_guestID = 2;
        	modifyBooking(old_guestEmail, old_guestID, old_roomNumber, old_floorNumber, old_hotelID, old_checkInDate, old_checkOutDate,
        			guestEmail, guestID, roomNumber, floorNumber, hotelID, checkInDate, checkOutDate);
    	}
    	if (method.equals("cancelBooking")) {
    		cancelBooking(guestEmail, guestID, roomNumber, floorNumber, hotelID, checkInDate, checkOutDate);
    	}
        
		json = gson.toJson(reservations);
        return Response.ok(json).build();
    }
    
    void cancelBooking(String guestEmail, int guestID, int roomNumber, int floorNumber, int hotelID,  String checkInDate, String checkOutDate) {
    	//Query to database
    }
    
    void modifyBooking(String old_guestEmail, int old_guestID, int old_roomNumber, int old_floorNumber, int old_hotelID, String old_checkInDate, String old_checkOutDate,
    		String guestEmail, int guestID, int roomNumber, int floorNumber, int hotelID, String checkInDate, String checkOutDate) {
    	//Query to database
    }
    
    
}
