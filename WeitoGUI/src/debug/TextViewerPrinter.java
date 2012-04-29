package debug;

import org.eclipse.swt.custom.StyledText;

public class TextViewerPrinter extends Printer {
	
	private StyledText strToPrintTo;
	
	/**
	 * 
	 */
	public TextViewerPrinter(StyledText strToPrintTo) {
		super();
		this.strToPrintTo = strToPrintTo;
	}

	@Override
	public void println(String string) {
		print(string + "\n");
	}

	@Override
	public void print(String string) {
		strToPrintTo.setText( strToPrintTo.getText() + string );
	}

	@Override
	public void clear() {
		strToPrintTo.setText("");
	}
	
}
