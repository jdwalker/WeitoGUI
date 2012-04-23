import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class SelectFilePage extends WizardPage {
	private Label lblSelectStyle;
	private Button Browse;
	private Combo combo;
	private FormData fd_combo;
	private FormData fd_lblSelectStyle;
	private FormData fd_Browse;
	private Label lblSelectFilesOr;
	private Text text;

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
			Browse = new Button(container, SWT.NONE);
			{
				fd_Browse = new FormData();
				fd_Browse.top = new FormAttachment(0, 10);
				fd_Browse.right = new FormAttachment(100, -10);
				Browse.setLayoutData(fd_Browse);
			}
			Browse.setText("&Browse");
		}
		{
			lblSelectStyle = new Label(container, SWT.NONE);
			{
				fd_lblSelectStyle = new FormData();
				lblSelectStyle.setLayoutData(fd_lblSelectStyle);
			}
			lblSelectStyle.setText("Select Style:");
		}
		{
			ComboViewer comboViewer = new ComboViewer(container, SWT.NONE);
			combo = comboViewer.getCombo();
			fd_lblSelectStyle.top = new FormAttachment(combo, 3, SWT.TOP);
			{
				fd_combo = new FormData();
				fd_combo.bottom = new FormAttachment(100, -66);
				fd_combo.top = new FormAttachment(0, 50);
				fd_combo.left = new FormAttachment(lblSelectStyle, 104);
				combo.setLayoutData(fd_combo);
			}
		}
		{
			Button btnEditStyles = new Button(container, SWT.NONE);
			fd_combo.right = new FormAttachment(btnEditStyles, -6);
			{
				FormData fd_btnEditStyles = new FormData();
				fd_btnEditStyles.top = new FormAttachment(lblSelectStyle, -5, SWT.TOP);
				fd_btnEditStyles.left = new FormAttachment(Browse, 0, SWT.LEFT);
				fd_btnEditStyles.right = new FormAttachment(Browse, 0, SWT.RIGHT);
				btnEditStyles.setLayoutData(fd_btnEditStyles);
			}
			btnEditStyles.setText("&Edit Styles");
		}
		{
			lblSelectFilesOr = new Label(container, SWT.NONE);
			fd_Browse.left = new FormAttachment(lblSelectFilesOr, 334);
			fd_lblSelectStyle.left = new FormAttachment(lblSelectFilesOr, 0, SWT.LEFT);
			{
				FormData fd_lblSelectFilesOr = new FormData();
				fd_lblSelectFilesOr.top = new FormAttachment(0, 15);
				fd_lblSelectFilesOr.left = new FormAttachment(0);
				lblSelectFilesOr.setLayoutData(fd_lblSelectFilesOr);
			}
			lblSelectFilesOr.setText("Select files or directory of files:");
		}
		{
			text = new Text(container, SWT.BORDER);
			{
				FormData fd_text = new FormData();
				fd_text.top = new FormAttachment(Browse, 2, SWT.TOP);
				fd_text.left = new FormAttachment(lblSelectFilesOr, 6);
				fd_text.right = new FormAttachment(Browse, -6);
				text.setLayoutData(fd_text);
			}
		}
	}
}
