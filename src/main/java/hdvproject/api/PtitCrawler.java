package hdvproject.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hdvproject.model.New;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class PtitCrawler {

    @GetMapping(value = "/tintuc/page/{pageNum}", produces = "application/json")
    public ResponseEntity<?> getNews(@PathVariable int pageNum, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        try {
            Document doc = Jsoup.connect("https://portal.ptit.edu.vn/category/tin-tuc/page/" + pageNum + "/").get();

            ArrayList<New> listNew = new ArrayList<New>();

            Elements newWrappers = doc.select(".post-item");

            for (org.jsoup.nodes.Element image : newWrappers) {
                New temp = new New();
                temp.setUrl(image.getElementsByTag("a").get(0).attributes().get("href"));
                temp.setImgUrl(image.getElementsByTag("a").get(0).child(1).attributes().get("src"));
                temp.setTitle(image.getElementsByTag("a").get(3).text());
                listNew.add(temp);
            }
            int pageCount = doc.select(".page").size();
            Map<Integer, ArrayList<New>> map = new HashMap<>();
            map.put(pageCount, listNew);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Không tìm thấy tin tức", HttpStatus.NOT_FOUND);
        }
    }
}
