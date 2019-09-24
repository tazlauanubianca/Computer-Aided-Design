package shapes;

import workspace.Workspace;

/**
 * This interface is used to implement
 * visitor pattern and factory pattern.
 * Each shape that will act as a visitor
 * and will also be returned by the shape
 * factory class will implement this interface.
 */
public interface ShapeVisitor {
    void visit(Workspace workspace);
}
