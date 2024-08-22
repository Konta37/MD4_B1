package konta.repository;

import konta.model.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<NhanVien,Integer> {
}
