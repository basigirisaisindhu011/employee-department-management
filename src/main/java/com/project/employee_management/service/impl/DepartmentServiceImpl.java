package com.project.employee_management.service.impl;

import com.project.employee_management.dto.DepartmentDto;
import com.project.employee_management.entity.Department;
import com.project.employee_management.exception.ResourceNotFoundException;
import com.project.employee_management.repository.DepartmentRepo;
import com.project.employee_management.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo departmentRepo;

    private ModelMapper modelMapper;
    public DepartmentServiceImpl(DepartmentRepo departmentRepo,ModelMapper modelMapper) {
        this.departmentRepo = departmentRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
//        Department department=new Department();
//        department.setDepartmentName(departmentDto.getDepartmentName());
//        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department department=modelMapper.map(departmentDto, Department.class);
        Department savedDepartment=departmentRepo.save(department);

//        DepartmentDto savedDepartmentDto=new DepartmentDto();
//        savedDepartmentDto.setId(savedDepartment.getId());
//        savedDepartmentDto.setDepartmentName(savedDepartment.getDepartmentName());
//        savedDepartmentDto.setDepartmentDescription(savedDepartment.getDepartmentDescription());
        DepartmentDto savedDepartmentDto=modelMapper.map(savedDepartment,DepartmentDto.class);


        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartment(Long id) {

        Department department=departmentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found with id:" + id));
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
       List<Department> departments=departmentRepo.findAll();
        return departments.stream()
                .map((department)->modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto,Long id) {
      Department department= departmentRepo.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Department not found"));
     department.setDepartmentName(departmentDto.getDepartmentName());
     department.setDepartmentDescription(departmentDto.getDepartmentDescription());
     Department updatedDepartment=departmentRepo.save(department);
        return modelMapper.map(updatedDepartment, DepartmentDto.class);
    }


    @Override
    public void deleteDepartment(Long id) {
        Department department=departmentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department not found with id:"+id));
        departmentRepo.deleteById(id);
    }
}
