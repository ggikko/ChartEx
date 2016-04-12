package ggikko.me.chartex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {

    @Bind(R.id.pie_chart) PieChart pie_chart;

    private int[] color = {Color.rgb(3, 45, 87), Color.rgb(2,91,154),Color.rgb(0,103,69),Color.rgb(219,164,0),Color.rgb(195,123,12)};
    private String[] label = {"A  36%", "B  14%", "C  15%", "D  15%", "E  1%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        ButterKnife.bind(this);

        /** pie chart setting */
        pie_chart.setNoDataText("데이터가 필요합니다.");
        pie_chart.setNoDataTextDescription("데이터 필요합니다.");
        pie_chart.setUsePercentValues(true);
        pie_chart.setDescription("");
        pie_chart.setDragDecelerationFrictionCoef(0.7f);

        pie_chart.setDrawHoleEnabled(true);
        pie_chart.setHoleColor(Color.WHITE);
        pie_chart.setTransparentCircleColor(Color.WHITE);
        pie_chart.setExtraOffsets(0, 0, 0, 0);
        pie_chart.setTransparentCircleAlpha(0);
        pie_chart.setDrawCenterText(false);
        pie_chart.setRotationEnabled(false);
        pie_chart.setHighlightPerTapEnabled(false);


        /** chart animate */
        pie_chart.animateX(1400);

        /** chart refresh */
//        pie_chart.invalidate();

        /** y value */
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry(36f, 0));
        yVals1.add(new Entry(14f, 1));
        yVals1.add(new Entry(15f, 2));
        yVals1.add(new Entry(34f, 3));
        yVals1.add(new Entry(1f, 4));

        /** x value */
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("A");
        xVals.add("B");
        xVals.add("C");
        xVals.add("D");
        xVals.add("E");

        PieDataSet dataSet = new PieDataSet(yVals1, "Pf chart");

        /** chart color */
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(color[0]);
        colors.add(color[1]);
        colors.add(color[2]);
        colors.add(color[3]);
        colors.add(color[4]);
        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);

        /** input data and refresh */
        pie_chart.setData(data);
//        pie_chart.invalidate();

        /** legend */
        Legend l = pie_chart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        l.setTextSize(11);
        l.setCustom(color, label);
//        l.setXEntrySpace(0f);
        l.setYEntrySpace(10f);
        l.setYOffset(120);

        pie_chart.invalidate();

    }
}
