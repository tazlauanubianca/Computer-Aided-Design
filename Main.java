import workspace.Workspace;
import datareader.DataReader;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        String inputFile = args[0];

        DataReader readData = new DataReader(inputFile);

        try {
            readData.readDataFromFile();
        } catch (Exception e) {
            System.err.println("IOExceptio: " + e.getMessage());
        }

        Workspace workspace = readData.getWorkspace();
        workspace.drawShapes();
        workspace.drawImage();
    }
}
