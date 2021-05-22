package hdvproject.data;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hdvproject.models.GiangVienKhoa;

public interface GiangVienKhoaRepository extends CrudRepository<GiangVienKhoa, Integer>{
    @Modifying
    @Transactional
    @Query(value = "DELETE from giangvienkhoa WHERE id = ?1", nativeQuery = true)
    public void deleteById(int id);
}
