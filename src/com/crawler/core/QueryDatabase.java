package com.crawler.core;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class QueryDatabase {

    public static ArrayList<Tour> Query(String SearchWord, String database) throws UnknownHostException {
        MongoClient mongoClient = MongoUtils.getMongoClient();

        DB db = mongoClient.getDB(MyConstants.DB_NAME);

        DBCollection datviet = db.getCollection(database);

        ArrayList<Tour> tours = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        BasicDBObject x = new BasicDBObject();

        x.put("name", new BasicDBObject("$regex", SearchWord).append("$options", "i"));

        System.out.println(x.toString());

        DBCursor cursor = datviet.find(x);
        while (cursor.hasNext()) {
            BasicDBObject obj = (BasicDBObject) cursor.next();
            String name = obj.getString("name");
            String price = obj.getString("price");
            String link = obj.getString("link");
            tours.add(new Tour(name,price,link));
        }

        mongoClient.close();
        return tours;
    }

//    public static ArrayList<Tour> Saigon(String SearchWord, String place) throws UnknownHostException {
//        MongoClient mongoClient = MongoUtils.getMongoClient();
//
//        DB db = mongoClient.getDB(MyConstants.DB_NAME);
//
//        DBCollection saigon = db.getCollection(place);
//
//        ArrayList<Tour> tours = new ArrayList<>();
//        ArrayList<String> strings = new ArrayList<>();
//
//        BasicDBObject x = new BasicDBObject();
//
//        x.put("name", new BasicDBObject("$regex", SearchWord).append("$options", "i"));
//
//        System.out.println(x.toString());
//
//        DBCursor cursor = saigon.find(x);
//        while (cursor.hasNext()) {
//            BasicDBObject obj = (BasicDBObject) cursor.next();
//            String name = obj.getString("name");
//            String price = obj.getString("price");
//            String link = obj.getString("link");
//            tours.add(new Tour(name,price,link));
//        }
//
//        mongoClient.close();
//        return tours;
//    }
//
//    public static ArrayList<Tour> Kimlien(String SearchWord) throws UnknownHostException {
//        MongoClient mongoClient = MongoUtils.getMongoClient();
//
//        DB db = mongoClient.getDB(MyConstants.DB_NAME);
//
//        DBCollection kimlien = db.getCollection("KimLien");
//
//        ArrayList<Tour> tours = new ArrayList<>();
//        ArrayList<String> strings = new ArrayList<>();
//
//        BasicDBObject x = new BasicDBObject();
//
//        x.put("name", new BasicDBObject("$regex", SearchWord).append("$options", "i"));
//
//        System.out.println(x.toString());
//
//        DBCursor cursor = kimlien.find(x);
//        while (cursor.hasNext()) {
//            BasicDBObject obj = (BasicDBObject) cursor.next();
//            String name = obj.getString("name");
//            String price = obj.getString("price");
//            String link = obj.getString("link");
//            tours.add(new Tour(name,price,link));
//        }
//
//        mongoClient.close();
//        return tours;
//    }
}