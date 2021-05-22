package hdvproject.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hdvproject.data.LichHocRepository;
import hdvproject.data.SinhVienLichHocRepository;
import hdvproject.data.SinhVienRepository;
import hdvproject.models.KipHoc;

import hdvproject.models.LichHocView;
import hdvproject.models.NgayHoc;

import hdvproject.models.SinhVienLichHoc;
import hdvproject.models.TuanHoc;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class GetSchedule {

    @Autowired
    SinhVienRepository svRepo;
    @Autowired
    SinhVienLichHocRepository svlhRepo;
    @Autowired
    LichHocRepository lhRepo;


    @GetMapping(value = "/xemtkb/{msv}", produces = "application/json")
    public ResponseEntity<?> getSchedule(@PathVariable String msv, HttpServletRequest request, HttpServletResponse response) {
        ArrayList<SinhVienLichHoc> listLHSV = (ArrayList<SinhVienLichHoc>) svlhRepo.findAllBySVID(msv);
        ArrayList<LichHocView> listLHV = convert(listLHSV);

        Map<Integer, String> mapT2 = new HashMap<>();
        Map<Integer, String> mapT3 = new HashMap<>();
        Map<Integer, String> mapT4 = new HashMap<>();
        Map<Integer, String> mapT5 = new HashMap<>();
        Map<Integer, String> mapT6 = new HashMap<>();
        Map<Integer, String> mapT7 = new HashMap<>();

        Map<Integer, Map<Integer, String>> map = new HashMap<>();
            map.put(2, mapT2);
            map.put(3, mapT3);
            map.put(4, mapT4);
            map.put(5, mapT5);
            map.put(6, mapT6);
            map.put(7, mapT7);

        for(Entry<Integer, Map<Integer, String>> m : map.entrySet()){
            m.getValue().put(2, "");
            m.getValue().put(3, "");
            m.getValue().put(4, "");
            m.getValue().put(5, "");
            m.getValue().put(6, "");
            m.getValue().put(7, "");
            m.getValue().put(8, "");
        }

        for(LichHocView lhv : listLHV){
            if(lhv.getNgayHoc().equals(2)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT2.put(x, temp);
                }
            }
            if(lhv.getNgayHoc().equals(3)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT3.put(x, temp);
                }
            }
            if(lhv.getNgayHoc().equals(4)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT4.put(x, temp);
                }
            }
            if(lhv.getNgayHoc().equals(5)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT5.put(x, temp);
                }
            }
            if(lhv.getNgayHoc().equals(6)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT6.put(x, temp);
                }
            }
            if(lhv.getNgayHoc().equals(7)){
                for(Integer x : lhv.getKipHoc()){
                    String temp = lhv.getTen()+", phòng " + lhv.getPhong();
                    mapT7.put(x, temp);
                }
            }
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ArrayList<LichHocView> convert(ArrayList<SinhVienLichHoc> list){
        ArrayList<LichHocView> listLHV = new ArrayList<LichHocView>();
        for(SinhVienLichHoc l : list){
            LichHocView lhv = new LichHocView();
            lhv.setId(l.getLh().getId());
            lhv.setNhomTH(l.getLh().getNhomTH());
            lhv.setPhong(l.getLh().getPhong());
            lhv.setSoTC(l.getLh().getLhp().getMhkh().getMh().getSoTC());
            lhv.setTen(l.getLh().getTen());
            List<Integer> listKH = new ArrayList<>();
            for(KipHoc k : l.getLh().getKipHoc()){
                listKH.add(k.getTen());
            }
            List<Integer> listNH = new ArrayList<>();
            for(NgayHoc n : l.getLh().getNgayHoc()){
                listNH.add(n.getTen());
            }
            List<Integer> listTH = new ArrayList<>();
            for(TuanHoc th : l.getLh().getTuanHoc()){
                listTH.add(th.getTen());
            }
            lhv.setKipHoc(listKH);
            lhv.setTuanHoc(listTH);
            lhv.setNgayHoc(listNH.get(0));
            listLHV.add(lhv);
        }
        return listLHV;
    }
}
