package com.pavi.springdb.rowmapper;

import com.pavi.springdb.pojo.Organization;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization>
{

    public Organization mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Organization org=new Organization();
        org.setId(resultSet.getInt("id"));
        org.setCompanyName(resultSet.getString("company_name"));
        org.setYearsOfIncorporation(resultSet.getInt("year_of_incorpration"));
        org.setPostalCode(resultSet.getString("postal_code"));
        org.setEmployeeCount(resultSet.getInt("employee_count"));
        org.setSlogan(resultSet.getString("slogan"));

        return org;


    }
}
