import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;


public class EditDRL extends Dialog {
	protected static final String[] DRL_FILTER_NAMES = {"DRL files (*.drl)"};
	protected static final String[] DRL_FILTER_EXT = {"*.drl"};
	protected static final String[] EXCEL_FILTER_NAMES = {"Excel Template File (*.xls)"};
	protected static final String[] EXCEL_FILTER_EXT = {"*.xls"};
	protected static final String[] DRT_FILTER_EXT = {"Rule files (*.drl)","Rule Template files (*.drt)"};
	protected static final String[] DRT_FILTER_NAMES = {".drl",".drt"};
	private Table StyleTable;
	private Label lblFileLocation;
	private Label AlgorithmLocationLabel;
	private Label excelFileLabel;
	private List<DRLStyle> tableStyles = new ArrayList<DRLStyle>();

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public EditDRL(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
	}
	
	

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		{
			tableStyles.addAll(StylesData.getInstance().getStyles());
			TableViewer tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
			StyleTable = tableViewer.getTable();
			StyleTable.setBounds(10, 58, 544, 238);
			StyleTable.setLinesVisible(true);
			StyleTable.setHeaderVisible(true);
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tableColumn = tableViewerColumn.getColumn();
				tableColumn.setWidth(103);
				tableColumn.setText("Style Name");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
				TableColumn tblclmnDrlFileLocation = tableViewerColumn.getColumn();
				tblclmnDrlFileLocation.setWidth(435);
				tblclmnDrlFileLocation.setText("DRL file location");
			}
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setBounds(10, 302, 62, 25);
			button.setText("&Add Style");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setText("&Remove Style");
			button.setBounds(78, 302, 83, 25);
		}
		{
			Label lblMasterStyleLocation = new Label(container, SWT.NONE);
			lblMasterStyleLocation.setBounds(10, 21, 121, 15);
			lblMasterStyleLocation.setText("Master Style Location:");
		}
		{
			lblFileLocation = new Label(container, SWT.BORDER);
			lblFileLocation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
			lblFileLocation.setBounds(133, 21, 332, 15);
			lblFileLocation.setText(StylesData.getInstance().getMasterStyle());
		}
		{
			Button btnBrowseMasterStyle = new Button(container, SWT.NONE);
			btnBrowseMasterStyle.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog openFilesDlg = new FileDialog(getShell(), SWT.SINGLE);
					openFilesDlg.setFilterNames(DRL_FILTER_NAMES);
					openFilesDlg.setFilterExtensions(DRL_FILTER_EXT);
					String fn = openFilesDlg.open();
			        if (fn != null) {
			          lblFileLocation.setText(openFilesDlg.getFileName() + openFilesDlg.getFilterPath() );			          
			        }
				}
			});
			btnBrowseMasterStyle.setBounds(479, 21, 75, 15);
			btnBrowseMasterStyle.setText("Browse");
		}
		{
			Button BrowseSelection = new Button(container, SWT.NONE);
			BrowseSelection.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog openFilesDlg = new FileDialog(getShell(), SWT.SINGLE);
					openFilesDlg.setFilterNames(DRT_FILTER_NAMES);
					openFilesDlg.setFilterExtensions(DRT_FILTER_EXT);
					String fn = openFilesDlg.open();
			        if (fn != null) {
			          AlgorithmLocationLabel.setText(openFilesDlg.getFileName() + openFilesDlg.getFilterPath() );			          
			        }
				}
			});
			BrowseSelection.setText("Browse");
			BrowseSelection.setBounds(479, 354, 75, 15);
		}
		{
			AlgorithmLocationLabel = new Label(container, SWT.BORDER);
			AlgorithmLocationLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
			AlgorithmLocationLabel.setBounds(133, 354, 332, 15);
			AlgorithmLocationLabel.setText(StylesData.getInstance().getMasterSelection());
		}
		{
			Label lblMasterSelectionAlgorithm = new Label(container, SWT.WRAP);
			lblMasterSelectionAlgorithm.setText("Master Selection Algorithm Location:");
			lblMasterSelectionAlgorithm.setBounds(11, 337, 121, 32);
		}
		{
			Label lblExcelFileIf = new Label(container, SWT.WRAP);
			lblExcelFileIf.setText("Excel file if above is template:");
			lblExcelFileIf.setBounds(11, 385, 121, 32);
		}
		{
			excelFileLabel = new Label(container, SWT.BORDER);
			excelFileLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
			excelFileLabel.setBounds(133, 402, 332, 15);
			excelFileLabel.setText(StylesData.getInstance().getExcelSelection());
		}
		{
			Button browseExcel = new Button(container, SWT.NONE);
			browseExcel.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog openFilesDlg = new FileDialog(getShell(), SWT.SINGLE);
					openFilesDlg.setFilterNames(EXCEL_FILTER_NAMES);
					openFilesDlg.setFilterExtensions(EXCEL_FILTER_EXT);
					String fn = openFilesDlg.open();
			        if (fn != null) {
			          excelFileLabel.setText(openFilesDlg.getFileName() + openFilesDlg.getFilterPath() );			          
			        }
				}
			});
			browseExcel.setText("Browse");
			browseExcel.setBounds(479, 402, 75, 15);
		}

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(575, 554);
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("DRL Files and Styles");
		super.configureShell(newShell);
	}



	@Override
	protected void okPressed() {
		StylesData.getInstance().setMasterStyle(lblFileLocation.getText());
		StylesData.getInstance().setMasterSelection(AlgorithmLocationLabel.getText());
		if(AlgorithmLocationLabel.getText().endsWith(".drt")) {
		StylesData.getInstance().setExcelSelection(excelFileLabel.getText());
		}
	}
}
