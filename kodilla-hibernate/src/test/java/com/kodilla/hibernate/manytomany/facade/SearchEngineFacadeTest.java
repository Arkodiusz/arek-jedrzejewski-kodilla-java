package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class SearchEngineFacadeTest {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @Test
    void testSearchingForEmployees() {
        //Given
        Employee johnParkinson = new Employee("John", "Parkinson");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee hanaKovalsky = new Employee("Hana", "Kovalsky");

        //When
        employeeDao.save(johnParkinson);
        int johnParkinsonId = johnParkinson.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(hanaKovalsky);
        int hanaKovalskyId = hanaKovalsky.getId();

        List<Employee> result1 = searchEngineFacade.getEmployeeByNameFragment("son");
        List<Employee> result2 = searchEngineFacade.getEmployeeByNameFragment("an");

        //Then
        try {
            assertEquals(2, result1.size());
            assertEquals(2, result2.size());

        } finally {
            //Cleanup
            employeeDao.deleteById(johnParkinsonId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(hanaKovalskyId);
        }

    }

    @Test
    void testSearchingForCompanies() {

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

        List<Company> result1 = searchEngineFacade.getCompanyByNameFragment("Soft");
        List<Company> result2 = searchEngineFacade.getCompanyByNameFragment("Ma");

        //Then
        try {
            assertEquals(2, result1.size());
            assertEquals(3, result2.size());

        } finally {
            //Cleanup
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(softwareMastersId);
            companyDao.deleteById(greyMatterId);
        }
    }

    @Test
    void whenCompanyNotFoundExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(SearchEngineException.class, () -> searchEngineFacade.getCompanyByNameFragment("XXX"));

        String expectedMessage = SearchEngineException.ERR_COMPANY_NOT_FOUND;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenEmployeeNotFoundExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(SearchEngineException.class, () -> searchEngineFacade.getEmployeeByNameFragment("XXX"));

        String expectedMessage = SearchEngineException.ERR_EMPLOYEE_NOT_FOUND;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}