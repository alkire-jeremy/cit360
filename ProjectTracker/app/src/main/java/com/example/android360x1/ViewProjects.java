package com.example.android360x1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ViewProjects extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    public static String projects[] = {"Default"};
    String finalOutput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_projects);

        // Initialize textView variables.
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);

        // Create an ArrayList to store the views.
        ArrayList<TextView> views = new ArrayList<TextView>();
        views.add(textView1);
        views.add(textView2);
        views.add(textView3);
        views.add(textView4);
        views.add(textView5);
        views.add(textView6);
        views.add(textView7);
        views.add(textView8);

        // Create array list to store Project objects parsed from JSON string.
        ArrayList<Project> projectsArrayList = new ArrayList<Project>(projects.length);

        for (int i = 0; i < projects.length; i++) {
            try {
                projectsArrayList.add(convertToJava(projects[i]));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                textView1.setText("You haven't added any projects to the database yet. Please add a project and then return to this screen.");
                e.printStackTrace();
            }
        }

        // Change text of textViews to the project details inside the "projectsArrayList" ArrayList.
        for (int i = 0; i < projectsArrayList.size(); i++) {
            String output = "";
            // Initialize output string variable.
            output += "PROJECT NAME: " + projectsArrayList.get(i).getProjectName() + System.getProperty ("line.separator")
                    + "CLIENT NAME: " + projectsArrayList.get(i).getClientName() + System.getProperty ("line.separator")
                    + "CHARACTER NAME: " + projectsArrayList.get(i).getCharacterName() + System.getProperty ("line.separator")
                    + "ART STYLE: " + projectsArrayList.get(i).getArtStyle() + System.getProperty ("line.separator")
                    + "SPECIFICATIONS: " + projectsArrayList.get(i).getSpecifications() + System.getProperty ("line.separator")
                    + "PERSON COUNT: " + Long.toString(projectsArrayList.get(i).getPersonCount()) + System.getProperty ("line.separator")
                    + "PRICE: " + Double.toString(projectsArrayList.get(i).getPrice()) + System.getProperty ("line.separator")
                    + "STATUS: " + Long.toString(projectsArrayList.get(i).getStatus()) + System.getProperty ("line.separator");
            // Change view text to display formatted Project object information from the projectsArrayList.
            views.get(i).setText(output);
        }
    }

    public static Project convertToJava(String jsonString) throws JSONException, ParseException {

        // Create Project variable to store new Project object.
        Project project;

        // Create HashMap to store parsed JSON string.
        HashMap map = (HashMap) JSONUtilities.parse(jsonString);

        // Create Project object.
        project = new Project();

        // Configure Project object.
        project.setProjectName((String)map.get("projectName"));
        project.setClientName((String)map.get("clientName"));
        project.setCharacterName((String)map.get("characterName"));
        project.setArtStyle((String)map.get("artStyle"));
        project.setSpecifications((String)map.get("specifications"));
        project.setPersonCount((Long)map.get("personCount"));
        project.setPrice((Double)map.get("price"));
        project.setStatus((Long)map.get("status"));

        // Return Project object.
        return project;
    }
}
