
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileChanger {


	public static void unzip(File source, File destination) throws IOException {
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(source);
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze = zis.getNextEntry();
		while (ze != null) {
			FileOutputStream fos = new FileOutputStream(destination);
			int len;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			zis.closeEntry();
			ze = zis.getNextEntry();
		}

		fis.close();

	}

}
