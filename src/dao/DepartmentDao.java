package dao;

import java.util.List;

import entities.Department;

public interface DepartmentDao {
    
    void insert(Department department);
    void update(Department department);
    void deleteById(Department department);
    Department findById(int id);
    List<Department> findAll();
}
