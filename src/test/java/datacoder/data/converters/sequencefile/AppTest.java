package datacoder.data.converters.sequencefile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException
    {
    	try{
	    	TextToSequenceFileWriter.createSequenceFileFromText("inputFile", "outputFile");
	    	ArrayList<Text> list = SequenceFileReader.readFromSequenceFile("outputFile");
	        assertTrue(list.get(0).toString().equals("1") );
    	}
    	catch(IOException ex){
    		throw ex;
    	}
    }
}
