package com.example.android360x1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import com.example.android360x1.SystemTest;

public class MainActivity extends Activity implements
        OnClickListener {
    MediaPlayer player;
    // Message to send to the Servlet.
    String message;
    public static final String URL =
            "http://10.0.2.2:8080/CIT/SystemTest";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(MainActivity.this, R.raw.elvenforest_davidrenda);
        player.setLooping(true); // Set looping
        player.setVolume(1.0f, 1.0f);
        player.start();
    }

    public void clickAddProject(View view) {
        Intent intent = new Intent(this, AddProject.class);
        startActivity(intent);
    }

    public void clickViewProject(View view) {
        Intent intent = new Intent(this, ViewProjects.class);
        startActivity(intent);
    }

    public void clickTestProject(View view) {

        try {
            message = "&" + URLEncoder.encode("test_project_name", "UTF-8") + "=" + URLEncoder.encode("Test Project Name", "UTF-8")
                    + "&" + URLEncoder.encode("test_client_name", "UTF-8") + "=" + URLEncoder.encode("Test Client Name", "UTF-8")
                    + "&" + URLEncoder.encode("test_character_name", "UTF-8") + "=" + URLEncoder.encode("Test Character Name", "UTF-8")
                    + "&" + URLEncoder.encode("test_art_style", "UTF-8") + "=" + URLEncoder.encode("Test Art Style", "UTF-8")
                    + "&" + URLEncoder.encode("test_specifications", "UTF-8") + "=" + URLEncoder.encode("Test Specifications", "UTF-8")
                    + "&" + URLEncoder.encode("test_person_count", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")
                    + "&" + URLEncoder.encode("test_price", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")
                    + "&" + URLEncoder.encode("test_status", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MainActivity.ConnectToServlet connectTask = new MainActivity.ConnectToServlet();
        connectTask.execute(new String[]{URL});
        Intent intent = new Intent(this, SystemTest.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    private class ConnectToServlet extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            // Create URL variable.
            java.net.URL url = null;
            try {
                // Initialize URL variable with new URL object.
                url = new URL("http://10.0.2.2:8080/CIT/SystemTest");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            // Create connection variable.
            HttpURLConnection connection = null;
            try {
                // Initialize connection variable with new URL connection.
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Allow output in connection.
            connection.setDoOutput(true);
            try {
                // Set connection method to post.
                connection.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }

            // Create stream writer variable.
            OutputStreamWriter request = null;
            try {
                // Initialize stream writer variable with new connection output stream writer.
                request = new OutputStreamWriter(connection.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // Send message.
                request.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                request.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // RESPONSE

            // Create StringBuffer variable to store response.
            StringBuffer response = new StringBuffer();

            // Create response code variable.
            int responseCode = 0;
            try {
                // Initialize response code variable with connection response.
                responseCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Check if response is OK.
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                // Create buffered reader variable to store input stream.
                BufferedReader reader = null;
                try {
                    // If response is OK, initialize buffered reader with connection input stream.
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Create string variable.
                String inputLine = null;

                while (true) {
                    try {
                        // If response is null, exit the loop.
                        if ((inputLine = reader.readLine()) == null) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // If there is a response, append it to the response variable.
                    response.append(inputLine);
                }
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                return ("Failure.");
            }

            System.out.println("The output is: " + response.toString());

            // Parse string response into an array by the delimiter symbol.
            String responseArray[] = response.toString().split("\\|");
            SystemTest.setResponseArray(responseArray);

            // Return result
            return response.toString();
        }
    }
}

