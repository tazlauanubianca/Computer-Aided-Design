package shapes;

import workspace.Pixel;
import workspace.Workspace;

/**
 * This class implements the functions specific for the
 * canvas. It sets the dimensions and color for the picture.
 * It acts as a visitor for the given object, in this case
 * an object of type workspace.
 */
public final class Canvas implements ShapeVisitor {
    private int height;
    private int width;
    private Pixel pixelCanvas;

    public Canvas(final int height, final int width, final Pixel pixelCanvas) {
        this.height = height;
        this.width = width;
        this.pixelCanvas = pixelCanvas;
    }

    @Override
    public void visit(final Workspace workspace) {
        workspace.generateImage(height, width);
        Pixel[][] image = workspace.getImage();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image[y][x].setPixel(pixelCanvas.getR(), pixelCanvas.getG(),
                                     pixelCanvas.getB(), pixelCanvas.getA());
            }
        }
    }
}
