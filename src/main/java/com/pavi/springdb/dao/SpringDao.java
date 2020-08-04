package com.pavi.springdb.dao;

import com.pavi.springdb.pojo.Organization;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;


public interface SpringDao {

    //== create a connection with the database
    public void setDataSource(DataSource ds);

    //== create a record in organization

    public boolean Create(Organization org);

    //== Retrieve only one value from the organization

    public Organization getOrganization(int id);

    //== Retrieve all the values from the organization table

    public List<Organization> getAllOrganization();

    //== Delete a specific Organization from the table

    public boolean deleteOrganization(Organization organization);

    //==update an existing organization

    public boolean updateOrganization(Organization organization);

    public void cleanUp();


}
