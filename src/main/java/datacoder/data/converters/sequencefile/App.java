package datacoder.data.converters.sequencefile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.SequenceFile.Metadata;
import org.apache.hadoop.io.SequenceFile.Writer;
import org.apache.hadoop.io.compress.DefaultCodec;

public class App {
	public static void main(String[] args) throws IOException {
		// String path2 =
		// App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		// String decodedPath = URLDecoder.decode(path2, "UTF-8");
		// System.out.print(decodedPath);
		String inFile = "inputFile";
		String outFile = "outputFile";
		TextToSequenceFileWriter.createSequenceFileFromText(inFile, outFile);
		SequenceFileReader.readFromSequenceFile(outFile);
	}
}
