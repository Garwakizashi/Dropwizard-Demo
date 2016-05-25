package com.example.dropwizard.gar.services;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/department")
@Produces(MediaType.APPLICATION_JSON)
/**
 * This will use dao and daomappers as example
 */
public class DepartmentResource {

    @GET
    /**
     * default endpoint for this resource class.
     * get the list of departments
     */
    public List<HashMap<String, String>> getDepartmentList() throws SQLException{
        List<HashMap<String,String>> returnData = new ArrayList<HashMap<String,String>>();
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/employees", "test_user", "password123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees.departments");

            returnData = this.getAllDepartmentData(rs);
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return returnData;
    }


    /**
     * Return a list of departments from data ResultSet
     *
     * @param data
     * @return
     * @throws SQLException
     */
    private List<HashMap<String,String>> getAllDepartmentData(ResultSet data) throws SQLException{
        ArrayList<HashMap<String, String>> tmp = new ArrayList<HashMap<String, String>>();
        while(data.next()){
            HashMap<String, String> row = new HashMap<String, String>();
            row.put("dept_no", data.getString("dept_no"));
            row.put("dept_name", data.getString("dept_name"));
            tmp.add(row);
        }

        return tmp;
    }
}
