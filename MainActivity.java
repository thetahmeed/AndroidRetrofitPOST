package com.tahmeedul.androidretrofitpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tahmeedul.androidretrofitpost.getpost.PostArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    RetroInterface retroInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.mTextView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retroInterface = retrofit.create(RetroInterface.class);

        createPost();

    }

    // Method 1
    /*
    private void createPost() {
        PostArray post = new PostArray(23, "New Title", "New Text");

        Call<PostArray> call = retroInterface.createPost(post);
        call.enqueue(new Callback<PostArray>() {
            @Override
            public void onResponse(Call<PostArray> call, Response<PostArray> response) {
                if (!response.isSuccessful()) {
                    mTextView.setText("Code: " + response.code());
                    return;
                }
                PostArray postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getBody() + "\n\n";
                mTextView.setText(content);
            }
            @Override
            public void onFailure(Call<PostArray> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }
    */

    // Method 2
    /*
    private void createPost() {
        Call<PostArray> call = retroInterface.createPost(25, "Bye bye 2020", "sduhf u ufbj iudhju");
        call.enqueue(new Callback<PostArray>() {
            @Override
            public void onResponse(Call<PostArray> call, Response<PostArray> response) {
                if (!response.isSuccessful()) {
                    mTextView.setText("Code: " + response.code());
                    return;
                }
                PostArray postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getBody() + "\n\n";
                mTextView.setText(content);
            }
            @Override
            public void onFailure(Call<PostArray> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }
    */

    // Method 2.1
    private void createPost() {
        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "New Title");
        fields.put("body", "New Body");

        Call<PostArray> call = retroInterface.createPost(fields);
        call.enqueue(new Callback<PostArray>() {
            @Override
            public void onResponse(Call<PostArray> call, Response<PostArray> response) {
                if (!response.isSuccessful()) {
                    mTextView.setText("Code: " + response.code());
                    return;
                }
                PostArray postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getBody() + "\n\n";
                mTextView.setText(content);
            }
            @Override
            public void onFailure(Call<PostArray> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }

}
