package kz.edu.nu.cs.exercise;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/services")
public class MyPagingApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    
    public MyPagingApplication() {
        singletons.add(new ClerkService());
        singletons.add(new GuestService());
        singletons.add(new ManagerService());
        singletons.add(new UserService());
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
