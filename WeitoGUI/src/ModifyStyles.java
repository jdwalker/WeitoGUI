import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import swing2swt.layout.BorderLayout;


public class ModifyStyles extends WizardPage {
	private Table table;

	/**
	 * Create the wizard.
	 */
	public ModifyStyles() {
		super("wizardPage");
		setTitle("Modify Styles");
		setDescription("Allows you to choose, create and modify new styles");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			Composite composite = new Composite(container, SWT.NONE);
			composite.setLayout(new BorderLayout(0, 0));
			{
				TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
				table = tableViewer.getTable();
				table.setLayoutData(BorderLayout.CENTER);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
					TableColumn tblclmnStyleName = tableViewerColumn.getColumn();
					tblclmnStyleName.setWidth(100);
					tblclmnStyleName.setText("Style Name");
				}
				{
					TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
					TableColumn tblclmnDrlFilesLocation = tableViewerColumn.getColumn();
					tblclmnDrlFilesLocation.setWidth(460);
					tblclmnDrlFilesLocation.setText("DRL file(s) location");
				}
			}
			{
				Composite composite_1 = new Composite(composite, SWT.NONE);
				composite_1.setLayoutData(BorderLayout.SOUTH);
				composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
				{
					Button addBtn = new Button(composite_1, SWT.NONE);
					addBtn.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
						}
					});
					addBtn.setText("&Add Style");
				}
				{
					Button removeBtn = new Button(composite_1, SWT.NONE);
					removeBtn.setText("&Remove Style");
				}
				{
					Button btnbrowseForFiles = new Button(composite_1, SWT.NONE);
					btnbrowseForFiles.setText("&Browse for Files");
				}
			}
		}
	}
}
