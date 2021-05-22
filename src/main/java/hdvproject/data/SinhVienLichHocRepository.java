package hdvproject.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hdvproject.models.SinhVienLichHoc;

public interface SinhVienLichHocRepository extends CrudRepository<SinhVienLichHoc, Integer>{
    @Query(value = "SELECT * FROM sinhvienlichhoc where msv = ?1", nativeQuery = true)
    List<SinhVienLichHoc> findAllBySVID(String msv);
}
