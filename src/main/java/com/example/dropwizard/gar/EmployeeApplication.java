package com.example.dropwizard.gar;

import com.example.dropwizard.gar.db.EmployeeDao;
import com.example.dropwizard.gar.services.DepartmentResource;
import com.example.dropwizard.gar.services.EmployeeResource;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class EmployeeApplication extends Application<SampleConfiguration> {

    public static void main(String[] args) throws Exception{
        new EmployeeApplication().run(args);
    }

    @Override
    public void run(SampleConfiguration configuration, Environment environment) throws Exception {
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "employee-db");
        EmployeeDao dao = jdbi.onDemand(EmployeeDao.class);
        environment.jersey().register(new DepartmentResource());
        environment.jersey().register(new EmployeeResource(dao));
    }
}
