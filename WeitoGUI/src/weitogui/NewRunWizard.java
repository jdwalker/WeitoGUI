package weitogui;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.Wizard;

import debug.Debug;
import debug.Debug.DebugMode;
import debug.Printer;
import drools.AlgorithmContents;
import drools.AlgorithmContentsFactory;

import weito.Backend;
import weito.RunPapersParameter;


public class NewRunWizard extends Wizard {

	private SelectFilePage page;

	public NewRunWizard() {
		setWindowTitle("Run Pages");
		page = new SelectFilePage();
	}

	@Override
	public void addPages() {
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		try {
			Debug.setMode(EnumSet.of(DebugMode.FEATURE));
			if(page.getBtnDebug().getSelection()) {
				Debug.setMode(EnumSet.of(DebugMode.FEATURE, DebugMode.FORMAT));
			}
			
			AlgorithmContentsFactory factory = new AlgorithmContentsFactory();
			List<AlgorithmContents> contents = new ArrayList<AlgorithmContents>();
			contents.add( factory.forRFfile( "formatalgorithm.rf" ) );
			contents.add( factory.forRFfile( "categoryalgorithm.rf" ) );
			
			String masterStyleFilePath = StylesData.getInstance().getMasterStyleFilePath();
			if(masterStyleFilePath == "") {
				throw new Exception("Master Style File Path Empty!");
			}
			contents.add(factory.forDRLfile(masterStyleFilePath));
			
			int selectedStyleIndex = page.getComboViewer().getCombo().getSelectionIndex();
			String selectedStyleFilePath = StylesData.getInstance().getStyles().get(selectedStyleIndex).getFilePath();
			if(selectedStyleFilePath == "") {
				throw new Exception("Selected Style File Path Empty!");
			}
			contents.add(factory.forDRLfile(selectedStyleFilePath));
			
			String selectionFilePath = StylesData.getInstance().getMasterSelection();
			if(selectedStyleFilePath == "") {
				throw new Exception("Need a File Path For the Selection Algorithm!");
			} else if(selectedStyleFilePath.endsWith(".drt") || selectedStyleFilePath.endsWith(".DRT")) {
				String xlsFilePath = StylesData.getInstance().getExcelSelection();
				contents.add(factory.forDRTfile(selectedStyleFilePath, xlsFilePath ));
			} else {
				contents.add(factory.forDRLfile(selectionFilePath));
			}
			
			if( Debug.getMode().contains(DebugMode.DROOLSSTAGEENTER) )  contents.add( factory.forDRLlocalfile("debug.drl") );
	
			RunPapersParameter.getInstance().getDrlLocs().clear();
			RunPapersParameter.getInstance().getDrlLocs().addAll(contents);
			Printer.getInstance().clear();
			Backend.runPapers(RunPapersParameter.getInstance());
		} catch (Exception e) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			e.printStackTrace(ps);
			e.printStackTrace();
			ErrorDialog.openError(getShell(), e.getLocalizedMessage(), e.getLocalizedMessage(), new Status(IStatus.ERROR, "Error", 0,
	            baos.toString(), null));
	}
		return true;
	}

}
