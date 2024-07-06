package largeNumbers;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Random;

public class LargeNumbers extends Application {
    @Override
    public void start(Stage window) throws Exception {

        NumberAxis xAxis = new NumberAxis(0, 100, 10);
        NumberAxis yAxis = new NumberAxis(1,6,1);

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> data = series.getData();

        new AnimationTimer() {
            long previous = 0;
            int sum = 0;
            int count = 0;
            final long second = 1000000000L;
            Random random = new Random();
            @Override
            public void handle(long current) {
                if (current - previous < second / 10) {
                    return;
                }
                sum += 1 + random.nextInt(6);
                count += 1;
                previous = current;
                data.add(new XYChart.Data<>(count, 1.0 * sum / count));
                System.out.println(sum / count);
            }
        }.start();


        chart.getData().add(series);

        Scene scene = new Scene(chart);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(LargeNumbers.class);
    }
}



