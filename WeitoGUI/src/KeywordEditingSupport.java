import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import weito.Keyword;


public class KeywordEditingSupport extends EditingSupport {

	private TableViewer viewer;

	public KeywordEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canEdit(Object arg0) {
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object arg0) {
		return new TextCellEditor(viewer.getTable());
	}

	@Override
	protected Object getValue(Object element) {
		return ((Keyword) element).toString();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Keyword) element).setKeyword( (String) value );
		viewer.refresh();
	}

}
