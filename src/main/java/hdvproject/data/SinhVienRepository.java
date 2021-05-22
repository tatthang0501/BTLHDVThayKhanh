package hdvproject.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hdvproject.models.SinhVien;

public interface SinhVienRepository extends CrudRepository<SinhVien, String>{
    
    @Query(value = "SELECT * FROM sinhvien WHERE msv = ?1",nativeQuery = true)
    List<SinhVien> findByMSV(String msv);
}
