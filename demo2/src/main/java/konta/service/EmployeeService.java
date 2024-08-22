package konta.service;

import konta.model.entity.NhanVien;

import java.util.List;

public interface EmployeeService {
    List<NhanVien> getAll();
    NhanVien findById(Integer id);
    Boolean save(NhanVien employee);
    Boolean delete(Integer id);
}
