package shapes;

import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific
 * for a line. It draws on the given image a line
 * which starts at the coordinates xStart and yStart
 * and ends at coordinates xEnd and yEnd. To draw the line
 * it uses the Bresenham Algorithm for lines.
 * It acts as a visitor for the given object, in this case
 * an object of type workspace.
 */
public final class Line implements ShapeVisitor {
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private int rLine;
    private int gLine;
    private int bLine;
    private int aLine;
    private int height;
    private int width;

    public int getxStart() {
        return xStart;
    }

    public void setxStart(final int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(final int yStart) {
        this.yStart = yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public void setxEnd(final int xEnd) {
        this.xEnd = xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public void setyEnd(final int yEnd) {
        this.yEnd = yEnd;
    }

    public Line(final int xStart, final int yStart, final int xEnd,
                 final int yEnd, final Pixel pixel) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.rLine = pixel.getR();
        this.gLine = pixel.getG();
        this.bLine = pixel.getB();
        this.aLine = pixel.getA();
    }

    @Override
    public void visit(final Workspace workspace) {
        Pixel[][] image = workspace.getImage();
        height = workspace.getHeight();
        width = workspace.getWidth();

        bresenhamAlgorithm(image, xStart, yStart, xEnd, yEnd);
    }

    private void bresenhamAlgorithm(final Pixel[][] image,
                                     final int xStartAlgorithm, final int yStartAlgorithm,
                                     final int xEndAlgorithm, final int yEndAlgorithm) {
        int x = xStartAlgorithm;
        int y = yStartAlgorithm;
        int deltaX = Math.abs(xEndAlgorithm - xStartAlgorithm);
        int deltaY = Math.abs(yEndAlgorithm - yStartAlgorithm);
        int signDeltaX = (int) Math.signum(xEndAlgorithm - xStartAlgorithm);
        int signDeltaY = (int) Math.signum(yEndAlgorithm - yStartAlgorithm);
        boolean interchanged = false;
        int error;

        if (deltaY > deltaX) {
            int tmp;
            tmp = deltaX;
            deltaX = deltaY;
            deltaY = tmp;
            interchanged = true;
        } else {
            interchanged = false;
        }

        error = 2 * deltaY - deltaX;

        for (int i = 0; i <= deltaX; i++) {
            if (x < width && x >= 0 && y < height && y >= 0) {
                image[y][x].setPixel(rLine, gLine, bLine, aLine);
            }

            while (error > 0) {
                if (interchanged) {
                    x = x + signDeltaX;
                } else {
                    y = y + signDeltaY;
                }

                error = error - 2 * deltaX;
            }

            if (interchanged) {
                y = y + signDeltaY;
            } else {
                x = x + signDeltaX;
            }

            error = error + 2 * deltaY;
        }
    }
}
