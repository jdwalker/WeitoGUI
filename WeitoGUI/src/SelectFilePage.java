import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;


public class SelectFilePage extends WizardPage {
	private Composite composite_1;
	private FormData fd_composite_1;
	private Composite composite_2;
	private FormData fd_composite_2;
	private Label lblSelectKeywords;
	private Table table;
	private Composite composite_4;
	private FormData fd_composite_4;

	/**
	 * Create the wizard.
	 */
	public SelectFilePage() {
		super("selectFiles");
		setTitle("New Analysis Run");
		setDescription("Select the files and styles below");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new FormLayout());
		{
			composite_1 = new Composite(container, SWT.NONE);
			{
				fd_composite_1 = new FormData();
				fd_composite_1.right = new FormAttachment(100, -1);
				fd_composite_1.left = new FormAttachment(0);
				fd_composite_1.top = new FormAttachment(0, 10);
				fd_composite_1.bottom = new FormAttachment(0, 35);
				composite_1.setLayoutData(fd_composite_1);
			}
			{
				ComboViewer comboViewer = new ComboViewer(composite_1, SWT.NONE);
				Combo combo = comboViewer.getCombo();
				combo.setBounds(167, 2, 330, 23);
			}
			{
				Button button = new Button(composite_1, SWT.NONE);
				button.setText("&Edit Styles");
				button.setBounds(503, 0, 143, 25);
			}
			{
				Label label = new Label(composite_1, SWT.NONE);
				label.setText("Select Style:");
				label.setBounds(0, 5, 62, 15);
			}
		}
		{
			composite_2 = new Composite(container, SWT.NONE);
			{
				fd_composite_2 = new FormData();
				fd_composite_2.bottom = new FormAttachment(composite_1, 105, SWT.BOTTOM);
				fd_composite_2.top = new FormAttachment(composite_1, 6);
				fd_composite_2.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
				fd_composite_2.left = new FormAttachment(0);
				composite_2.setLayoutData(fd_composite_2);
			}
			{
				Button btnselectFiles = new Button(composite_2, SWT.NONE);
				btnselectFiles.setText("&Add File(s)");
				btnselectFiles.setBounds(503, 6, 143, 25);
			}
			{
				Label label = new Label(composite_2, SWT.NONE);
				label.setText("Select files or directory of files:");
				label.setBounds(0, 5, 160, 15);
			}
			{
				Button btnSelectDirectory = new Button(composite_2, SWT.NONE);
				btnSelectDirectory.setBounds(504, 33, 142, 25);
				btnSelectDirectory.setText("Add &Directory");
			}
			{
				ListViewer listViewer = new ListViewer(composite_2, SWT.BORDER | SWT.V_SCROLL);
				List list = listViewer.getList();
				list.setBounds(166, 0, 331, 89);
			}
		}
		{
			Composite composite = new Composite(container, SWT.NONE);
			{
				FormData fd_composite = new FormData();
				fd_composite.bottom = new FormAttachment(100, -10);
				fd_composite.top = new FormAttachment(composite_2, 6);
				fd_composite.right = new FormAttachment(100, -1);
				fd_composite.left = new FormAttachment(0);
				{
					Button btnDeleteSelections = new Button(composite_2, SWT.NONE);
					btnDeleteSelections.setBounds(503, 64, 143, 25);
					btnDeleteSelections.setText("Delete Selections");
				}
				composite.setLayout(new FormLayout());
				composite.setLayoutData(fd_composite);
			}
			{
				lblSelectKeywords = new Label(composite, SWT.NONE);
				{
					FormData fd_lblSelectKeywords = new FormData();
					fd_lblSelectKeywords.bottom = new FormAttachment(0, 20);
					fd_lblSelectKeywords.right = new FormAttachment(0, 160);
					fd_lblSelectKeywords.top = new FormAttachment(0);
					fd_lblSelectKeywords.left = new FormAttachment(0);
					lblSelectKeywords.setLayoutData(fd_lblSelectKeywords);
				}
				lblSelectKeywords.setText("Select Keywords:");
			}
			{
				composite_4 = new Composite(composite, SWT.NONE);
				TableColumnLayout tcl_composite_4 = new TableColumnLayout();
				composite_4.setLayout(tcl_composite_4);
				{
					fd_composite_4 = new FormData();
					fd_composite_4.top = new FormAttachment(0);
					fd_composite_4.right = new FormAttachment(lblSelectKeywords, 486, SWT.RIGHT);
					fd_composite_4.left = new FormAttachment(lblSelectKeywords, 6);
					composite_4.setLayoutData(fd_composite_4);
				}
				{
					TableViewer tableViewer = new TableViewer(composite_4, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
					tableViewer.setColumnProperties(new String[] {});
					table = tableViewer.getTable();
					table.setLinesVisible(true);
					{
						TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
						tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
							public Image getImage(Object element) {
								// TODO Auto-generated method stub
								return null;
							}
							public String getText(Object element) {
								// TODO Auto-generated method stub
								return element == null ? "" : element.toString();
							}
						});
						TableColumn tblclmnKeywords = tableViewerColumn.getColumn();
						tcl_composite_4.setColumnData(tblclmnKeywords, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, false));
						tblclmnKeywords.setText("Keywords");
					}
				}
			}
			{
				Composite composite_3 = new Composite(composite, SWT.NONE);
				fd_composite_4.bottom = new FormAttachment(composite_3, -6);
				{
					FormData fd_composite_3 = new FormData();
					fd_composite_3.top = new FormAttachment(100, -31);
					fd_composite_3.bottom = new FormAttachment(100);
					fd_composite_3.left = new FormAttachment(composite_4, 0, SWT.LEFT);
					fd_composite_3.right = new FormAttachment(100);
					composite_3.setLayoutData(fd_composite_3);
				}
				{
					Button btnAddNewKeyword = new Button(composite_3, SWT.NONE);
					btnAddNewKeyword.setBounds(0, 0, 123, 25);
					btnAddNewKeyword.setText("Add New Keyword");
				}
				{
					Button btnRemoveSelectedKeywords = new Button(composite_3, SWT.NONE);
					btnRemoveSelectedKeywords.setBounds(129, 0, 156, 25);
					btnRemoveSelectedKeywords.setText("Remove Selected Keywords");
				}
			}
		}

		
	}
}
