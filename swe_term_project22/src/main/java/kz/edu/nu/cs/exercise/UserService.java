package kz.edu.nu.cs.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/user")
public class UserService {
	private List<UserInfo> users;
    public UserService() {
    	users = new ArrayList<UserInfo>();
    	users.add(new UserInfo("Guest", "123", 'G'));  
    	users.add(new UserInfo("Desk", "123", 'D'));
    	users.add(new UserInfo("Manager", "123", 'M'));
    }

    @GET
    public Response handle(@QueryParam("method") String method) {
    	Gson gson = new Gson();
        String json;
    	
        if (method.equals("getUsers")) {
        	json = gson.toJson(users);
        	return Response.ok(json).build();
        }
        json = gson.toJson(users);
    	return Response.ok(json).build();
    }
    
   
}
