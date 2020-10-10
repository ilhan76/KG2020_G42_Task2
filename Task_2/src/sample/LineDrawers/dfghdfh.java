package sample.LineDrawers;

import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import sample.LineDrawer;

public class dfghdfh implements LineDrawer {
    private final PixelWriter pw;

    public dfghdfh(PixelWriter pw) {
        this.pw = pw;
    }

    private int sign (int x) {
        return Integer.compare(x, 0);
        //возвращает 0, если аргумент (x) равен нулю; -1, если x < 0 и 1, если x > 0.
    }

    public void drawLine (int xStart, int yStart, int xEnd, int yEnd) {
        int x, y, dx, dy, incX, incY, shiftX, shiftY, SupIterable, iterable, err;

        dx = xEnd - xStart;//проекция на ось икс
        dy = yEnd - yStart;//проекция на ось игрек

        incX = sign(dx);
        /*
         * Определяем, в какую сторону нужно будет сдвигаться. Если dx < 0, т.е. отрезок идёт
         * справа налево по иксу, то incx будет равен -1.
         * Это будет использоваться в цикле постороения.
         */
        incY = sign(dy);
        /*
         * Аналогично. Если рисуем отрезок снизу вверх -
         * это будет отрицательный сдвиг для y (иначе - положительный).
         */

        dx = Math.abs(dx);
        dy = Math.abs(dy);
        /*
          далее мы будем сравнивать: "if (dx < dy)"
          поэтому необходимо сделать dx = |dx|; dy = |dy|
        */

        if (dx > dy)
        //определяем наклон отрезка:
        {
            /*
             * Если dx > dy, то значит отрезок "вытянут" вдоль оси икс, т.е. он скорее длинный, чем высокий.
             * Значит в цикле нужно будет идти по икс (строчка el = dx;), значит "протягивать" прямую по иксу
             * надо в соответствии с тем, слева направо и справа налево она идёт (pdx = incx;), при этом
             * по y сдвиг такой отсутствует.
             */
            shiftX = incX;
            shiftY = 0;
            SupIterable = dy;
            iterable = dx;
        }
        else//случай, когда прямая скорее "высокая", чем длинная, т.е. вытянута по оси y
        {
            shiftX = 0;
            shiftY = incY;
            SupIterable = dx;
            iterable = dy;//тогда в цикле будем двигаться по y
        }

        x = xStart;
        y = yStart;
        err = iterable/2;
        pw.setColor(x, y, Color.RED);//ставим первую точку
        //все последующие точки возможно надо сдвигать, поэтому первую ставим вне цикла

        for (int t = 0; t < iterable; t++)//идём по всем точкам, начиная со второй и до последней
        {
            err -= SupIterable;
            if (err < 0)
            {
                err += iterable;
                x += incX;//сдвинуть прямую (сместить вверх или вниз, если цикл проходит по иксам)
                y += incY;//или сместить влево-вправо, если цикл проходит по y
            }
            else
            {
                x += shiftX;//продолжить тянуть прямую дальше, т.е. сдвинуть влево или вправо, если
                y += shiftY;//цикл идёт по иксу; сдвинуть вверх или вниз, если по y
            }

            pw.setColor(x, y, Color.RED);
        }
    }
}
