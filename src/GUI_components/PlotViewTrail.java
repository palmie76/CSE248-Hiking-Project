package GUI_components;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class PlotViewTrail extends BorderPane {
	
	XYChart.Series resultMap;
	XYChart.Series resultSet;
	LineChart lineChart;
	NumberAxis xAxis;
	NumberAxis yAxis;
	Button btnBack;
	
	public PlotViewTrail() {
		xAxis = new NumberAxis();
	    yAxis = new NumberAxis();
	    xAxis.setLabel("Amount of Items");
	    yAxis.setLabel("Method time elapsed");
	    
	    LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
	    lineChart.setTitle("Trail Performance");
	    
	    resultMap = new XYChart.Series();
        resultMap.setName("Map Data Structure");
        
        resultSet = new XYChart.Series();
        resultSet.setName("Set Data Structure");
        lineChart.getData().addAll(resultMap, resultSet);
        
        btnBack = new Button("Back");
        
        HBox hboxLineChart = new HBox(lineChart);
        HBox hboxButtons = new HBox(btnBack);
        HBox hbox = new HBox(hboxLineChart, hboxButtons);
		this.setCenter(hbox);
	

}
}
