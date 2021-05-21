package hdvproject.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hdvproject.model.New;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class PtitCrawler {


    @GetMapping(value = "/tintuc", produces = "application/json")
    public ResponseEntity<?> getNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<New> listNew = new ArrayList<New>();
        Document doc = Jsoup.connect("https://portal.ptit.edu.vn/").get();
        Elements images = doc.select(".image_wrapper");
        Elements titleWrappers = doc.select(".post-title");
        System.out.println(images.size());
        
        for(int i = 0; i < images.size(); i++){
            New temp = new New();
            for (org.jsoup.nodes.Element image : images) {
                String url = image.child(0).attributes().get("href");
                String imgUrl = image.child(0).child(1).attributes().get("src");
                temp.setUrl(url);
                temp.setImgUrl(imgUrl);
            }
            for(org.jsoup.nodes.Element titWrapper : titleWrappers){
                String title = titWrapper.child(0).child(0).html();
                temp.setTitle(title);
            }
            listNew.add(temp);
        }
        return new ResponseEntity<>(listNew, HttpStatus.OK);
    }
}
