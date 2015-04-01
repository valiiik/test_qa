package addons;

import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by valik on 3/11/15.
 */
public class PropertyLoader {
    private static final String PROPERTY_FILE = "/home/valik/qa/IdeaProjects/GodunFirstProject/src/test/resources/application.properties";

    public static String loadProperty(String name)
    {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            Assert.fail(LogForTest.info(name));
        }
        String value = "";
        if (name != null)
        {
            value = props.getProperty(name);
        }
        return value;
    }
}
