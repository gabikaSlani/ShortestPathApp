package com.example.shortestpathapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shortestpathapp.graph.Graph;

public class MainActivity extends AppCompatActivity {

    private EditText startNode, endNode;
    private TextView resultPath;
    private Button findPath;
    private Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = MainActivityController.generateGraph();
        startNode = findViewById(R.id.startNode);
        endNode = findViewById(R.id.endNode);
        resultPath = findViewById(R.id.resultPathText);
        findPath = findViewById(R.id.findPathBtn);

        findPath.setOnClickListener(e -> {
            String path = MainActivityController.findShortestPath(
                    graph,
                    startNode.getText().toString(),
                    endNode.getText().toString());
            resultPath.setText(path);
        });
    }
}
