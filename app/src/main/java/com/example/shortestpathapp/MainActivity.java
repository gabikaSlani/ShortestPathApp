package com.example.shortestpathapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shortestpathapp.graph.Graph;
import com.example.shortestpathapp.graph.Node;
import com.example.shortestpathapp.graph.Path;

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
        canvas = findViewById(R.id.canvas);

        findPathBtn.setOnClickListener(e -> findPath());
    }

    public Graph getGraph() {
        return graph;
    }

    private boolean invalidGivenNodesNames() {
        return (graph.getNode(startNode.getText().toString()) == null ||
                graph.getNode(endNode.getText().toString()) == null);
    }

    private void findPath() {
        if (invalidGivenNodesNames()) {
            resultPath.setText("Invalid nodes given");
        } else {
            Path path = MainActivityController.findShortestPath(
                    graph,
                    startNode.getText().toString(),
                    endNode.getText().toString());
            if (path.isEmpty()) {
                resultPath.setText("Path does not exist.");
            }
            else {
                resultPath.setText(path.toString());
                canvas.showPath(path);
                canvas.invalidate();
            }
            graph.clearNodes();
        }
    }
}
