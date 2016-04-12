package ggikko.me.chartex;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {

    @Bind(R.id.pie_chart) PieChart pie_chart;
    @Bind(R.id.line_chart) LineChart line_chart;

    @BindColor(R.color.black) int black;

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


        /** line chart setting */
        line_chart.setTouchEnabled(false);
        line_chart.setDragEnabled(false);
        line_chart.setScaleEnabled(false);
        line_chart.setPinchZoom(false);
        line_chart.dispatchSetActivated(false);
        line_chart.setDrawGridBackground(false);
        line_chart.setGridBackgroundColor(Color.WHITE);
        line_chart.setDescriptionTextSize(10);
        line_chart.setBorderWidth(0);
        line_chart.setBorderColor(Color.BLUE);
        line_chart.setDescription("");

        XAxis xAxis = line_chart.getXAxis();
        xAxis.setDrawLabels(false);
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.disableGridDashedLine();
        xAxis.removeAllLimitLines();
        xAxis.setDrawLabels(false);

        YAxis leftAxis = line_chart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaxValue(1036);
        leftAxis.setAxisMinValue(849);
        //leftAxis.setYOffset(20f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLabels(false);
        leftAxis.setAxisLineColor(Color.WHITE);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(false);
        line_chart.getAxisRight().setEnabled(false);
        line_chart.setDescription("");
        line_chart.setDescriptionTextSize(0);
        line_chart.setBackgroundColor(Color.WHITE);

        ArrayList<String> xVals2 = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            xVals2.add((i) + "");
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
        yVals2.add(new Entry(965, 0));
        yVals2.add(new Entry(965, 1));
        yVals2.add(new Entry(932, 2));
        yVals2.add(new Entry(965, 3));
        yVals2.add(new Entry(899, 4));
        yVals2.add(new Entry(977, 5));
        yVals2.add(new Entry(977, 6));
        yVals2.add(new Entry(916, 7));
        yVals2.add(new Entry(961, 8));
        yVals2.add(new Entry(951, 9));
        yVals2.add(new Entry(986, 10));
        yVals2.add(new Entry(986, 11));

        LineDataSet set = new LineDataSet(yVals2, "abcde");
        set.setColor(Color.WHITE);

        set.setDrawValues(true);
        set.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                int value1 = (int)value;
                return value1+"";
            }
        });
//        set.enableDashedLine(10f, 5f, 0f);
//        set.enableDashedHighlightLine(10f, 5f, 0f);
        set.setColor(Color.BLACK);
        set.setCircleColor(Color.BLACK);
        set.setLineWidth(1f);

        set.setCircleRadius(4f);
        set.setDrawCircleHole(false);
        set.setValueTextSize(13f);
        set.setDrawFilled(false);
        set.disableDashedLine();

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set);

        LineData data2 = new LineData(xVals2, dataSets);

        line_chart.setData(data2);
        line_chart.setDrawGridBackground(false);

        line_chart.getXAxis().setDrawGridLines(false);
        line_chart.getAxisLeft().setDrawGridLines(false);
        line_chart.getXAxis().setDrawLabels(false);
        line_chart.getAxisLeft().setDrawLabels(false);
        Legend legend = line_chart.getLegend();
        legend.setEnabled(false);

        line_chart.invalidate();
    }
}
