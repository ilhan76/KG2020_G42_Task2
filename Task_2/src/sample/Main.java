package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.LineDrawers.BresenhamLineDrawer;
import sample.LineDrawers.DDALineDrawer;
import sample.LineDrawers.WuLineDrawer;
import sample.Utils.DrawUtils;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WritableImage writableImage = new WritableImage(1500, 1500);
        Group group = new Group();
        Scene scene = new Scene(group, 1500, 900);
        primaryStage.setTitle("Hello World");

        writableImage.getPixelWriter().setColor(50, 50, Color.ALICEBLUE);
        LineDrawer ddaLineDrawer = new DDALineDrawer(writableImage.getPixelWriter());
        LineDrawer bresenhamLineDrawer = new BresenhamLineDrawer(writableImage.getPixelWriter());
        LineDrawer wuLineDrawer = new WuLineDrawer(writableImage.getPixelWriter());

        DrawUtils.drawSnowflakes(wuLineDrawer, (int) (scene.getWidth() / 2), (int) scene.getHeight() / 2, 32, 200);
        DrawUtils.drawSnowflakes(bresenhamLineDrawer, (int) (scene.getWidth() / 2) + 500, (int) scene.getHeight() / 2, 32, 200);
        DrawUtils.drawSnowflakes(ddaLineDrawer, (int) (scene.getWidth() / 2) - 500, (int) scene.getHeight() / 2, 32, 200);


        group.getChildren().add(new ImageView(writableImage));
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
