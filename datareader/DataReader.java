package datareader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import factory.ShapeFactory;
import shapes.ShapeVisitor;
import workspace.Workspace;

/**
 * This class is used to read the input from the
 * given file. It reads the input line by line and
 * makes an array of all the shapes that are requested
 * The class also has a method that returns an object of
 * type workspace which contains the array of shapes.
 */
public final class DataReader {
    private BufferedReader fileBuffer;
    private FileReader fileReader;
    private Workspace workspace;
    private ArrayList<ShapeVisitor> drawOperations;

    public DataReader(final String fileName) {
        try {
            fileReader = new FileReader(fileName);
            fileBuffer = new BufferedReader(fileReader);
            drawOperations = new ArrayList<ShapeVisitor>();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFound:" + e.getMessage());
        }
    }

    public void readDataFromFile() throws IOException {
        String shapes = fileBuffer.readLine();

        int numberOfShapes = Integer.parseInt(shapes);

        for (int i = 0; i < numberOfShapes; i++) {
            String shape = fileBuffer.readLine();
            String[] shapeInfo = shape.split(" ");

            ShapeVisitor drawingVisitor = ShapeFactory.getShape(shapeInfo[0], shapeInfo);
            drawOperations.add(drawingVisitor);
        }

        fileReader.close();
        fileBuffer.close();
    }

    public Workspace getWorkspace() {
        workspace = new Workspace(drawOperations);
        return workspace;
    }
}
