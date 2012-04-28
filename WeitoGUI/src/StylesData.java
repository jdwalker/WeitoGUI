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

	public String getMasterStyleFilePath() {
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
