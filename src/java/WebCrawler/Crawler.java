package WebCrawler;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.util.ArrayList;

public class Crawler {

    public static void main(String[] args) throws IOException {

        //ket noi toi dia chi can crawl data
        Document doc = Jsoup.connect("https://www.opentable.com/lolz-view-all/H4sIAAAAAAAAAE3NTwvCMAyH4e8Sr91okrVrehMsMhD_VD04ERGsIOykw4v43Q148RR4n8DvDQQRyBJWVirCHTaR2mgtGOB_IQ2NBuTI9ucOIhnwGtnV3gdxwSBL3TJ5Fn0ISuuUt6vldNH1KZ83-5QPCqIwmZexG2dluL_Ko1y1og4eT3p153YZnuXzBZg8khOeAAAA?originid=d3f5d734-f668-42ee-a03f-00a1ae347abf").get();

        //loc elements can crawl
        Elements elements = doc.getElementsByClass("_2qjKLPGCLPla0NryjmCazb");

        Elements elements1 = elements.get(0).child(0).getElementsByAttributeValue("data-test","restaurant-card");

        //tao mang de luu data
        ArrayList<Catering> list = new ArrayList<>();

        //duyet cac elms thu duoc
        for (int i = 0; i < elements1.size()-1; i++) {
            Catering catering = new Catering();

            catering.setReview(elements1.get(i).child(1).child(1).child(0).child(0).getElementsByTag("q").text());
            catering.setTitle(elements1.get(i).child(1).child(0).child(0).child(0).attr("aria-label"));
            catering.setUrlAva(elements1.get(i).child(1).child(0).child(0).child(0).getElementsByTag("a").attr("href"));

            list.add(catering);
        }

        System.out.println(list);
        for (int i = 0; i < list.size(); i++){
            System.out.printf("\nName: %s \nLink: %s\nReview: %s \n",list.get(i).getTitle(),list.get(i).getUrlAva(),list.get(i).getReview());
        }

    }

}