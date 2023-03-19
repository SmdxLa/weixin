import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IOtest {
    @Test
    public void getPath() {
        String rootPath = System.getProperty("user.dir");
        System.out.println("Project relative path: " + rootPath);


        String filename = "all_bg02.b0c9ee77.png";
        String path = null;
        try {
            path = new File(filename).getCanonicalPath();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文件路径：" + path);

    }

    }
