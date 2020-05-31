package com.example.tgsk.RequestLogic;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SentRequest extends AsyncTask<String, Void, String> {

    private Context context;
    private int responseCode;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String[] params) {
        String responseFromServer = null;
        try {
            String url = params[0];
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept-Language", "en-US,en,q=0.5");
            connection.connect();
            String urlParameters = params[1] + "=" + params[2];
            // Request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
            writer.write(urlParameters);
            writer.close();
            wr.close();
            // Response
            responseCode = connection.getResponseCode();
            InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = reader.readLine()) != null){
                response.append(inputLine);
            }
            inputStream.close();
            reader.close();
            responseFromServer = response.toString();
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return responseFromServer;
    }

    @Override
    protected void onPostExecute(String message) {
        Gson gson = new Gson();
        Type type = new TypeToken<String>(){}.getType();
        //String str = gson.fromJson(message,type);
       // Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    public int getResponseCode() {
        return responseCode;
    }
}
