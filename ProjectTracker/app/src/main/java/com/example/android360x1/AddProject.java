package com.example.android360x1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
import java.util.ArrayList;
import java.util.List;

public class AddProject extends AppCompatActivity implements OnClickListener {

    // Submit button variable.
    Button button;
    // Connection output TextView variable.
    TextView outputText;

    // Declare EditText variables.
    EditText project_name_text;
    EditText client_name_text;
    EditText character_name_text;
    Spinner artStyleSpinner;
    EditText specifications_text;
    EditText person_count_text;
    EditText price_text;
    EditText status_text;

    // Message to send to the Servlet.
    String message;

    public static final String URL =
            "http://10.0.2.2:8080/CIT/MobileServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        findViewsById();
        button.setOnClickListener(this);

        // Initialize EditText variables.
        project_name_text = (EditText) findViewById(R.id.project_name_text);
        client_name_text = (EditText) findViewById(R.id.client_name_text);
        character_name_text = (EditText) findViewById(R.id.character_name_text);
        artStyleSpinner = (Spinner) findViewById(R.id.artStyleSpinner);
        specifications_text = (EditText) findViewById(R.id.specifications_text);
        person_count_text = (EditText) findViewById(R.id.person_count_text);
        price_text = (EditText) findViewById(R.id.price_text);
        status_text = (EditText) findViewById(R.id.status_text);

        // Spinner Drop down elements
        List<String> artStyleOptions = new ArrayList<String>();
        artStyleOptions.add("Vexy");
        artStyleOptions.add("Grunge");
        artStyleOptions.add("Comix");
        artStyleOptions.add("Ink'd");
        artStyleOptions.add("Sorrow");
        artStyleOptions.add("Chibi");
        artStyleOptions.add("Stuft");
        artStyleOptions.add("Toy'd");
        artStyleOptions.add("Le Cuteness");
        artStyleOptions.add("Chiblox");
        artStyleOptions.add("Gingi");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, artStyleOptions);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        artStyleSpinner.setAdapter(dataAdapter);
    }

    private void findViewsById() {
        button = (Button) findViewById(R.id.button);
        outputText = (TextView) findViewById(R.id.outputTxt);
    }

    public void onClick(View view) {
        try {
            message = "&" + URLEncoder.encode("project_name", "UTF-8") + "=" + URLEncoder.encode(project_name_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("client_name", "UTF-8") + "=" + URLEncoder.encode(client_name_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("character_name", "UTF-8") + "=" + URLEncoder.encode(character_name_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("art_style", "UTF-8") + "=" + URLEncoder.encode(artStyleSpinner.getSelectedItem().toString(), "UTF-8")
            + "&" + URLEncoder.encode("specifications", "UTF-8") + "=" + URLEncoder.encode(specifications_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("person_count", "UTF-8") + "=" + URLEncoder.encode(person_count_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price_text.getText().toString(), "UTF-8")
            + "&" + URLEncoder.encode("status", "UTF-8") + "=" + URLEncoder.encode(status_text.getText().toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        AddProject.ConnectToServlet connectTask = new AddProject.ConnectToServlet();
        connectTask.execute(new String[]{URL});
//        outputText.setText(connectToServlet.sendGet());

    }

    private class ConnectToServlet extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            // Create URL variable.
            java.net.URL url = null;
            try {
                // Initialize URL variable with new URL object.
                url = new URL("http://10.0.2.2:8080/CIT/MobileServlet");
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

//            // Create message to post.
////            String message = null;
//            try {
////                message = "&" + URLEncoder.encode("test", "UTF-8") + "=" + URLEncoder.encode("Hello from Android", "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }

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
            String output[] = response.toString().split("\\|");

            // Send result to ViewProjects.java
            ViewProjects.projects = output;

            // Return result
            return response.toString();
        }
    }
}
