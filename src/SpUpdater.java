import java.io.File;
import java.io.IOException;

public class SpUpdater {

	private String fileName = "startSP.jar", updateFileArchive = "update.zip";
	private String updateFolder = System.getProperty("user.dir") + File.separator + "update" + File.separator;
	private String toDirectory = System.getProperty("user.dir") + File.separator;

	public static void main(String[] args) {
		SpUpdater updater = new SpUpdater();
		updater.deleteAppFile();
		updater.unzipUpdateFile();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		updater.startApp();

	}

	public SpUpdater() {

	}

	public void deleteAppFile() {
		new File(toDirectory + fileName).delete();
	}

	public void unzipUpdateFile() {
		try {
			FileChanger.unzip(new File(updateFolder + updateFileArchive), new File(toDirectory + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp() {
		try {
			Process proc = Runtime.getRuntime().exec("java -jar startSp.jar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
