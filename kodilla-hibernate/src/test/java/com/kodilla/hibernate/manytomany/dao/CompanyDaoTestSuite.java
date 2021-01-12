package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testEmployeeRetrieveByLastname() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        List<Employee> results1 = employeeDao.retrieveByLastname("Kovalsky");
        List<Employee> results2 = employeeDao.retrieveByLastname("Nowack");

        //Then
        try {
            assertEquals(1, results1.size());
            assertEquals(0, results2.size());

        } finally {
            //Cleanup
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
        }
    }

    @Test
    void testCompanyRetrieveByNameBegin() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company softwareMasters = new Company("Software Masters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(softwareMasters);
        int softwareMastersId = softwareMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        List<Company> result1 = companyDao.retrieveByNameBegin("SofXXXXX");
        List<Company> result2 = companyDao.retrieveByNameBegin("GreXXXX");
        List<Company> result3 = companyDao.retrieveByNameBegin("AbC");

        //Then
        try {
            assertEquals(2, result1.size());
            assertEquals(1, result2.size());
            assertEquals(0, result3.size());

        } finally {
            //Cleanup
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(softwareMastersId);
            companyDao.deleteById(greyMatterId);
        }
    }
}