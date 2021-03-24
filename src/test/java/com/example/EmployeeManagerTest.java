package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {

    // Employee employee = new Employee("01", 2000);

    @Test
    @DisplayName("Paid Employee")
    void paidEmployee() {
        BankServiceTest bankService = new BankServiceTest();
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        // var actual = employeeManager.payEmployees();

        assertEquals(1, employeeManager.payEmployees());
        assertTrue(employeeRepository.employee.isPaid());
    }

    @Test
    @DisplayName("Not paying Employee")
    void notPayingEmployee() {
        Employee employee = Mockito.spy(new Employee("01", 2000));
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        doThrow(new RuntimeException()).when(bankService).pay("01", 2000);

        assertEquals(0, employeeManager.payEmployees());
        assertFalse(employee.isPaid());
    }


}
