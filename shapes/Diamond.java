package shapes;

import utils.ColorFiller;
import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific
 * for a diamond. It draws on the given image a diamond
 * with the center at the coordinates xCenter and yCenter.
 * It acts as a visitor for the given object, in this case
 * an object of type workspace.
 */
public final class Diamond implements ShapeVisitor {
    private int xStart;
    private int yStart;
    private ShapeVisitor[] lines;
    private ColorFiller colorFller;

    public Diamond(final ShapeVisitor[] lines, final int xStart, final int yStart,
                    final Pixel pixelLine, final Pixel pixelFill) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.lines = lines;
        colorFller = new ColorFiller(pixelLine, pixelFill);
    }

    @Override
    public void visit(final Workspace workspace) {
        for (int i = 0; i < lines.length; i++) {
            workspace.accept(lines[i]);
        }

        colorFller.fillShape(workspace, xStart, yStart);
    }
}
