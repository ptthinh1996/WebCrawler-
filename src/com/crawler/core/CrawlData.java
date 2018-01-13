package com.crawler.core;

import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CrawlData {
    private HashSet<String> links;
    private List<List<String>> articles;

    public CrawlData() {
        links = new HashSet<String>();
        articles = new ArrayList<List<String>>();
    }

    public void getPageLinksDatViet(String URL, String link) {
        if (!links.contains(URL)) {
            try {
                Document document = Jsoup.connect(URL).get();
                Elements otherLinks = document.select("a[href^=\"" + link + "\"]");
                for (Element page : otherLinks) {
                    if (links.add(URL)) {
                        System.out.println(URL);
                    }
                    getPageLinksDatViet(page.attr("abs:href"), link);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
    public void getArticlesDatViet(String place) throws UnknownHostException {
        MongoClient mongoClient = MongoUtils.getMongoClient();
        DB db = mongoClient.getDB(MyConstants.DB_NAME);
        DBCollection datviet = db.getCollection(place);
        BasicDBObject cleandb = new BasicDBObject();
        datviet.remove(cleandb);

        links.forEach(a -> {
            Document doc;
            try {
                doc = Jsoup.connect(a).get();
                Elements ahref = doc.getElementsByTag("a");
                for (Element href : ahref) {
                    String link = href.absUrl("href");
                    String c = href.className();
                    if (link.contains("tour-du-lich") == true && c.equals("more-detail1") == true) {
                        Element x = href.select("div.name1.clearfix > div.name2 > h3 > b").first();
                        Element y = href.select("div.name1.clearfix > div.price-list.clearfix > cite").first();
                        System.out.println(x.text() + "\nGia: " + y.text() + "\nLink: " + link + "\n----------");
                        String name = x.text();
                        String price = y.text();
                        BasicDBObject newdoc = new BasicDBObject("name", name).
                                append("price", price).
                                append("link", link);
                        datviet.insert(newdoc);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
    }


    public void getPageLinksSaigonBac(String URL) {
        if (!links.contains(URL)) {
            try {
                links.add("https://www.saigontourist.net/vi/tour/tour-ha-noi");
                links.add("https://www.saigontourist.net/vi/tour/tour-ha-noi?limit=20&page=2");
                links.add("https://www.saigontourist.net/vi/tour/tour-sapa");
                links.add("https://www.saigontourist.net/vi/tour/tour-ha-long");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
    public void getPageLinksSaigonTrung(String URL) {
        if (!links.contains(URL)) {
            try {
                links.add("https://www.saigontourist.net/vi/tour/tour-phan-thiet");
                links.add("https://www.saigontourist.net/vi/tour/tour-phan-rang");
                links.add("https://www.saigontourist.net/vi/tour/tour-my-son");
                links.add("https://www.saigontourist.net/vi/tour/tour-hue?limit=20&page=2");
                links.add("https://www.saigontourist.net/vi/tour/tour-hue");
                links.add("https://www.saigontourist.net/vi/tour/du-lich-quy-nhon");
                links.add("https://www.saigontourist.net/vi/tour/tour-da-nang?limit=20&page=2");
                links.add("https://www.saigontourist.net/vi/tour/tour-da-nang");
                links.add("https://www.saigontourist.net/vi/tour/tour-tay-nguyen");
                links.add("https://www.saigontourist.net/vi/tour/tour-da-lat");
                links.add("https://www.saigontourist.net/vi/tour/tour-nha-trang");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
    public void getPageLinksSaigonNam(String URL) {
        if (!links.contains(URL)) {
            try {
                links.add("https://www.saigontourist.net/vi/tour/tour-ho-chi-minh");
                links.add("https://www.saigontourist.net/vi/tour/tour-con-dao");
                links.add("https://www.saigontourist.net/vi/tour/du-lich-mien-tay");
                links.add("https://www.saigontourist.net/vi/tour/tour-phu-quoc");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
    public void getArticlesSaigon(String place) throws UnknownHostException {
        MongoClient mongoClient = MongoUtils.getMongoClient();
        DB db = mongoClient.getDB(MyConstants.DB_NAME);
        DBCollection saigon = db.getCollection(place);
        BasicDBObject cleandb = new BasicDBObject();
        saigon.remove(cleandb);

        for (String url : links) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements tours = doc.select("div.media.packagesList");
                for (Element tour : tours) {
                    Element x = tour.select(">div.media-body >div.bodyLeft >h4 >a").first();
                    Element y = tour.select("div.bookingDetails >h2").first();
                    if (y != null) {
                        String name = x.text();
                        String price = y.text();
                        String link = x.absUrl("href");
                        BasicDBObject newdoc = new BasicDBObject("name", name).
                                append("price", price).
                                append("link", link);
                        saigon.insert(newdoc);
                        System.out.println(name + "\nGia: " + price + "\nLink: " + link + "\n----------------------");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getPageLinksKimLien(String URL) {
        if (!links.contains(URL)) {
            try {
                Document document = Jsoup.connect(URL).get();
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1.html");
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1p2.html");
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1p3.html");
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1p4.html");
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1p5.html");
                links.add("http://kimlientourist.com.vn/du-lich-trong-nuoc-d1p6.html");

                System.out.println();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }

    public void getArticlesKimLien() throws UnknownHostException {
        MongoClient mongoClient = MongoUtils.getMongoClient();
        DB db = mongoClient.getDB(MyConstants.DB_NAME);
        DBCollection kimlien = db.getCollection("KimLien");
        BasicDBObject cleandb = new BasicDBObject();
        kimlien.remove(cleandb);

        links.forEach(a -> {
            try {
                Document doc = Jsoup.connect(a).get();
                Elements tours = doc.select("div.sanpham_cell");
                for (Element tour : tours) {
                    Element x = tour.select(">h2 >a").first();
                    Element y = tour.select(">div.sanpham_gia_dathang >div.giavnd_cot >span").first();
                    if (y != null) {
                        String name = x.text();
                        String price = y.text();
                        String link = x.absUrl("href");
                        System.out.println(x.text() + "\nGía: " + price + "\nLink: " + x.absUrl("href") + "\n------------");
                        BasicDBObject newdoc = new BasicDBObject("name", name).
                                append("price", price).
                                append("link", link);
                        kimlien.insert(newdoc);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

