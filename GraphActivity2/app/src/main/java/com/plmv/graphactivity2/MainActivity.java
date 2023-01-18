package com.plmv.graphactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BarChart barChart;
    private PieChart pieChart;

    private String [] days = new String[] {"12","13","14","15","16","17","18"};
    private int[] incomes =new int[]{123,140,150,120,132,180,90};
    private int [] costs=new int[]{80,90,78,56,87,90,64};
    private int[]colors=new int[]{Color.RED, Color.BLUE, Color.YELLOW, Color.BLACK, Color.LTGRAY,Color.GREEN,Color.MAGENTA};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart= (BarChart) findViewById(R.id.barchart);
        pieChart= (PieChart) findViewById(R.id.piechart);
        createCharts ();

    }

    private Chart getSameChart (Chart chart, String description, int textColor, int background, int animateY){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        return chart;
    }

    private void legend (Chart chart) {
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE); //default cuadrado
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[1];
            entry.label = days[i];
            entries.add(entry);

        }
        legend.setCustom(entries);
    }
    private ArrayList<BarEntry> getBarEntries (){
        ArrayList<BarEntry>entries=new ArrayList<>();
        for (int i = 0; i < incomes.length; i++) {
            entries.add(new BarEntry(i, incomes[i]));
            entries.add(new BarEntry(i, costs[i]));
        }
        return entries;
    }

    private ArrayList<PieEntry> getPieEntries (){
        ArrayList<PieEntry>entries=new ArrayList<>();
        for (int i = 0; i < incomes.length; i++) {
            entries.add(new PieEntry(incomes[i]));
        }
        return entries;
    }

    private void axisX (XAxis axis) {
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(days));
    }

    private void axisLeft (YAxis axis) {
        axis.setSpaceTop(250);
        axis.setAxisMinimum(0);
    }

    private void axisRight (YAxis axis) {
        axis.setEnabled(false);
    }

    public void createCharts (){
        barChart = (BarChart) getSameChart(barChart, "Incomes and Costs", Color.RED, Color.CYAN, 3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(false);
        barChart.setData(getBarData());
        barChart.invalidate();

        axisX((barChart.getXAxis()));
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());

        pieChart=(PieChart) getSameChart(pieChart,"incomes", Color.GRAY, Color.MAGENTA, 3000);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(12);
        //pieChart.setDrawHoleEnabled(true);
        pieChart.setData(getPieData());
        pieChart.invalidate();

    }

    private DataSet getData (DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10f);

        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet) getData(new BarDataSet(getBarEntries(), ""));

        barDataSet.setBarShadowColor(Color.GRAY);

        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.4f);
        return barData;
    }

    private PieData getPieData(){
        PieDataSet pieDataSet=(PieDataSet) getData(new PieDataSet(getPieEntries(), ""));

        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());
        return new PieData (pieDataSet);
    }
}