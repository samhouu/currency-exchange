package main;
import java.io.*;
import org.json.*;
import okhttp3.*;

public class APIConverter {
  
  public static void main(String []args) throws IOException, JSONException{
      
  }
  
  public static String getData(String fromCurrency, String toCurrency, int amount) throws IOException, JSONException{
	    OkHttpClient client = new OkHttpClient().newBuilder().build();

	    Request request = new Request.Builder()
	      .url("https://api.apilayer.com/currency_data/convert?to=" + toCurrency + "&from=" + fromCurrency + "&amount=" + amount)
	      .addHeader("apikey", "WEVJU3g8C0UXlsWFthBuIFtrM6SN8qD9")
	      .method("GET", null)
	      .build();
	    
	    Response response = client.newCall(request).execute();
	    JSONObject jsonObject = new JSONObject(response.body().string());
	    String data = jsonObject.get("result").toString();
	    return data;
	  }
} 