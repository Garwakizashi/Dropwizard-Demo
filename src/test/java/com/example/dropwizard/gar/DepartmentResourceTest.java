package com.example.dropwizard.gar;

import com.example.dropwizard.gar.api.Employee;
import com.example.dropwizard.gar.db.EmployeeDao;
import com.example.dropwizard.gar.services.DepartmentResource;
import com.example.dropwizard.gar.services.EmployeeResource;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentResourceTest {

    @Test
    /**
     * TODO: Some trouble unit testing this... can refactor method more.
     */
    public void testGetDepartmentList() throws SQLException{
        HashMap<String, String> dept = new HashMap<String, String>(){{
            put("123", "dept1");
            put("456", "dept2");
        }};
        List<HashMap<String, String>> departments = new ArrayList<HashMap<String, String>>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        DriverManager driverManager = mock(DriverManager.class);

        when(driverManager.getConnection("test", "test2", "test3")).thenReturn(conn);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery("SQL STATEMENT")).thenReturn(rs);

        DepartmentResource resource = new DepartmentResource();

        List<HashMap<String, String>> returnedEmployees = resource.getDepartmentList();
        assertEquals(departments, returnedEmployees);
    }
}
