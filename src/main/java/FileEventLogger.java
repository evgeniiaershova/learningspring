import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{

    String fileName;
    File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException ioe) {
            System.err.println("IOException 666: " + ioe.getMessage());
        }
    }
    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException(fileName  + " is read only!");
        }
    }
}
