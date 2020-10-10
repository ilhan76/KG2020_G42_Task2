package sample.LineDrawers;

import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import sample.LineDrawer;

public class WuLineDrawer implements LineDrawer {
    private final PixelWriter pw;

    public WuLineDrawer(PixelWriter pw) {
        this.pw = pw;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
        if (steep) {
            int tmp = x1;
            x1 = y1;
            y1 = tmp;

            tmp = x2;
            x2 = y2;
            y2 = tmp;
        }
        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;

            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }

        float dx = x2 - x1;
        float dy = y2 - y1;
        float step = dy / dx;
        float y = y1 + step;
        for (int x = x1; x <= x2; x++)
        {
            if(steep){
                pw.setColor((int) y, x, Color.rgb(0, 0, 0, 1 - (y - (int) y )));
                pw.setColor((int) (y + 1), x, Color.rgb(0, 0, 0, y - (int)y));
            } else {
                pw.setColor(x, (int) y, Color.rgb(0, 0, 0, 1 - (y - (int) y )));
                pw.setColor(x, (int) (y + 1), Color.rgb(0, 0, 0, y - (int)y));
            }
            y += step;
        }

    }
}
