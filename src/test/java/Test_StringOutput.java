import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ca.mcmaster.se2aa4.mazerunner.StringOutput;

public class Test_StringOutput 
{
    @Test
    public void TestCanonical()
    {
        StringOutput testString = new StringOutput();
        testString.appendString('C');
        testString.appendString('C');
        testString.appendString('C');

        String expected = "CCC";
        String result = testString.returnCanonical();

        boolean resultBool = (expected.equals(result));
        assertTrue(resultBool);
        //canonical output should return true if string produced is CCC
    }
    @Test
    public void TestFactorizedOutput()
    {
        StringOutput testString = new StringOutput();
        testString.appendString('C');
        testString.appendString('C');
        testString.appendString('C');

        String expected = "3C ";
        String result = testString.factorizedOutput();

        boolean resultBool = (expected.equals(result));
        assertTrue(resultBool);
        //factorized output should return true if string is "3C "
    }
    
    
}
