package workspace;

import visitable.Visitable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import shapes.ShapeVisitor;

/**
 * This class is used to keep the matrix of pixels
 * representing the image that will be drawn. It also
 * has an array of ShapeVisitors representing all the
 * shapes that will be applied on the image. This class
 * will be visited by the shapes, being part of the visitor
 * pattern.
 */
public final class Workspace implements Visitable {
    private int height;
    private int width;
    private ArrayList<ShapeVisitor> drawOperations = new ArrayList<ShapeVisitor>();
    private Pixel[][] image;
    private static final int NUMBER8 = 8;
    private static final int NUMBER16 = 16;
    private static final int NUMBER24 = 24;

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public Pixel[][] getImage() {
        return image;
    }

    public void setImage(final Pixel[][] image) {
        this.image = image;
    }

    public Workspace(final ArrayList<ShapeVisitor> drawOperations) {
        this.drawOperations = drawOperations;
        image = new Pixel[height][width];
    }

    public void generateImage(final int heightImage, final int widthImage) {
        this.height = heightImage;
        this.width = widthImage;
        image = new Pixel[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image[y][x] = new Pixel();
            }
        }
    }

    public void drawShapes() {
        for (int i = 0; i < drawOperations.size(); i++) {
            this.accept(drawOperations.get(i));
        }
    }

    public void drawImage() {
        BufferedImage drawing = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        File file = null;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel currentPixel = image[y][x];

                int a = currentPixel.getA();
                int r = currentPixel.getR();
                int g = currentPixel.getG();
                int b = currentPixel.getB();
                int pixelColor = (a << NUMBER24) | (r << NUMBER16) | (g << NUMBER8) | b;

                drawing.setRGB(x, y, pixelColor);
            }
        }

        try {
            file = new File("drawing.png");
            ImageIO.write(drawing, "png", file);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void accept(final ShapeVisitor visitor) {
        visitor.visit(this);
    }
}


