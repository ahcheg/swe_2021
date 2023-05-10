package kz.edu.nu.cs.exercise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import src.main.java.management.*;
import src.main.java.hotel.users.*;
import src.main.java.hotel.*;

@Path("/manager")
public class ManagerService {
	private List<Employee> employees;
    public ManagerService() {
    	employees = new ArrayList<Employee>();
    	employees.add(new Employee(1, "Carl", 0, 1, 0));  
    	employees.add(new Employee(2, "Patricia", 0, 2, 0));
    }

    @GET
    public Response showEmployees(@QueryParam("method") String method, @QueryParam("hotelID") Integer hotelID, @QueryParam("employeeID") Integer employeeID, @QueryParam("workDays") Integer workDays, @QueryParam("payroll") Integer payroll) {
    	Gson gson = new Gson();
        String json;
		EmployeeRepo empRepo = new EmployeeRepo();
		System.out.print(method);
    	if (method.equals("editEmployee")) {
    		//String first_name, String second_name, Date date_of_birth, int salary, int hotel, String phone_number
    		//Query database by employeeID, hotelID and set new workDays and Payroll
    			Date d = new Date();
    		
    			src.main.java.hotel.users.Employee empl = new src.main.java.hotel.users.Employee(employeeID, "Sasha", "Makedonsky", d, payroll, hotelID, "88005553535");
    			Optional<src.main.java.hotel.users.Employee> empl1 = empRepo.findByEmployeeId(employeeID);
    			empl1.get().setDateOfBirth(d);
    			empl1.get().setHotel(hotelID);
    			empl1.get().setSalary(payroll);
    			empRepo.update(empl1.get(), empl1.get().getId());
    	}
        if (method.equals("addEmployee")) {
        	//Query database to add Employee by employeeID, hotelID and workDays Payroll
        	employees.add(new Employee(employeeID, 0, hotelID, workDays, payroll));
        	Date d = new Date();
    		
        	src.main.java.hotel.users.Employee empl = new src.main.java.hotel.users.Employee(employeeID, "Sasha", "Makedonsky", d, payroll, hotelID, "88005553535");
			
			empRepo.save(empl);
        }
        if (method.equals("deleteEmployee")) {
        	//Query to database by employeeID, hotelID
			Optional<src.main.java.hotel.users.Employee> empl1 = empRepo.findByEmployeeId(employeeID);
			empRepo.delete(empl1.get().getId());
        }
        
    	
		json = gson.toJson(employees);
        return Response.ok(json).build();
    }
    
   
}
