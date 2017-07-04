package com.example.jurvistan.webviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText addressBar = (EditText)findViewById(R.id.addressBar);
        Button button = (Button)findViewById(R.id.goBtn);
        final WebView webView = (WebView)findViewById(R.id.webView);

        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        };

        webView.setWebViewClient(webViewClient);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = addressBar.getText().toString();
                if (!input.startsWith("http://")) {
                    input = String.format("http://%s", input);
                }
                webView.loadUrl(input);
            }
        });
    }
}
