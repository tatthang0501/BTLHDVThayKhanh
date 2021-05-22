package hdvproject.models;


import java.util.Map;

import lombok.Data;

@Data
public class SinhVien {

    private String msv;
    
    private String username;
    private String password;

    private String ngaysinh;

    private String email;

    private String phone;

    private String ghichu;

    private String ho;

    private String dem;

    private String ten;

    Map<Integer, Map<Integer,Map<Integer, String>>> tkb;
}
