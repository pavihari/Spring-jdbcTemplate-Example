package com.pavi.springdb;

import com.pavi.springdb.dao.SpringDao;
import com.pavi.springdb.pojo.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTemplateDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans-cp.xml");

        //== creating a bean
        SpringDao dao=(SpringDao)applicationContext.getBean("orgDao");

      //== creating seed data
        DaoUtils.createSeedData(dao);


        //==create a new organization record

       Organization organizationList=new Organization("ge",1899,"3423",324,"imagination at work");
        boolean isCreated=dao.Create(organizationList);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation,isCreated);
        DaoUtils.printOrganizationCount(dao.getAllOrganization(),DaoUtils.createOperation);

        //== LIST ORGANIZATION
        List<Organization> orgs=dao.getAllOrganization();
        DaoUtils.printOrganizations(orgs,DaoUtils.readOperation);

        Organization org2= dao.getOrganization(1);
        DaoUtils.printOrganization(org2,"getOrganization");


        //=== UPDATE ORGANIZATION==
        Organization org3=dao.getOrganization(2);
        org3.setSlogan("fdjsjfd");
        boolean isUpdated =dao.updateOrganization(org3);
        DaoUtils.printSuccessFailure(DaoUtils.updateOperation,isUpdated);
        DaoUtils.printOrganization(dao.getOrganization(2),DaoUtils.updateOperation);

        //== DELETE OPERATION==

        boolean isDeleted=dao.deleteOrganization(dao.getOrganization(3));
        DaoUtils.printSuccessFailure(DaoUtils.deleteOperation,isDeleted);
        DaoUtils.printOrganizations(dao.getAllOrganization(),DaoUtils.deleteOperation);



//== clean up operation

        dao.cleanUp();
        DaoUtils.printOrganizationCount(dao.getAllOrganization(),DaoUtils.cleanupOperation);
















        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
