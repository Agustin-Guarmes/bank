package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.EmployeeRequestDTO;
import com.gyl.bank.dto.response.EmployeeResponseDTO;
import com.gyl.bank.entities.Employee;
import com.gyl.bank.repositories.EmployeeRepository;
import com.gyl.bank.services.interfaces.EmployeeService;
import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee employee = modelMapper.map(requestDTO, Employee.class);
        // Puedes agregar lógica adicional aquí antes de guardar el empleado en la base de datos
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con el ID: " + id));
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO requestDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con el ID: " + id));

        modelMapper.map(requestDTO, employee);

        employeeRepository.save(employee);

        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con el ID: " + id));
        employeeRepository.delete(employee);
    }
}
