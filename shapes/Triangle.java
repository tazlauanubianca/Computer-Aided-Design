package shapes;

import utils.ColorFiller;
import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific
 * for a triangle. It draws on the given image
 * each line of the shape.
 * It acts as a visitor for the given object,
 * in this case an object of type workspace.
 */
public final class Triangle implements ShapeVisitor {
    private ShapeVisitor[] lines;
    private ColorFiller colorFller;

    public Triangle(final ShapeVisitor[] lines, final Pixel pixelLine, final Pixel pixelFill) {
        this.lines = lines;
        colorFller = new ColorFiller(pixelLine, pixelFill);
    }

    @Override
    public void visit(final Workspace workspace) {
        for (int i = 0; i < lines.length; i++) {
            workspace.accept(lines[i]);
        }

        int xCenter = 0;
        int yCenter = 0;

        for (int i = 0; i < lines.length; i++) {
            xCenter += ((Line) lines[i]).getxStart();
            yCenter += ((Line) lines[i]).getyStart();
        }

        xCenter /= lines.length;
        yCenter /= lines.length;

        colorFller.fillShape(workspace, xCenter, yCenter);
    }
}

