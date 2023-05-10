package kz.edu.nu.cs.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import hotel.users.*;
import management.*;
@Path("/guest")
public class GuestService {
	private List<Reservation> reservations;
	private List<Room> rooms;
	private String userEmail;
	private int userID;
	
    public GuestService() {
    	reservations = new ArrayList<Reservation>();
    	
    	
    	rooms = new ArrayList<Room>();
    	rooms.add(new Room(3, 12, 1, 2, 5, "sofa", 12));
		rooms.add(new Room(4, 10, 3, 4, 9, "table", 7));
    }

    @GET
    public Response processBookings(@QueryParam("method") String method, @QueryParam("userEmail") String email, @QueryParam("roomNumber") Integer roomNumber,  @QueryParam("floorNumber") Integer floorNumber, @QueryParam("hotelID") Integer hotelID, @QueryParam("checkInDate") String checkInDate, @QueryParam("checkOutDate") String checkOutDate, @QueryParam("destination") String destination, @QueryParam("occupancy") String occupancy,
    		@QueryParam("old_roomNumber") Integer old_roomNumber,  @QueryParam("old_floorNumber") Integer old_floorNumber, @QueryParam("old_hotelID") Integer old_hotelID, @QueryParam("old_checkInDate") String old_checkInDate, @QueryParam("old_checkOutDate") String old_checkOutDate) throws ParseException {
    	Gson gson = new Gson();
        String json;
        if (checkInDate != null) {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	Date ncheckInDate = formatter.parse(checkInDate);
        }
        	
        if (method.equals("saveUser")) {
        	userEmail = email;
        	//Query database to find userID 
            userID = 2;
        	json = gson.toJson(userEmail);
    		return Response.ok(json).build();
        }
    	if (method.equals("cancelBooking")) {
    		cancelBooking(userEmail, userID, roomNumber, floorNumber, hotelID, checkInDate, checkOutDate);
    	}
    	if (method.equals("makeBooking")) {	
    		makeBooking(userEmail, userID, roomNumber, floorNumber, hotelID, checkInDate, checkOutDate);
    	}
    	if (method.equals("modifyBooking")) {	
    		modifyBooking(userEmail, userID, old_roomNumber, old_floorNumber, old_hotelID, old_checkInDate, old_checkOutDate,
    				roomNumber, floorNumber, hotelID, checkInDate, checkOutDate);
    	}
    	
    	if (method.equals("searchRooms")) {
    		// rooms -> 
    		json = gson.toJson(rooms);
    		return Response.ok(json).build();
    	}
        
		json = gson.toJson(reservations);
        return Response.ok(json).build();
    }
    
    void cancelBooking(String email, int guestID, int roomNumber, int floorNumber, int hotelID,  String checkInDate, String checkOutDate) {
    	//Query to database
    	
    	/*for (int i = 0; i < reservations.size(); i++) {
    		Reservation temp = reservations.get(i);
    		if (temp.roomNumber == roomNumber && temp.hotelID == hotelID && temp.guestID == guestID && temp.requestType == 1) {
    			reservations.remove(i);
    			break;
    		}
    	}*/
    }
    void makeBooking(String email, int guestID, int roomNumber, int floorNumber, int hotelID,  String checkInDate, String checkOutDate) {
    	Reservation temp = new Reservation(email, guestID, hotelID, roomNumber, floorNumber, checkInDate, checkOutDate);
    	reservations.add(temp);
    	management.Reservation res = new management.Reservation(); 
    	
    	
    	
    }
    void modifyBooking(String email, int guestID, int old_roomNumber, int old_floorNumber, int old_hotelID, String old_checkInDate, String old_checkOutDate,
    		int roomNumber, int floorNumber, int hotelID, String checkInDate, String checkOutDate) {
    	
    	
    	//Query to database
    }
}
