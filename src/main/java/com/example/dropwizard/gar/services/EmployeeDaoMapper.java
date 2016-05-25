package com.example.dropwizard.gar.services;


import com.example.dropwizard.gar.api.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoMapper implements ResultSetMapper<Employee> {

    /**
     * The Dao mapper will map mysql results to the object Employee's properties.
     * This is like a quick hydration of objects without the need of hibernate.
     *
     * @param index
     * @param r result set from the database
     * @param ctx
     * @return
     * @throws SQLException
     */
    public Employee map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Employee employee = new Employee();
        employee.emp_no = r.getInt("emp_no");
        employee.first_name = r.getString("first_name");
        employee.last_name = r.getString("last_name");
        employee.birth_date = r.getString("birth_date");
        employee.gender = r.getString("gender");
        employee.hire_date = r.getString("hire_date");
        return employee;
    }
}
