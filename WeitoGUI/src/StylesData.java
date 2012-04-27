import java.util.ArrayList;
import java.util.List;


public class StylesData {
	static StylesData instance = new StylesData();
	String masterStyle = "";
	List<DRLStyle> styles = new ArrayList<DRLStyle>();
	String masterSelection = "";
	String excelSelection = "";
 
	protected StylesData() {
	}

	public class DRLStyle {
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
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
	}
	
	public String getMasterStyle() {
		return masterStyle;
	}
	public void setMasterStyle(String masterStyle) {
		this.masterStyle = masterStyle;
	}
	public List<DRLStyle> getStyles() {
		return styles;
	}
	public void setStyles(List<DRLStyle> styles) {
		this.styles = styles;
	}
	public String getMasterSelection() {
		return masterSelection;
	}
	public void setMasterSelection(String masterSelection) {
		this.masterSelection = masterSelection;
	}
	public String getExcelSelection() {
		return excelSelection;
	}
	public void setExcelSelection(String excelSelection) {
		this.excelSelection = excelSelection;
	}
	public static StylesData getInstance() {
		return instance;
	}

}
