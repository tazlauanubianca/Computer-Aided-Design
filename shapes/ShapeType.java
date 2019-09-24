package shapes;

/**
 * This class enumerates all the shapes
 * that can be drawn and it will be used
 * by the ShapeFactory class to determine
 * for each input what type of object should
 * it return.
 */
public enum ShapeType {
    CANVAS("CANVAS"),
    CIRCLE("CIRCLE"),
    DIAMOND("DIAMOND"),
    LINE("LINE"),
    POLYGON("POLYGON"),
    RECTANGLE("RECTANGLE"),
    SQUARE("SQUARE"),
    TRIANGLE("TRIANGLE");

    private String text;

    ShapeType(final String text) {
        this.text = text;
    }
}

