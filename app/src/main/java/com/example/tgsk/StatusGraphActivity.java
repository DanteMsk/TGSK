package com.example.tgsk;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tgsk.Graph.GraphContainer;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.LinkedList;


public class StatusGraphActivity extends AppCompatActivity {

    TextView cell_00, cell_01, cell_02, cell_10, cell_11,
            cell_12, cell_20, cell_21, cell_22;

    LinkedList<TextView> listTextView;
    int[] arrayCellValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_graph);


        cell_00 = findViewById(R.id.cell_00);
        cell_01 = findViewById(R.id.cell_01);
        cell_02 = findViewById(R.id.cell_02);
        cell_10 = findViewById(R.id.cell_10);
        cell_11 = findViewById(R.id.cell_11);
        cell_12 = findViewById(R.id.cell_12);
        cell_20 = findViewById(R.id.cell_20);
        cell_21 = findViewById(R.id.cell_21);
        cell_22 = findViewById(R.id.cell_22);

        listTextView = new LinkedList<>();

        listTextView.add(cell_00);
        listTextView.add(cell_01);
        listTextView.add(cell_02);
        listTextView.add(cell_10);
        listTextView.add(cell_11);
        listTextView.add(cell_12);
        listTextView.add(cell_20);
        listTextView.add(cell_21);
        listTextView.add(cell_22);
        GraphContainer graphModel = new GraphContainer(22, 14, 24,
                2, 31,
                13, 1,
                28, 2);
        initializationCell(initializationArray(graphModel));
        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = dataPointValues();
        graph.addSeries(series);

        ValueDependentColor<DataPoint> colorDataPoint = new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint currentDataPoint) {

                switch ((int) currentDataPoint.getX()) {
                    case 0:
                        return Color.rgb(231, 217, 255);
                    case 1:
                        return Color.rgb(214, 182, 255);
                    case 2:
                        return Color.rgb(172, 117, 255);
                    case 3:
                        return Color.rgb(163, 194, 255);
                    case 4:
                        return Color.rgb(97, 166, 248);
                    case 5:
                        return Color.rgb(29, 116, 255);
                    case 6:
                        return Color.rgb(182, 255, 186);
                    case 7:
                        return Color.rgb(181, 255, 236);
                    case 8:
                        return Color.rgb(3, 247, 255);
                }
                return Color.rgb((int) currentDataPoint.getX() * 255 / 4, (int) Math.abs(currentDataPoint.getY() * 255 / 6), 100); // default color
            }
        };

        series.setValueDependentColor(colorDataPoint);
        series.setSpacing(30);
        series.setAnimated(true);
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLACK);
    }


    public void initializationCell(int[] array) {
        int i = 0;
        for (TextView valueCell : listTextView) {
            CharSequence textViewValue = String.valueOf(array[i]);
            valueCell.setText(textViewValue);
            i++;
        }
    }

    public int[] initializationArray(GraphContainer graph) {
        return arrayCellValue = new int[]{
                graph.getApplicationRejected(),
                graph.getDeferredConsideration(),
                graph.getDonorApproved(),
                graph.getDonorSearch(),
                graph.getHlaTyping(),
                graph.getHrHlaTyping(),
                graph.getNewStatement(),
                graph.getNewStatementMis(),
                graph.getNewStatementMisCGM()};
    }

    public BarGraphSeries<DataPoint> dataPointValues() {

        int countPoints = arrayCellValue.length;
        DataPoint[] dataPoints = new DataPoint[countPoints];

        for (int i = 0; i < countPoints; i++) {
            dataPoints[i] = new DataPoint(i, arrayCellValue[i]);
        }
        return new BarGraphSeries<>(dataPoints);
    }

}