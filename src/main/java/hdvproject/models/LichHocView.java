package hdvproject.models;

import java.util.List;

import lombok.Data;

@Data
public class LichHocView {
    private int id;
    private String ten;
    private int nhomTH;
    private int soTC;
    private String phong;
    private Integer ngayHoc;
    private List<Integer> kipHoc;
    private List<Integer> tuanHoc;

}
