package com.example.http_client;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView output;
    Button getButton, postButton;
    EditText requestBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise elements
        output = findViewById(R.id.output);
        getButton = findViewById(R.id.getButton);
        postButton = findViewById(R.id.postButton);
        requestBody = findViewById(R.id.requestBody);

        // make GET request
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get the ID parameter
                String id = requestBody.getText().toString().trim();
                if (id.length() > 0) {

                    // define the endpoint for GET requests
                    String endpoint = "https://jsonplaceholder.typicode.com/posts/" + id;
                    Request request = new Request.Builder()
                            .url(endpoint)
                            .build();

                    // initialise the HTTP client
                    OkHttpClient client = new OkHttpClient();

                    // make an asynchronous GET request
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, IOException e) {

                            // print exception on failure
                            e.printStackTrace();
                        }

                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                            final String responseString = Objects.requireNonNull(response.body()).string();

                            // read the JSON response
                            try {
                                JSONObject jsonResponse = new JSONObject(responseString);

                                // indent response before displaying in the output text view
                                output.setText(jsonResponse.toString(4));
                            } catch (JSONException e) {

                                // print server response with status code on error
                                output.setText("HTTP Error: " + response.code());
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Oops! That didn't work :/", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // make POST request
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get the body for the POST request
                String jsonRequest = requestBody.getText().toString().trim();
                if (jsonRequest.length() > 0) {

                    // define the endpoint for GET requests
                    String endpoint = "https://jsonplaceholder.typicode.com/posts/";

                    System.out.println(jsonRequest);

                    // parse the JSON request
                    RequestBody body = RequestBody.create(
                            MediaType.parse("application/json"), jsonRequest);

                    // create the request object
                    Request request = new Request.Builder()
                            .url(endpoint)
                            .post(body)
                            .build();

                    // initialise the HTTP client
                    OkHttpClient client = new OkHttpClient();

                    // make an asynchronous GET request
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, IOException e) {

                            // print exception on failure
                            e.printStackTrace();
                        }

                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                            final String responseString = Objects.requireNonNull(response.body()).string();

                            // read the JSON response
                            try {
                                JSONObject jsonResponse = new JSONObject(responseString);

                                // indent response before displaying in the output text view
                                output.setText(jsonResponse.toString(4));
                            } catch (JSONException e) {

                                // print server response with status code on error
                                output.setText("HTTP Error: " + response.code());
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Oops! That didn't work :/", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}