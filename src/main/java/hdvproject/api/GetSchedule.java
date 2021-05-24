package hdvproject.api;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import hdvproject.models.SinhVien;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class GetSchedule {

    @GetMapping(value = "/xemtkbtheotuan/{msv}/{tuan}", produces = "application/json")
    public ResponseEntity<?> getScheduleByWeek(@PathVariable String msv, @PathVariable int tuan,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String msvFind = msv.trim();
        msvFind = msvFind.toUpperCase();
        File file = new ClassPathResource("json/SinhVienJSON.json").getFile();
        List<SinhVien> list = Arrays.asList(objectMapper.readValue(file, SinhVien[].class));
        System.out.println(list.size());
        SinhVien tempSV = list.get(0);
        for (SinhVien sv : list) {
            if (msvFind.equals(sv.getMsv())) {
                tempSV = sv;
                break;
            }
        }

        return new ResponseEntity<>(tempSV.getTkb().get(tuan), HttpStatus.OK);
    }

    @GetMapping(value = "/xemtkb/{msv}", produces = "application/json")
    public ResponseEntity<?> getInstanceSchedule(@PathVariable String msv, HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        // File file = new ClassPathResource("/json/SinhVienJSON.json").getFile();
        // System.out.println(file.getPath());

        String msvFind = msv.trim();
        msvFind = msvFind.toUpperCase();
        File f = new File("./target/classes/json/SinhVienJSON.json");
        List<SinhVien> list = Arrays.asList(objectMapper.readValue(f, SinhVien[].class));
        SinhVien tempSV = list.get(0);
        for (SinhVien sv : list) {
            if (msvFind.equals(sv.getMsv())) {
                tempSV = sv;
                break;
            }
        }

        return new ResponseEntity<>(tempSV.getTkb().get(15), HttpStatus.OK);
    }
}
