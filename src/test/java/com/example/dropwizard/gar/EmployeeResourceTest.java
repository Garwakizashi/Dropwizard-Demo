package com.example.dropwizard.gar;

import com.example.dropwizard.gar.api.Employee;
import com.example.dropwizard.gar.db.EmployeeDao;
import com.example.dropwizard.gar.services.EmployeeResource;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeResourceTest {

    @Test
    /**
     * Unit test getEmployeeList in EmployeeResource. Tests must have @Test annotation
     */
    public void testGetEmployees() {
        final Employee employee1 = new Employee() {{
            emp_no = 123;
        }};
        final Employee employee2 = new Employee() {{
            emp_no = 456;
        }};
        List<Employee> employees = new ArrayList<Employee>() {{
            add(employee1);
            add(employee2);
        }};

        //mock the dao and set specific return value when invoking specific methods
        EmployeeDao mockDao = mock(EmployeeDao.class);
        when(mockDao.getEmployees()).thenReturn(employees);
        EmployeeResource resource = new EmployeeResource(mockDao);

        List<Employee> returnedEmployees = resource.getEmployeeList();
        assertEquals(employees, returnedEmployees);
    }

    @Test
    /**
     * Unit test getEmployee in EmployeeResource.
     */
    public void testGetEmployee() {

        Employee employee = new Employee(){{
            emp_no = 123;
        }};

        EmployeeDao mockDao = mock(EmployeeDao.class);
        when(mockDao.getEmployee(123)).thenReturn(employee);
        EmployeeResource resource = new EmployeeResource(mockDao);

        Employee returnedEmployee = resource.getEmployee(123);
        assertEquals(employee, returnedEmployee);
    }

}
