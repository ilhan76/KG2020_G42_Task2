package sample.LineDrawers;

import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import sample.LineDrawer;

public class BresenhamLineDrawer implements LineDrawer {

    private final PixelWriter pw;

    public BresenhamLineDrawer(PixelWriter pw) {
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
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int shift = Integer.compare(y2 - y1, 0);
        int e = 2 * dy - dx;
        int y = y1;
        for (int x = x1; x <= x2; x++) {
            if(steep)
                pw.setColor(y, x, Color.BLACK);
            else
                pw.setColor(x, y, Color.BLACK);
            if (e >= 0) {
                y += shift;
                e += -2 * dx + 2 * dy;
            } else
                e += 2 * dy;
        }

    }
    /*int shiftX, shiftY;
        int dx = x2 - x1;
        int dy = y2 - y1;
        int x = x1;
        int y = y1;

        shiftX = sign(dx);
        shiftY = sign(dy);

        dx = Math.abs(dx);
        dy = Math.abs(dy);

        if(dx >= dy) {
            int e = 2 * dy - dx;
            for (int i = 1; i <= dx; i++) {
                pw.setColor(x, y, Color.BLACK);
                if (e >= 0) {
                    y += shiftY;
                    e += -2 * dx + 2 * dy;
                } else
                    e += 2 * dy;
                x += shiftX;
            }
        } else {
            int e = 2 * dx - dy;
            for (int i = 1; i <= dy; i++) {
                pw.setColor(x, y, Color.BLACK);
                if (e >= 0) {
                    x += shiftX;
                    e += -2 * dy + 2 * dx;
                } else
                    e += 2 * dx;
                y += shiftY;
            }
        }

    }*/
}
