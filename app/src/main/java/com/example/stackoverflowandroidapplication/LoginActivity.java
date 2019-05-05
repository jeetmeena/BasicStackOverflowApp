package com.example.stackoverflowandroidapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 import android.view.View;
 import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private final String clientId = "14929";
    //client_secret:Bakwcs63AJoNoJSsYKw*0w((
    //key :KPGtGxBfWwU)nNVHxYpoFA((
    private final String apiKey = "Bakwcs63AJoNoJSsYKw*0w((";
    private final String key="KPGtGxBfWwU)nNVHxYpoFA((";
    private final String redirectUri = "https://stackexchange.com/oauth/login_success";
    public static final String API_BASE_URL = "https://stackexchange.com/oauth/dialog";
    private static Logger logger =Logger.getLogger("c*.m*.LoginAct*");
    private static final int REQUEST_ACTION = 1;
     public static String EXTRA_ACTION_TOKEN_URL = "TokenUrl";
    private WebView browser;
    private ProgressBar progressBar;
    private ProgressDialog mProgressDialog;
    final String url= API_BASE_URL +"?client_id=" + clientId +"&scope=write_access"+"&redirect_uri=" + redirectUri+"";
    private Button loginButton;
    static LoginActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Hide ActionBar
        activity=this;

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        browser = (WebView) findViewById(R.id.webview);
     loginButton=   findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.setVisibility(View.VISIBLE);
              loginButton.setVisibility(View.INVISIBLE);
            }
        });

        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                logger.info("Auth URL: " + url);
                if (url.contains("#access_token")) {
                    return true;
                }
                return false;
            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here

                logger.info("Loaded URL: " + url);
                if (url.contains("#access_token")) {



                    String token_str = url;
                     String[] str = token_str.split("access_token=");
                     String token = str[1].substring(0, str[1].length() - 14);
                    Toast.makeText(LoginActivity.this, ""+token, Toast.LENGTH_SHORT).show();
                    //Calling method to get UserId
                    StackUserRepo stackUserRepos = null;


                    finishActitv(token);
                    //Intent intent = new Intent();
                    //intent.putExtra(EXTRA_ACTION_TOKEN_URL, url);
                    //setResult(Activity.RESULT_OK, intent);
                    //WebViewActivity.this.finish();
                    //overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_left);
                }


        }
        });
        browser.loadUrl(url);
    }
    private void finishActitv(String UserId){
        QuestionListActivity questionListActivity=QuestionListActivity.getQuestionListActivity();
        questionListActivity.saveToPerferences("OpenAppFirstTime","True");
        questionListActivity.saveToPerferences("userId",UserId);

        //Toast.makeText(LoginActivity.this, ""+UserId, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, UserInterestActivty.class);
        startActivity(i);
        finish();
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
