package hdvproject.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="sinhvien")
public class SinhVien {
    @Id
    @Column(name="msv")
    private String msv;
    
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="ngaysinh")
    private String ngaysinh;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="ghichu")
    private String ghichu;
    @Column(name="ho")
    private String ho;
    @Column(name="dem")
    private String dem;
    @Column(name="ten")
    private String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "sv",cascade = CascadeType.ALL)
    private List<SinhVienLichHoc> listLichHoc;
}
