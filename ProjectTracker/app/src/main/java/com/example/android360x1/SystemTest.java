package com.example.android360x1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.ParseException;

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

import static com.example.android360x1.ViewProjects.convertToJava;

public class SystemTest extends AppCompatActivity {

    // Message to send to the Servlet.
    String message;
    // Array to store parsed version of servlet response.
    static String responseArray[] = {"Test1", "Test2", "Test3", "Test4", "Test5", "Test6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_test);

        // Initialize textView variables.
        TextView testTextView1 = (TextView) findViewById(R.id.testTextView1);
        TextView testTextView2 = (TextView) findViewById(R.id.testTextView2);
        TextView testTextView3 = (TextView) findViewById(R.id.testTextView3);
        TextView testTextView4 = (TextView) findViewById(R.id.testTextView4);
        TextView testTextView5 = (TextView) findViewById(R.id.testTextView5);
        TextView testTextView6 = (TextView) findViewById(R.id.testTextView6);

        testTextView1.setText(responseArray[0]);

        // Create an ArrayList to store the views.
        ArrayList<TextView> views = new ArrayList<TextView>();
        views.add(testTextView1);
        views.add(testTextView2);
        views.add(testTextView3);
        views.add(testTextView4);
        views.add(testTextView5);
        views.add(testTextView6);

        // Change text of textViews to match the content of each element in the responseArray[].
        for (int i = 1; i < responseArray.length; i++) {
            String output = "";
            // Initialize output string variable.
            output += responseArray[i] + System.getProperty ("line.separator");
            // Set view text to output variable.
            views.get(i).setText(output);
        }
    }

    public static String[] getResponseArray() {
        return SystemTest.responseArray;
    }

    public static void setResponseArray(String[] responseArray) {
        SystemTest.responseArray = responseArray;
    }
}
