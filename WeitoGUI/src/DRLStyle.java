import java.io.Serializable;


public class DRLStyle implements Serializable {
	String name = "";
	String file = "";
	
	public DRLStyle(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}