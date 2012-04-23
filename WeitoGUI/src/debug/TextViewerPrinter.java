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
		strToPrintTo.setText( strToPrintTo.getText() + string + "\n" );
	}
	
}
