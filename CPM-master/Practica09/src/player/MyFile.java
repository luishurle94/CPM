package player;

import java.io.File;

public class MyFile {
	private File file;

	public MyFile(File f) {
		this.file = f;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String toString() {
		String aux = file.getName();
		return aux.substring(0, aux.length() - 4);
	}
}
