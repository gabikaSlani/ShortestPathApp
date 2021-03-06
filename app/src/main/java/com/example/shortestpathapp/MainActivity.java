package com.example.shortestpathapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shortestpathapp.graph.Graph;

public class MainActivity extends AppCompatActivity {

    private EditText startNode, endNode;
    private TextView resultPath;
    private Button findPathBtn;
    private CanvasForGraph canvas;

    private Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        graph = MainActivityController.generateGraph1();
        setContentView(R.layout.activity_main);
        startNode = findViewById(R.id.startNode);
        endNode = findViewById(R.id.endNode);
        resultPath = findViewById(R.id.resultPathText);
        findPathBtn = findViewById(R.id.findPathBtn);

        findPathBtn.setOnClickListener(e -> findPath() );
    }

    public Graph getGraph() {
        return graph;
    }

    private void findPath() {
        String path = MainActivityController.findShortestPath(
                graph,
                startNode.getText().toString(),
                endNode.getText().toString());
        resultPath.setText(path);
    }
}
