package test1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MovieJSONMain2 {

  public MovieJSONMain2() throws Exception {

    JSONParser parser = new JSONParser();
    JSONObject obj = (JSONObject) parser.parse(readUrl());
    System.out.println("obj = " + obj);

    JSONObject quotesObject = (JSONObject) obj.get("quotes");
    System.out.println("quotesObject = " + quotesObject);

    for (int i = 0; i < quotesObject.size(); i++) {
      JSONArray o = (JSONArray) quotesObject.get(i);
      System.out.println("o = " + o);

    }
//    JSONObject quotes = (JSONObject) obj.get("quotes");
//    System.out.println("obj = " + obj);
    /*Set set = quotes.entrySet();
    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      String key = (String) entry.getKey();
      Double value = (Double) entry.getValue();
      System.out.println("key : value = " + key+ ":" + value);

    }*/

    /*System.out.println("quotes = " + quotes);
    value = (Double) quotes.get("USDJPY");

    System.out.println("arr = " + value);*/



    /*for (int i = 0; i <quotes.size() ; i++) {
      System.out.println("quotes = " + quotes.get(i));
    }*/


    /*for (int i = 0; i < quotes.size(); i++) {
      JSONArray array = (JSONArray) quotes.get(i);
      System.out.println("array = " + array);
    }*/




/*
    for (int i = 0; i < json.size(); i++) {
      JSONArray array = (JSONArray) json.get(i);
      JSONObject name = (JSONObject) array.get(i);
      String  jsonname = (String) name.get(i);
      System.out.println("name = " + jsonname);
      */
/*JSONObject entity = (JSONObject) array.get(i);*//*

//      String name = (String) array.get(i).to;
//      System.out.println(name);
    }
*/


  }

  private static String readUrl() throws Exception {
    BufferedInputStream reader = null;
    try {
      URL url = new URL("http://apilayer.net/api/live?access_key=07b88071071212c8e286cf29cd653547&currencies=KRW,JPY,PHP&source=USD&format=1");
      reader = new BufferedInputStream(url.openStream());
      StringBuffer buffer = new StringBuffer();
      int i;
      byte[] b = new byte[4096];
      while ((i = reader.read(b)) != -1) {
        buffer.append(new String(b, 0, i));
      }
      return buffer.toString();
    } finally {
      if (reader != null)
        reader.close();
    }
  }
}