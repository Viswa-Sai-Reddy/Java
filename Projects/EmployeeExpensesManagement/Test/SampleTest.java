import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    public void testSomeThing(){
        int a = 10;
        int b = 15;
        int total = a+b;

        Assertions.assertEquals(25,total);
    }

}
