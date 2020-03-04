package java_learn.IO.bytestream;

import java.io.File;
import java.io.FileFilter;

public class FileFilterByDir implements FileFilter {

	@Override
	public boolean accept(File arg0) {

		return arg0.isDirectory();
	}

}
