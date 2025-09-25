import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

public class Tests {

    @Before
    public void before() {
        Main.isRunningTest = true;
        Main.testSzervezet = "TISZ";
    }

    @Test
    public void MainTest() throws FileNotFoundException {
        Main.main(null);
    }

    @After
    public void after() {
        Main.isRunningTest = false;
    }
}
