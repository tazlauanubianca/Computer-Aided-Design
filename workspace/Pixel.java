package workspace;

/**
 * This class implements the methods
 * needed to keep the information about
 * a pixel in the image, the values for
 * R, G, B and A channels.
 */
public final class Pixel {
    private int rPixel;
    private int gPixel;
    private int bPixel;
    private int aPixel;

    public Pixel() {
    }

    public Pixel(final int r, final int g, final int b, final int a) {
        this.rPixel = r;
        this.gPixel = g;
        this.bPixel = b;
        this.aPixel = a;
    }

    public int getR() {
        return this.rPixel;
    }

    public void setR(final int r) {
        this.rPixel = r;
    }

    public int getG() {
        return this.gPixel;
    }

    public void setG(final int g) {
        this.gPixel = g;
    }

    public int getB() {
        return this.bPixel;
    }

    public void setB(final int b) {
        this.bPixel = b;
    }

    public int getA() {
        return this.aPixel;
    }

    public void setA(final int a) {
        this.aPixel = a;
    }

    public void setPixel(final int r, final int g, final int b, final int a) {
        this.rPixel = r;
        this.gPixel = g;
        this.bPixel = b;
        this.aPixel = a;
    }
}

