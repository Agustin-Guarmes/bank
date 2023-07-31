package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.EmployeeRequestDTO;
import com.gyl.bank.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);
    EmployeeResponseDTO getEmployeeById(String id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO requestDTO);
    void deleteEmployee(String id);
}
