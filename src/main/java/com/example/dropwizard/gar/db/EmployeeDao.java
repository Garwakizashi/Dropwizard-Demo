package com.example.dropwizard.gar.db;

import java.util.List;

import com.example.dropwizard.gar.api.Employee;
import com.example.dropwizard.gar.services.EmployeeDaoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(EmployeeDaoMapper.class)
/**
 * Dao = Data Access Object
 * **/
public interface EmployeeDao {

    @SqlQuery
    /**
     * @SqlQuery looks for sql file named the same as the method
     * */
    List<Employee> getEmployees();

    @SqlQuery
    /**
     * @Bind binds the string parameter  within the sql file variables (:var) as the passed argument
     * **/
    Employee getEmployee(@Bind("id")int id);
}