package com.project.employee_management.controller;

import com.project.employee_management.dto.DepartmentDto;
import com.project.employee_management.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/departments")
@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
   @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto=departmentService.addDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id){
        DepartmentDto departmentDto=departmentService.getDepartment(id);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departments=departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,@PathVariable Long id){
        DepartmentDto updatedepartment=departmentService.updateDepartment(departmentDto,id);
        return new ResponseEntity<>(updatedepartment, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment( @PathVariable Long id){
       departmentService.deleteDepartment(id);
        return  ResponseEntity.ok("Department deleted successfully");

    }



}
