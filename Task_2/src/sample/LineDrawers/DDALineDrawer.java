package sample.LineDrawers;

import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import sample.LineDrawer;

public class DDALineDrawer implements LineDrawer {
    private final PixelWriter pw;

    public DDALineDrawer(PixelWriter pw) {
        this.pw = pw;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if(Math.abs(dx) > Math.abs(dy)){
            if (x1 > x2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            double k = dy / dx;
            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                pw.setColor(j, (int) i, Color.BLACK);
            }
        } else {
            if (y1 > y2){
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            double k = 1 / (dy / dx);
            for (int i = y1; i <= y2; i++) {
                double j = k * (i - y1) + x1;
                pw.setColor((int)j, i, Color.BLACK);
            }
        }

    }
}
