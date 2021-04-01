package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngineFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchEngineFacade.class);
    private final SearchEngineService searchEngineService;

    @Autowired
    public SearchEngineFacade(SearchEngineService searchEngineService) {
        this.searchEngineService = searchEngineService;
    }

    public List<Company> getCompanyByNameFragment(String fragment) {
        LOGGER.info("Searching companies containing \" {} \" in name...", fragment);
        List<Company> companies = searchEngineService.retrieveCompaniesByNameFragment(fragment);

        if (companies.isEmpty()) {
            LOGGER.error(SearchEngineException.ERR_COMPANY_NOT_FOUND);
            throw new SearchEngineException(SearchEngineException.ERR_COMPANY_NOT_FOUND);
        }
        return companies;
    }

    public List<Employee> getEmployeeByNameFragment(String fragment) {
        LOGGER.info("Searching employees containing \" {} \" in firstname or lastname...", fragment);
        List<Employee> employees = searchEngineService.retrieveEmployeesByNameFragment(fragment);

        if (employees.isEmpty()) {
            LOGGER.error(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
            throw new SearchEngineException(SearchEngineException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }
}