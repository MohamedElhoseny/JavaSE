package Practical_Code.JavaFX.Charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by Elhosany on 3/25/2017.
 */
public class MainClass extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane layout = new BorderPane();

        PieChart pieChart = get_PieChart();     // 100%
        AreaChart areaChart = get_AreaChart();   // 100%
        LineChart lineChart = get_LineChart();   // 100%
        BarChart barChart = get_BarChart();      //100%
        BubbleChart bubbleChart = get_BubbleChart();  //30%
        ScatterChart scatterChart = get_ScatterChart();  //100%
        StackedAreaChart stackedAreaChart = get_Stackedarea();  //99%
        StackedBarChart stackedBarChart = get_StackedBar();   //100%


        layout.setCenter(stackedBarChart);
        Scene scene = new Scene(layout,700,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static PieChart get_PieChart()
    {
        //Model Data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        pieChartData.addAll(
                new PieChart.Data("SWT",13),
                new PieChart.Data("AWT",10),
                new PieChart.Data("SWING",22),
                new PieChart.Data("JAVAFX",30)
        );

        //Create Chart
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("UI Toolkits");

        return  chart;
    }

    private static AreaChart get_AreaChart()
    {
        //Defining the X axis
        CategoryAxis xAxis = new CategoryAxis();

        //Defining the y Axis
        NumberAxis yAxis = new NumberAxis(0, 15, 2.5);
        yAxis.setLabel("Fruit units");

        //Creating the Area chart
        AreaChart<String, Number> areaChart = new AreaChart(xAxis, yAxis);

        //set title
        areaChart.setTitle("AreaChart for Fruits");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series series1 = new XYChart.Series();

        series1.setName("John");
        series1.getData().add(new XYChart.Data("Monday", 3));
        series1.getData().add(new XYChart.Data("Tuesday", 4));
        series1.getData().add(new XYChart.Data("Wednesday", 3));
        series1.getData().add(new XYChart.Data("Thursday", 5));
        series1.getData().add(new XYChart.Data("Friday", 4));
        series1.getData().add(new XYChart.Data("Saturday", 10));
        series1.getData().add(new XYChart.Data("Sunday", 12));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Jane");
        series2.getData().add(new XYChart.Data("Monday", 1));
        series2.getData().add(new XYChart.Data("Tuesday", 3));
        series2.getData().add(new XYChart.Data("Wednesday", 4));
        series2.getData().add(new XYChart.Data("Thursday", 3));
        series2.getData().add(new XYChart.Data("Friday", 3));
        series2.getData().add(new XYChart.Data("Saturday", 5));
        series2.getData().add(new XYChart.Data("Sunday", 4));

        //Setting the XYChart.Series objects to area chart
        areaChart.getData().addAll(series1,series2);

        return areaChart;
    }

    private static LineChart get_LineChart()
    {
        //Defining X axis , y axis  Types
        NumberAxis xAxis = new NumberAxis(1960, 2020, 10);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis(0, 350, 50);
        yAxis.setLabel("No.of schools");


        //prepare series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("A1");
        series1.getData().add(new XYChart.Data(1970, 15));
        series1.getData().add(new XYChart.Data(1980, 30));
        series1.getData().add(new XYChart.Data(1990, 60));
        series1.getData().add(new XYChart.Data(2000, 120));
        series1.getData().add(new XYChart.Data(2013, 240));
        series1.getData().add(new XYChart.Data(2014, 300));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("A2");
        series2.getData().add(new XYChart.Data(1970, 10));
        series2.getData().add(new XYChart.Data(1980, 18));
        series2.getData().add(new XYChart.Data(1990, 50));
        series2.getData().add(new XYChart.Data(2000, 70));
        series2.getData().add(new XYChart.Data(2013, 300));
        series2.getData().add(new XYChart.Data(2014, 126));

        //create and assign Data
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.getData().addAll(series1,series2);

        return lineChart;
    }

    private static BarChart get_BarChart()
    {
    //Defining the x axis
    CategoryAxis xAxis = new CategoryAxis();

    xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(
            "Speed", "User rating", "Milage", "Safety")));
    xAxis.setLabel("category");

    //Defining the y axis
    NumberAxis yAxis = new NumberAxis(); //without specifying parameters, it will specify it according inputs
    yAxis.setLabel("score");

    //Prepare XYChart.Series objects by setting data
    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    series1.setName("Fiat");
    series1.getData().add(new XYChart.Data<>("Speed", 1.0));
    series1.getData().add(new XYChart.Data<>("User rating", 3.0));
    series1.getData().add(new XYChart.Data<>("Milage", 5.0));
    series1.getData().add(new XYChart.Data<>("Safety", 5.0));

    XYChart.Series<String, Number> series2 = new XYChart.Series<>();
    series2.setName("Audi");
    series2.getData().add(new XYChart.Data<>("Speed", 5.0));
    series2.getData().add(new XYChart.Data<>("User rating", 6.0));

    series2.getData().add(new XYChart.Data<>("Milage", 10.0));
    series2.getData().add(new XYChart.Data<>("Safety", 4.0));

    XYChart.Series<String, Number> series3 = new XYChart.Series<>();
    series3.setName("Ford");
    series3.getData().add(new XYChart.Data<>("Speed", 4.0));
    series3.getData().add(new XYChart.Data<>("User rating", 2.0));
    series3.getData().add(new XYChart.Data<>("Milage", 3.0));
    series3.getData().add(new XYChart.Data<>("Safety", 6.0));


    //Creating the Bar chart
    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    barChart.setTitle("Comparison between various cars");

    //Setting the data to bar chart
    barChart.getData().addAll(series1, series2, series3);

    return barChart;
}

    private static BubbleChart get_BubbleChart()
    {
        //Defining X axis , y axis  Types
        NumberAxis xAxis = new NumberAxis(0, 100, 10);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis(20, 100, 10);
        yAxis.setLabel("No.of schools");


        //prepare series
        XYChart.Series series = new XYChart.Series();
        series.setName("work");

        series.getData().add(new XYChart.Data(10,30,4));
        series.getData().add(new XYChart.Data(25,40,5));
        series.getData().add(new XYChart.Data(40,50,9));
        series.getData().add(new XYChart.Data(55,60,7));
        series.getData().add(new XYChart.Data(70,70,9));
        series.getData().add(new XYChart.Data(85,80,6));

        //create and assign Data
        BubbleChart bubbleChart = new BubbleChart(xAxis,yAxis);
        bubbleChart.getData().add(series);

        return bubbleChart;
    }

    private static ScatterChart get_ScatterChart()
    {
        //Defining X axis , y axis  Types
        NumberAxis xAxis = new NumberAxis(0, 100, 10);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("No.of schools");


        //prepare series
        XYChart.Series series = new XYChart.Series();
        series.setName("positive");
        series.getData().add(new XYChart.Data(10,30,4));
        series.getData().add(new XYChart.Data(72,12,5));
        series.getData().add(new XYChart.Data(22,50,9));
        series.getData().add(new XYChart.Data(40,15,7));
        series.getData().add(new XYChart.Data(44,30,9));
        series.getData().add(new XYChart.Data(85,80,6));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("negative");

        series2.getData().add(new XYChart.Data(10,30,4));
        series2.getData().add(new XYChart.Data(25,40,5));
        series2.getData().add(new XYChart.Data(40,50,9));
        series2.getData().add(new XYChart.Data(55,60,7));
        series2.getData().add(new XYChart.Data(70,70,9));
        series2.getData().add(new XYChart.Data(85,80,6));

        //create and assign Data
        ScatterChart scatterChart = new ScatterChart(xAxis,yAxis);
        scatterChart.getData().addAll(series,series2);

        return scatterChart;
    }

    private static StackedAreaChart get_Stackedarea()
    {
        //Defining the X axis
        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList
                (Arrays.asList("1 750", "1800", "1850", "1900", "1950", "1999", "2050" )));

         //Defining the Y axis
        NumberAxis yAxis = new NumberAxis(0, 10000, 2500);
        yAxis.setLabel("Population in Billions");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Asia");
        series1.getData().add(new XYChart.Data("1750", 502));
        series1.getData().add(new XYChart.Data("1800", 635));
        series1.getData().add(new XYChart.Data("1850", 809));
        series1.getData().add(new XYChart.Data("1900", 947));
        series1.getData().add(new XYChart.Data("1950", 1402));
        series1.getData().add(new XYChart.Data("1999", 3634));
        series1.getData().add(new XYChart.Data("2050", 5268));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Africa");
        series2.getData().add(new XYChart.Data("1750", 106));
        series2.getData().add(new XYChart.Data("1800", 107));
        series2.getData().add(new XYChart.Data("1850", 111));
        series2.getData().add(new XYChart.Data("1900", 133));
        series2.getData().add(new XYChart.Data("1950", 221));
        series2.getData().add(new XYChart.Data("1999", 767));
        series2.getData().add(new XYChart.Data("2050", 1766));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Europe");
        series3.getData().add(new XYChart.Data("1750", 163));
        series3.getData().add(new XYChart.Data("1800", 203));
        series3.getData().add(new XYChart.Data("1850", 276));
        series3.getData().add(new XYChart.Data("1900", 408));
        series3.getData().add(new XYChart.Data("1950", 547));
        series3.getData().add(new XYChart.Data("1999", 729));
        series3.getData().add(new XYChart.Data("2050", 628));

        StackedAreaChart<String, Number> areaChart = new StackedAreaChart(xAxis, yAxis);
        areaChart.setTitle("Historic and Estimated Worldwide Population Growth by Region");
        areaChart.getData().addAll(series1, series2, series3);

        return areaChart;
    }

    private static StackedBarChart get_StackedBar()
    {
        //Defining the x axis
        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                ("Africa", "America", "Asia", "Europe", "Oceania")));
        xAxis.setLabel("category");

//Defining the y axis
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (In millions)");

        //Creating the Bar chart
        StackedBarChart<String, Number> stackedBarChart =
                new StackedBarChart<>(xAxis, yAxis);
        stackedBarChart.setTitle("Historic World Population by Region");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("1800");
        series1.getData().add(new XYChart.Data<>("Africa", 107));
        series1.getData().add(new XYChart.Data<>("America", 31));
        series1.getData().add(new XYChart.Data<>("Asia", 635));
        series1.getData().add(new XYChart.Data<>("Europe", 203));
        series1.getData().add(new XYChart.Data<>("Oceania", 2));
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();

        series2.setName("1900");
        series2.getData().add(new XYChart.Data<>("Africa", 133));
        series2.getData().add(new XYChart.Data<>("America", 156));
        series2.getData().add(new XYChart.Data<>("Asia", 947));
        series2.getData().add(new XYChart.Data<>("Europe", 408));
        series1.getData().add(new XYChart.Data<>("Oceania", 6));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("2008");
        series3.getData().add(new XYChart.Data<>("Africa", 973));
        series3.getData().add(new XYChart.Data<>("America", 914));
        series3.getData().add(new XYChart.Data<>("Asia", 4054));
        series3.getData().add(new XYChart.Data<>("Europe", 732));
        series1.getData().add(new XYChart.Data<>("Oceania", 34));

        //Setting the data to bar chart
        stackedBarChart.getData().addAll(series1, series2, series3);

        return stackedBarChart;
    }

}
