package datacoder.data.converters.sequencefile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Reader;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

public class SequenceFileReader {
	
	public static ArrayList<Text> readFromSequenceFile(String filename) throws IOException {
		ArrayList<Text> list = new ArrayList<Text>();
		String uri = filename;
		Configuration conf = new Configuration();
		Path path = new Path(uri);
		SequenceFile.Reader reader = null;
		try {
			reader = new SequenceFile.Reader(conf, Reader.file(path), Reader.bufferSize(4096), Reader.start(0));
			Text key = (Text) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
			Text value = (Text) ReflectionUtils.newInstance(reader.getValueClass(), conf);
			// long position = reader.getPosition();
			// reader.seek(position);
			while (reader.next(key, value)) {
				String syncSeen = reader.syncSeen() ? "*" : "";
				System.out.printf("[%s]\t%s\t%s\n", syncSeen, key, value);
				list.add(new Text(value.toString()));
			}
		} finally {
			IOUtils.closeStream(reader);
		}
		
		return list;
	}
}
