package com.example.employeeManagement.service;

import com.example.employeeManagement.dto.EmployeeDTO;
import com.example.employeeManagement.entity.Employee;
import com.example.employeeManagement.repo.EmployeeRepo;
import com.example.employeeManagement.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EmployeeService {

    //Inject
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepo.existsById(employeeDTO.getEmpID())){
           return VarList.RSP_DUPLICATED;
        }
        else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
