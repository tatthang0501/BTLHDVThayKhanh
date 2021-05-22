package hdvproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sinhvienlichhoc")
public class SinhVienLichHoc {
    @Id
    @Column(name="id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="msv")
    private SinhVien sv;

    @ManyToOne
    @JoinColumn(name="lichhocid")
    private LichHoc lh;
}
