package com.example.searchengine.controller;

import java.util.List;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.example.searchengine.exception.CompanyInvalidException;
import com.example.searchengine.response.Employee;
import com.example.searchengine.response.ServiceResponse;
import com.example.searchengine.service.SearchService;
import com.example.searchengine.util.AuthoritiesConstants;

@RestController
@RequestMapping("/api")
@Slf4j
@Api(value = "/api", description = "Employee Profile", produces = "application/json")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/employees")
    @Timed
    @ApiOperation(value = "Get employee details", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee details retrieved",
                    response = Employee.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Company not found")})
    public List<Employee> getEmployeeDetails(@RequestParam String company) {
        // TODO PRI 20181120 do some validations on input parameters

        return searchService.getEmployeeDetails(company);
    }

    /**
     *
     * @param employee employee details {@link Employee}
     * @param company company name
     * @return the ServiceResponse with status 201 (Created), or with status 400 (Bad Request) if
     *         the email is already in use
     * @throws CompanyInvalidException if company name is invalid
     */
    @PostMapping("/employees")
    @Timed
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ServiceResponse<Void> onboardEmployee(@Valid @RequestBody Employee employee,
            @RequestParam String company) throws CompanyInvalidException {
        log.debug("REST request to onboard employee: {} for company {}", employee, company);

        // TODO PRI 20181120 do some validations on input parameters

        searchService.onboardEmployee(employee, company);

        ServiceResponse<Void> response = new ServiceResponse<>();
        response.setData(null);
        response.setError(null);

        return response;
    }
}
