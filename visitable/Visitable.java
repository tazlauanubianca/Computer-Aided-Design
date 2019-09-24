package visitable;

import shapes.ShapeVisitor;

/**
 * This interface is used for the visitor
 * pattern. It will be implemented by the
 * Workspace class and the shapes will act
 * as visitors for it.
 */
public interface Visitable {
    void accept(ShapeVisitor shapeVisitor);
}
