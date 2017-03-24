package exception.finallyException;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowTryException {
	public void readFile(String fileName) throws IOException {
		FileInputStream input = null;
		IOException readException = null;
		try {
			input = new FileInputStream(fileName);
		} catch (IOException ex) {
			readException = ex;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					if (readException!=null) {
						readException.addSuppressed(e);
					}else{
						readException = e;
					}
				}
			}
			if (readException != null) {
				throw readException;
			}
		}
	}
}
