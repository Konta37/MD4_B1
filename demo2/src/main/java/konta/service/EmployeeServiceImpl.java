package konta.service;

import konta.model.entity.NhanVien;
import konta.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<NhanVien> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public NhanVien findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(NhanVien employee) {
        try {
            this.employeeRepository.save(employee);
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
