package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngineService {

    private final EmployeeDao employeeDao;
    private final CompanyDao companyDao;
    
    @Autowired
    public SearchEngineService(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public List<Company> retrieveCompaniesByNameFragment(String fragment) {
        return companyDao.retrieveByNameFragment(fragment);
    }

    public List<Employee> retrieveEmployeesByNameFragment(String fragment) {
        return employeeDao.retrieveByNameFragment(fragment);
    }
}
