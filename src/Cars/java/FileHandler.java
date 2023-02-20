import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileHandler {
    public static Properties loadFile(String path) throws IOException {
        InputStream criteriaVariables = null;
        Properties properties = null;
        try {
            criteriaVariables = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            properties = new Properties();
            properties.load(criteriaVariables);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert criteriaVariables != null;
            criteriaVariables.close();
        }
        return properties;
    }
}
