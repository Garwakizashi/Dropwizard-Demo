package com.example.dropwizard.gar;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SampleConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    /***
     * These properties are mapped to the YAML file
     * Similarly, a property of 'server' will look for server
     */
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}