package main;
import java.io.*;
import java.util.Iterator;

import javax.swing.JComboBox;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import okhttp3.*;

public class APIList {
  public static void main(String []args) throws IOException, JSONException{
	  OkHttpClient client = new OkHttpClient().newBuilder().build();

	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/currency_data/list")
	      .addHeader("apikey", "B13aSsT0lq834KSegkXcTZONbQVkmLuM")
	      .method("GET", null)
	      .build();
	    Response response = client.newCall(request).execute();
	    JSONObject jsonObject = new JSONObject(response.body().string());
	    JSONObject data = jsonObject.getJSONObject("currencies");
  }
  
  //Call the method only if getting the list values
  public static void JsonGetListValue(JSONObject obj) throws JSONException {
	    Iterator<?> x = obj.keys();
	    while (x.hasNext()){
	        String key = (String) x.next();
	        System.out.println(obj.names());
	  
	    }
  }
  
  public static void JsonGetKeys(JComboBox list) throws JSONException, IOException {
	  OkHttpClient client = new OkHttpClient().newBuilder().build();

	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/currency_data/list")
	      .addHeader("apikey", "B13aSsT0lq834KSegkXcTZONbQVkmLuM")
	      .method("GET", null)
	      .build();
	    Response response = client.newCall(request).execute();
	    JSONObject jsonObject = new JSONObject(response.body().string());
	    JSONObject obj = jsonObject.getJSONObject("currencies");
	  	JSONArray arr = obj.names();
	  	
	  	for(int i = 0 ; i<arr.length(); i++) {
	        list.addItem(arr.get(i));
	  	}
  }
}