package MangaCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CrawlHandler {

    private static ArrayList<ImgChap> listImg = new ArrayList<>();
    private static ArrayList<Chap> listChap = new ArrayList<>();

    //lấy ra danh sách truyện
    public static void getChapList() throws IOException {

        Document document = null;

        try {
            document = Jsoup.connect("https://kimetsu-noyaiba.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Elements elements = document.getElementsByClass("widget ceo_latest_comics_widget").get(0).child(1).getElementsByTag("li");

        for (int i = 0; i < elements.size()-1; i++) {
            Chap chap = new Chap();
            chap.setChapName(CrawlHandler.getChapName(elements.get(i).child(0).getElementsByTag("a").attr("href")));
            chap.setChapUrl(elements.get(i).child(0).getElementsByTag("a").attr("href"));
            listChap.add(chap);
        }

        for (Chap chap:listChap) {
            System.out.println(chap.getChapName()+": "+chap.getChapUrl());
        }
    }

    //tạo kết nối
    public static Document setConnection(String url) {
        Document doc = null;
        {
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

    //lấy url ảnh rùi lưu vào 1 list
    public static void getImgChap(Document document) {
        Elements elements = document.getElementsByClass("entry-content").get(0).getElementsByTag("img");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < elements.size()-1; i++) {
            ImgChap imgChap = new ImgChap();
            imgChap.setUrlImg(elements.get(i).attr("src"));
//            if (imgChap.getUrlImg().substring(0,5)!="https") continue;

            if (listImg.get(i).getUrlImg().contains("data")) {
                continue;
            }

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("image "+imgChap.getUrlImg());
            listImg.add(imgChap);
        }
    }

    //lưu trang truyện
    public static void saveImgChap(ArrayList<ImgChap> listImg, String urlChapName) throws IOException {

        for (int i = 0; i < listImg.size()-1; i++) {
            URL url=new URL(listImg.get(i).getUrlImg());
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream("D:/Programming/TestDataCrawl/Kimetsu-no-Yaiba/"+getChapName(urlChapName)+"/"+(i+1)+".jpg");

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        }
    }

    //tạo folder lưu truyện
    public static void folderCreat(String urlChapName) throws IOException {

        Path dir = Paths.get("D:/Programming/TestDataCrawl/Kimetsu-no-Yaiba/"+getChapName(urlChapName));
        Files.createDirectories(dir);

    }

    //lấy ra tên chương
    public static String getChapName(String url) {
        int index = 0;
        for (int i = 0; i < url.length()-1; i++) {
            if(url.charAt(i) == 'c' & url.charAt(i+1) == 'h' & url.charAt(i+2) == 'a' & url.charAt(i+3) == 'p' & url.charAt(i+4) == 't' & url.charAt(i+5) == 'e' & url.charAt(i+6) == 'r'){
                index = i;
                break;
            };
        }
        return url.substring(index,url.length()-1);
    }

    //in ra url các ảnh lấy được
    public static void printUrlImg() throws IOException {

        getChapList();

        for (int i = 0; i < listChap.size()-1; i++) {
            if (i==0||i==1) continue;
            System.out.println("\nBắt đầu tải chương " + listChap.get(i).getChapName() + ": " + listChap.get(i).getChapUrl());
            folderCreat(listChap.get(i).getChapUrl());
            try {
                getImgChap(setConnection(listChap.get(i).getChapUrl()));
            } catch (Exception e) {
                System.out.println(e);
            }
            saveImgChap(listImg, listChap.get(i).getChapUrl());
        }

        for (int i = 0; i < listImg.size()-1; i++) {
            System.out.printf("Image %d: %s\n",i+1,listImg.get(i).getUrlImg());
        }
        System.out.println("Đã tải xong");
    }
}
