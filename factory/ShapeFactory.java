package factory;

import shapes.Canvas;
import shapes.Circle;
import shapes.Line;
import shapes.Diamond;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import workspace.Pixel;
import shapes.ShapeType;
import shapes.ShapeVisitor;

/**
 * This class is used for implementing factory pattern
 * It has a method which receives a string and an array
 * of strings and returns an object of the type of the
 * first string.
 */
public final class ShapeFactory {
    private static final int BASE16 = 16;
    private static final int NUMBER0 = 0;
    private static final int NUMBER1 = 1;
    private static final int NUMBER2 = 2;
    private static final int NUMBER3 = 3;
    private static final int NUMBER4 = 4;
    private static final int NUMBER5 = 5;
    private static final int NUMBER6 = 6;
    private static final int NUMBER7 = 7;
    private static final int NUMBER8 = 8;
    private static final int NUMBER9 = 9;
    private static final int NUMBER10 = 10;
    private static ShapeFactory instance = new ShapeFactory();

    private ShapeFactory() {
    }

    public static ShapeFactory getInstance() {
        return instance;
    }

    public static ShapeVisitor getShape(final String shapeType, final String... args) {
        if (shapeType == null) {
            return null;
        }

        switch (ShapeType.valueOf(shapeType)) {
        case CANVAS:
            return parseCanvasInput(args);
        case LINE:
            return parseLineInput(args);
        case CIRCLE:
            return parseCircleInput(args);
        case DIAMOND:
            return parseDiamondInput(args);
        case RECTANGLE:
            return parseRectangleInput(args);
        case SQUARE:
            return parseSquareInput(args);
        case TRIANGLE:
            return parseTriangleInput(args);
        case POLYGON:
            return parsePolygonInput(args);
        default:
            return null;
        }
    }

    private static ShapeVisitor parseCanvasInput(final String... args) {
        int height = Integer.parseInt(args[NUMBER1]);
        int width = Integer.parseInt(args[NUMBER2]);
        int rCanvas = Integer.parseInt(args[NUMBER3].substring(NUMBER1, NUMBER3), BASE16);
        int gCanvas = Integer.parseInt(args[NUMBER3].substring(NUMBER3, NUMBER5), BASE16);
        int bCanvas = Integer.parseInt(args[NUMBER3].substring(NUMBER5, NUMBER7), BASE16);
        int aCanvas = Integer.parseInt(args[NUMBER4]);
        Pixel pixel = new Pixel(rCanvas, gCanvas, bCanvas, aCanvas);

        return new Canvas(height, width, pixel);
    }

    private static ShapeVisitor parseLineInput(final String... args) {
        int xStart = Integer.parseInt(args[NUMBER1]);
        int yStart = Integer.parseInt(args[NUMBER2]);
        int xEnd = Integer.parseInt(args[NUMBER3]);
        int yEnd = Integer.parseInt(args[NUMBER4]);
        int rLine = Integer.parseInt(args[NUMBER5].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER5].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER5].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER6]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);

        return new Line(xStart, yStart, xEnd, yEnd, pixelLine);
    }

    private static ShapeVisitor parseCircleInput(final String... args) {
        int xCenter = Integer.parseInt(args[NUMBER1]);
        int yCenter = Integer.parseInt(args[NUMBER2]);
        int radius = Integer.parseInt(args[NUMBER3]);
        int rLine = Integer.parseInt(args[NUMBER4].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER4].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER4].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER5]);
        int rFill = Integer.parseInt(args[NUMBER6].substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER6].substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER6].substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER7]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        return new Circle(xCenter, yCenter, radius, pixelLine, pixelFill);
    }

    private static ShapeVisitor parseDiamondInput(final String... args) {
        int xStart = Integer.parseInt(args[NUMBER1]);
        int yStart = Integer.parseInt(args[NUMBER2]);
        int width = Integer.parseInt(args[NUMBER3]);
        int height = Integer.parseInt(args[NUMBER4]);
        int rLine = Integer.parseInt(args[NUMBER5].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER5].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER5].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER6]);
        int rFill = Integer.parseInt(args[NUMBER7].substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER7].substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER7].substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER8]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        ShapeVisitor[] linesDiamond = new ShapeVisitor[NUMBER4];

        ShapeVisitor line1 = new Line(xStart, yStart - height / NUMBER2,
                                      xStart + width / NUMBER2, yStart,
                                      pixelLine);
        ShapeVisitor line2 = new Line(xStart + width / NUMBER2, yStart,
                                      xStart, yStart + height / NUMBER2,
                                      pixelLine);
        ShapeVisitor line3 = new Line(xStart, yStart + height / NUMBER2,
                                      xStart - width / NUMBER2, yStart,
                                      pixelLine);
        ShapeVisitor line4 = new Line(xStart, yStart - height / NUMBER2,
                                      xStart - width / NUMBER2, yStart,
                                      pixelLine);

        linesDiamond[NUMBER0] = line1;
        linesDiamond[NUMBER1] = line2;
        linesDiamond[NUMBER2] = line3;
        linesDiamond[NUMBER3] = line4;

        return new Diamond(linesDiamond, xStart, yStart,
                            pixelLine, pixelFill);
    }

    private static ShapeVisitor parseRectangleInput(final String... args) {
        int xStart = Integer.parseInt(args[NUMBER1]);
        int yStart = Integer.parseInt(args[NUMBER2]);
        int height = Integer.parseInt(args[NUMBER3]);
        int width = Integer.parseInt(args[NUMBER4]);
        int rLine = Integer.parseInt(args[NUMBER5].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER5].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER5].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER6]);
        int rFill = Integer.parseInt(args[NUMBER7].substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER7].substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER7].substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER8]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        ShapeVisitor[] linesRectangle = new ShapeVisitor[NUMBER4];

        ShapeVisitor line1 = new Line(xStart, yStart, xStart + width - NUMBER1, yStart,
                                      pixelLine);
        ShapeVisitor line2 = new Line(xStart, yStart, xStart, yStart + height - NUMBER1,
                                      pixelLine);
        ShapeVisitor line3 = new Line(xStart, yStart + height - NUMBER1,
                                      xStart + width - NUMBER1, yStart + height - NUMBER1,
                                      pixelLine);
        ShapeVisitor line4 = new Line(xStart + width - NUMBER1, yStart,
                                      xStart + width - NUMBER1, yStart + height - NUMBER1,
                                      pixelLine);

        linesRectangle[NUMBER0] = line1;
        linesRectangle[NUMBER1] = line2;
        linesRectangle[NUMBER2] = line3;
        linesRectangle[NUMBER3] = line4;

        return new Rectangle(linesRectangle, xStart, yStart,
                              pixelLine, pixelFill);
    }

    private static ShapeVisitor parseSquareInput(final String... args) {
        int xStart = Integer.parseInt(args[NUMBER1]);
        int yStart = Integer.parseInt(args[NUMBER2]);
        int length = Integer.parseInt(args[NUMBER3]);
        int rLine = Integer.parseInt(args[NUMBER4].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER4].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER4].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER5]);
        int rFill = Integer.parseInt(args[NUMBER6].substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER6].substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER6].substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER7]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        ShapeVisitor[] linesSquare = new ShapeVisitor[NUMBER4];

        ShapeVisitor line1 = new Line(xStart, yStart, xStart + length - NUMBER1, yStart,
                                      pixelLine);
        ShapeVisitor line2 = new Line(xStart, yStart, xStart, yStart + length - NUMBER1,
                                      pixelLine);
        ShapeVisitor line3 = new Line(xStart, yStart + length - NUMBER1,
                                      xStart + length - NUMBER1, yStart + length - NUMBER1,
                                      pixelLine);
        ShapeVisitor line4 = new Line(xStart + length - NUMBER1, yStart,
                                      xStart + length - NUMBER1, yStart + length - NUMBER1,
                                      pixelLine);

        linesSquare[NUMBER0] = line1;
        linesSquare[NUMBER1] = line2;
        linesSquare[NUMBER2] = line3;
        linesSquare[NUMBER3] = line4;

        return new Square(linesSquare, xStart, yStart, pixelLine, pixelFill);
    }

    private static ShapeVisitor parseTriangleInput(final String... args) {
        int rLine = Integer.parseInt(args[NUMBER7].substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER7].substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER7].substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER8]);
        int rFill = Integer.parseInt(args[NUMBER9].substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER9].substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER9].substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER10]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        ShapeVisitor[] linesTriangle = new ShapeVisitor[NUMBER3];
        int[] points = new int[NUMBER6];
        int i;
        int point;

        for (i = NUMBER1; i < NUMBER7; i++) {
            point = Integer.parseInt(args[i]);
            points[i - 1] = point;
        }

        for (i = NUMBER0; i < NUMBER4; i = i + NUMBER2) {
            ShapeVisitor line = new Line(points[i], points[i + NUMBER1],
                                         points[i + NUMBER2], points[i + NUMBER3],
                                         pixelLine);
            linesTriangle[i / NUMBER2] = line;
        }

        ShapeVisitor line = new Line(points[i], points[i + NUMBER1],
                                     points[NUMBER0], points[NUMBER1],
                                     pixelLine);
        linesTriangle[i / NUMBER2] = line;
        return new Triangle(linesTriangle, pixelLine, pixelFill);
    }

    private static ShapeVisitor parsePolygonInput(final String... args) {
        int numberOfLines = Integer.parseInt(args[NUMBER1]);
        int rLine = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER2].
                           substring(NUMBER1, NUMBER3), BASE16);
        int gLine = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER2].
                           substring(NUMBER3, NUMBER5), BASE16);
        int bLine = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER2].
                           substring(NUMBER5, NUMBER7), BASE16);
        int aLine = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER3]);
        int rFill = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER4].
                           substring(NUMBER1, NUMBER3), BASE16);
        int gFill = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER4].
                           substring(NUMBER3, NUMBER5), BASE16);
        int bFill = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER4].
                           substring(NUMBER5, NUMBER7), BASE16);
        int aFill = Integer.parseInt(args[NUMBER2 * numberOfLines + NUMBER5]);

        Pixel pixelLine = new Pixel(rLine, gLine, bLine, aLine);
        Pixel pixelFill = new Pixel(rFill, gFill, bFill, aFill);

        ShapeVisitor line;
        ShapeVisitor[] linesPolygon = new ShapeVisitor[numberOfLines];
        int[] points = new int[numberOfLines * NUMBER2];
        int i;
        int point;

        for (i = NUMBER2; i < numberOfLines * NUMBER2 + NUMBER2; i++) {
            point = Integer.parseInt(args[i]);
            points[i - NUMBER2] = point;
        }

        for (i = NUMBER0; i < numberOfLines * NUMBER2 - NUMBER2; i = i + NUMBER2) {
            line = new Line(points[i], points[i + NUMBER1],
                            points[i + NUMBER2], points[i + NUMBER3],
                            pixelLine);
            linesPolygon[i / NUMBER2] = line;
        }

        line = new Line(points[i], points[i + NUMBER1],
                        points[NUMBER0], points[NUMBER1],
                        pixelLine);
        linesPolygon[i / NUMBER2] = line;

        return new Polygon(linesPolygon, pixelLine, pixelFill);
    }
}
