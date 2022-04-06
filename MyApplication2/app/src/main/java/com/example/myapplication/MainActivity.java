package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextView mTextView;

    private Handler mHandler;

    private ProgressBar mProgressBar;
//    private ProgressBar mProgressBar2;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);
        mHandler = new Handler();
        mProgressBar =findViewById(R.id.progressBar);

        button=findViewById(R.id.button);
    }
        public void startTask(View view) {
        mTextView.setText("Loading");

        mProgressBar.setVisibility(View.VISIBLE);

        button.setVisibility(View.INVISIBLE);

//    new Thread(()->{
//        try {
//            URL url = new URL("https://gorest.co.in/public/v2/users");
//            HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
//
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            mHandler.post(() -> {
//                button.setVisibility(View.VISIBLE);
//                mProgressBar.setVisibility(View.INVISIBLE);
//                mTextView.setText(response);
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }).start();


//    ApiClients.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//        @Override
//        public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//            ArrayList<User> userList = response.body();
//            mTextView.setText("Number of Users: " + userList.size());
//            mProgressBar.setVisibility(View.INVISIBLE);
//        }
//
//        @Override
//        public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//            mTextView.setText("Error:" + t.getMessage());
//
//        }
//    });

//            ApiClients.getAPI().getUsersByID(3387).enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    User user = response.body();
//                    mTextView.setText(user.name);
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    mTextView.setText("Error:" + t.getMessage());
//                }
//            });


            User user = new User();
            user.name = "Trinh Van Quyet";
            user.email = "quyet@test.com";
            user.gender = "male";
            user.status = "Active";

            ApiClients.getAPI().addUser(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    mTextView.setText("User ID: " + user.id);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    mTextView.setText("Error:" + t.getMessage());
                }
            });



    }



}