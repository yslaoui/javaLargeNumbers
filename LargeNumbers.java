package largeNumbers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LargeNumbers extends Application {
    @Override
    public void start(Stage window) throws Exception {

        NumberAxis xAxis = new NumberAxis(0, 100, 10);
        NumberAxis yAxis = new NumberAxis(1,6,1);

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> data = series.getData();



        chart.getData().add(series);

        Scene scene = new Scene(chart);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(LargeNumbers.class);
    }
}
