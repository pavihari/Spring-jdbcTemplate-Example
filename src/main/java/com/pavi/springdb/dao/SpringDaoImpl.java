package com.pavi.springdb.dao;

import com.pavi.springdb.pojo.Organization;
import com.pavi.springdb.rowmapper.OrganizationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("orgDao")
public class SpringDaoImpl implements SpringDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate=new JdbcTemplate(ds);
    }

    public boolean Create(Organization org) {
        String sqlQuery="INSERT INTO ORGANIZATION(company_name,year_of_incorpration,postal_code,employee_count,slogan) VALUES(?,?,?,?,?)";
        Object[] args=new Object[]{org.getCompanyName(),org.getYearsOfIncorporation(),org.getPostalCode(),org.getEmployeeCount(),org.getSlogan()};
        return jdbcTemplate.update(sqlQuery,args)==1;

    }

    public Organization getOrganization(int id) {

        String sqlQuery= "SELECT * FROM ORGANIZATION WHERE id=?";
        Object[] args= new Object[]{id};
        Organization organization=jdbcTemplate.queryForObject(sqlQuery,args,new OrganizationRowMapper());
 return organization;

    }

    public List<Organization> getAllOrganization() {
       String sqlQuery="SELECT * FROM ORGANIZATION";
       List<Organization> organizationList= jdbcTemplate.query(sqlQuery,new OrganizationRowMapper());
       return  organizationList;
    }

    public boolean deleteOrganization(Organization organization)
    {
        String sqlQuery="DELETE FROM ORGANIZATION WHERE ID=?";
        Object[] args= new Object[]{organization.getId()};
        return jdbcTemplate.update(sqlQuery,args)==1;
    }

    public boolean updateOrganization(Organization organization) {

        String sqlQuery="UPDATE ORGANIZATION SET SLOGAN = ? WHERE ID=?";
        Object[] args=new Object[]{organization.getSlogan(),organization.getId()};
        return jdbcTemplate.update(sqlQuery,args)==1;


    }

    public void cleanUp() {
String sqlQuery="TRUNCATE TABLE ORGANIZATION";
jdbcTemplate.execute(sqlQuery);
    }
}
