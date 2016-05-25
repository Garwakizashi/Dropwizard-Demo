package com.example.dropwizard.gar.services;

import com.example.dropwizard.gar.db.EmployeeDao;
import com.example.dropwizard.gar.api.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
/**
 * This will use dao and daomappers as example
 */
public class EmployeeResource {

    private EmployeeDao employeeDao;

    /**
     * constructor for class accepting dao
     * @param dao
     */
    public EmployeeResource(EmployeeDao dao){
        this.employeeDao = dao;
    }

    @GET
    /**
     * default endpoint for this resource class.
     * get a list of employees
     */
    public List<Employee> getEmployeeList(){
        return employeeDao.getEmployees();
    }

    @GET
    @Path("/{id}")
    /**
     * appending an integer value after the default path will go to this endpoint.
     * the @PathParam string argument basically maps the string argument of @Path as the method parameter
     */
    public Employee getEmployee(@PathParam("id") int id){
        return employeeDao.getEmployee(id);
    }
}
