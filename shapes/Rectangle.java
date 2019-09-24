package shapes;

import utils.ColorFiller;
import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific
 * for a rectangle. It draws on the given image
 * each line of the shape.
 * It acts as a visitor for the given object,
 * in this case an object of type workspace.
 */
public final class Rectangle implements ShapeVisitor {
    private int xStart;
    private int yStart;
    private ShapeVisitor[] lines;
    private ColorFiller colorFller;

    public Rectangle(final ShapeVisitor[] lines, final int xStart, final int yStart,
                      final Pixel pixelLine, final Pixel pixelFill) {
        this.lines = lines;
        this.xStart = xStart;
        this.yStart = yStart;
        colorFller = new ColorFiller(pixelLine, pixelFill);
    }

    @Override
    public void visit(final Workspace workspace) {
        for (int i = 0; i < lines.length; i++) {
            workspace.accept(lines[i]);
        }

        if (xStart + 1 < workspace.getWidth() && yStart + 1 < workspace.getHeight()) {
        colorFller.fillShape(workspace, xStart + 1, yStart + 1);
        }
    }
}
