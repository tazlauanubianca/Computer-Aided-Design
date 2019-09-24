package utils;

import java.util.Stack;

import workspace.Pixel;
import workspace.Workspace;

/**
 * This class has a method that implements the
 * flood fill for any shape given. It colors
 * any shape checking for each pixel in the shape
 * to respect the conditions to be colored.
 */
public final class ColorFiller {
    private int rFill;
    private int gFill;
    private int bFill;
    private int aFill;
    private int rLine;
    private int gLine;
    private int bLine;
    private int aLine;

    public ColorFiller(final Pixel pixelLine, final Pixel pixelFill) {
        this.rLine = pixelLine.getR();
        this.gLine = pixelLine.getG();
        this.bLine = pixelLine.getB();
        this.aLine = pixelLine.getA();
        this.rFill = pixelFill.getR();
        this.gFill = pixelFill.getG();
        this.bFill = pixelFill.getB();
        this.aFill = pixelFill.getA();
    }

    public void fillShape(final Workspace workspace, final int xCurrent, final int yCurrent) {
        Pixel[][] image = workspace.getImage();
        Stack<int[]> pixelStack = new Stack<int[]>();
        int width = workspace.getWidth();
        int height = workspace.getHeight();

        int[] currentPixel = {xCurrent, yCurrent};
        pixelStack.push(currentPixel);

        while (!pixelStack.isEmpty()) {
            int[] pixel = pixelStack.pop();
            int x = pixel[0];
            int y = pixel[1];

            image[y][x].setPixel(rFill, gFill, bFill, aFill);

            if (check(x + 1, y, image, width, height)) {
                int[] pixelRight = {x + 1, y};
                pixelStack.push(pixelRight);
            }

            if (check(x - 1, y, image, width, height)) {
                int[] pixelLeft = {x - 1, y};
                pixelStack.push(pixelLeft);
            }

            if (check(x, y + 1, image, width, height)) {
                int[] pixelUp = {x, y + 1};
                pixelStack.push(pixelUp);
            }

            if (check(x, y - 1, image, width, height)) {
                int[] pixelDown = {x, y - 1};
                pixelStack.push(pixelDown);
            }
        }
    }

    private boolean check(final int x, final int y, final Pixel[][] image,
                            final int width, final int height) {
        if (x >= width || x < 0 || y >= height || y < 0) {
            return false;
        }

        if (image[y][x].getA() == aLine && image[y][x].getR() == rLine
                && image[y][x].getG() == gLine && image[y][x].getB() == bLine) {
            return false;
        }

        if (image[y][x].getA() == aFill && image[y][x].getR() == rFill
                && image[y][x].getG() == gFill && image[y][x].getB() == bFill) {
            return false;
        }

        return true;
    }
}

