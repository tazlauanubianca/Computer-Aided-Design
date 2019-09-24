package shapes;

import utils.ColorFiller;
import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific
 * for a circle. It draws on the given image a circle
 * with the center at the coordinates xCenter and yCenter
 * and has the given radius. To draw the circle it uses the
 * Bresenham Algorithm for circles.
 * It acts as a visitor for the given object, in this case
 * an object of type workspace.
 */
public final class Circle implements ShapeVisitor {
    private int xCenter;
    private int yCenter;
    private int radius;
    private int height;
    private int width;
    private int rLine;
    private int gLine;
    private int bLine;
    private int aLine;
    private ColorFiller colorFller;
    private static final int NUMBER2 = 2;
    private static final int NUMBER3 = 3;
    private static final int NUMBER4 = 4;
    private static final int NUMBER6 = 6;
    private static final int NUMBER10 = 10;

    public Circle(final int xCenter, final int yCenter, final int radius,
                   final Pixel pixelLine, final Pixel pixelFill) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.aLine = pixelLine.getA();
        this.rLine = pixelLine.getR();
        this.gLine = pixelLine.getG();
        this.bLine = pixelLine.getB();
        colorFller = new ColorFiller(pixelLine, pixelFill);
    }

    @Override
    public void visit(final Workspace workspace) {
        Pixel[][] image = workspace.getImage();
        this.height = workspace.getHeight();
        this.width = workspace.getWidth();

        bresenhamAlgorithm(image, xCenter, yCenter);
        colorFller.fillShape(workspace, xCenter, yCenter);
    }

    private void bresenhamAlgorithm(final Pixel[][] image,
                                     final int xCenterAlgorithm,
                                     final int yCenterAlgorithm) {

        int p = 0;
        int q = radius;
        int d = NUMBER3 - NUMBER2 * radius;

        while (q >= p) {
            drawCircle(image, xCenterAlgorithm, yCenterAlgorithm, p, q);
            p++;

            if (d > 0) {
                q--;
                d += NUMBER4 * (p - q) + NUMBER10;
            } else {
                d += NUMBER4 * p + NUMBER6;
            }

            drawCircle(image, xCenterAlgorithm, yCenterAlgorithm, p, q);
        }
    }

    private void drawCircle(final Pixel[][] image, final int x, final int y,
                             final int p, final int q) {
        if (y + p < height && y + p >= 0 && x + q < width && x + q >= 0) {
            image[y + p][x + q].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y - p < height && y - p >= 0 && x + q < width && x + q >= 0) {
            image[y - p][x + q].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y + p < height && y + p >= 0 && x - q < width && x - q >= 0) {
            image[y + p][x - q].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y - p < height && y - p >= 0 && x - q < width && x - q >= 0) {
            image[y - p][x - q].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y + q < height && y + q >= 0 && x + p < width && x + p >= 0) {
            image[y + q][x + p].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y - q < height && y - q >= 0 && x + p < width && x + p >= 0) {
            image[y - q][x + p].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y + q < height && y + q >= 0 && x - p < width && x - p >= 0) {
            image[y + q][x - p].setPixel(rLine, gLine, bLine, aLine);
        }

        if (y - q < height && y - q >= 0 && x - p < width && x - p >= 0) {
            image[y - q][x - p].setPixel(rLine, gLine, bLine, aLine);
        }
    }
}

