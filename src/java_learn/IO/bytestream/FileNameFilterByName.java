package java_learn.IO.bytestream;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterByName implements FilenameFilter {
	private String namefileter;
	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.contains(namefileter);
	}
	public FileNameFilterByName(String namefileter) {
		super();
		this.namefileter = namefileter;
	}

}
