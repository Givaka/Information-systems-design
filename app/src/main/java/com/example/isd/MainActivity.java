package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String contentLink      = "https://stackoverflow.com/";

        TextView contentView    = findViewById(R.id.content);
        WebView webView         = findViewById(R.id.webView);
        Button btnFetch         = findViewById(R.id.downloadBtn);

        webView.getSettings().setJavaScriptEnabled(true);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentView.setText("\"Загрузка...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String content = getContent(contentLink);
                            webView.post(new Runnable() {
                                @Override
                                public void run() {
                                    webView.loadDataWithBaseURL(contentLink, content, "text/html", "UTF-8", contentLink);
                                    Toast.makeText(getApplicationContext(), "Данные загружены", Toast.LENGTH_SHORT).show();
                                }
                            });
                            contentView.post(new Runnable() {
                                @Override
                                public void run() {
                                    contentView.setText(content);
                                }
                            });
                        }
                        catch (IOException ex){
                            contentView.post(new Runnable() {
                                @Override
                                public void run() {
                                    contentView.setText("Ошибка: " + ex.getMessage());
                                    Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    private  String getContent (String path) throws IOException{
        BufferedReader reader           = null;
        InputStream stream              = null;
        HttpsURLConnection connection   = null;
        try {
            URL url = new URL(path);

            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();

            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder buf = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null){
                buf.append(line).append("\n");
            }
            return buf.toString();
        }
        finally {
            if (reader != null)     reader.close();
            if (stream != null)     stream.close();
            if (connection != null) connection.disconnect();
        }
    }
}