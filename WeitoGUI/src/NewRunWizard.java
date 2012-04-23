import org.eclipse.jface.wizard.Wizard;


public class NewRunWizard extends Wizard {

	public NewRunWizard() {
		setWindowTitle("Run Pages");
	}

	@Override
	public void addPages() {
		addPage(new SelectFilePage());
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
