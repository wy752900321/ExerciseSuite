package org.kettlesolutions.plugin.step.helloworld;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.pentaho.di.core.Const;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStepMeta;
import org.pentaho.di.trans.step.StepDialogInterface;
import org.pentaho.di.ui.core.widget.TextVar;
import org.pentaho.di.ui.trans.step.BaseStepDialog;

public class HelloworldStepDialog extends BaseStepDialog implements
		StepDialogInterface {

	private static Class<?> PKG = HelloworldStepMeta.class; // for i18n
															// purposes, needed
															// by Translator2!!
															// $NON-NLS-1$

	private HelloworldStepMeta input;

	private TextVar wFieldname;

	public HelloworldStepDialog(Shell parent, Object baseStepMeta,
			TransMeta transMeta, String stepname) {
		//初始化元数据对象以及步骤对话框的父类
		super(parent, (BaseStepMeta) baseStepMeta, transMeta, stepname);
		input = (HelloworldStepMeta) baseStepMeta;
	}

	public String open() {
		Shell parent = getParent();
		Display display = parent.getDisplay();

		shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MIN
				| SWT.MAX);
		props.setLook(shell);
		setShellImage(shell, input);

		ModifyListener lsMod = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				input.setChanged();
			}
		};
		changed = input.hasChanged();

		FormLayout formLayout = new FormLayout();
		formLayout.marginWidth = Const.FORM_MARGIN;
		formLayout.marginHeight = Const.FORM_MARGIN;

		shell.setLayout(formLayout);
		shell.setText(BaseMessages.getString(PKG,
				"HelloworldDialog.Shell.Title")); //$NON-NLS-1$
		
		//所有控件的右侧使用一个自定义的百分对对齐。控件之间的间距使用一个常量，常量值是4像素。
		int middle = props.getMiddlePct();
		int margin = Const.MARGIN;

		// Stepname line
		wlStepname = new Label(shell, SWT.RIGHT);
		wlStepname.setText(BaseMessages.getString(PKG,
				"HelloworldDialog.Stepname.Label")); //$NON-NLS-1$
		props.setLook(wlStepname);
		fdlStepname = new FormData();
		fdlStepname.left = new FormAttachment(0, 0);
		fdlStepname.right = new FormAttachment(middle, -margin);
		fdlStepname.top = new FormAttachment(0, margin);
		wlStepname.setLayoutData(fdlStepname);
		wStepname = new Text(shell, SWT.SINGLE | SWT.LEFT | SWT.BORDER);
		wStepname.setText(stepname);
		props.setLook(wStepname);
		wStepname.addModifyListener(lsMod);
		fdStepname = new FormData();
		fdStepname.left = new FormAttachment(middle, 0);
		fdStepname.top = new FormAttachment(0, margin);
		fdStepname.right = new FormAttachment(100, 0);
		wStepname.setLayoutData(fdStepname);
		Control lastControl = wStepname;

		// Fieldname line
		//创建一个新的标签控件，控件里文本靠右对齐
		Label wlFieldname = new Label(shell, SWT.RIGHT);
		wlFieldname.setText(BaseMessages.getString(PKG,
				"HelloworldDialog.Fieldname.Label")); //$NON-NLS-1$
		//下面一行为控件设置用户定义的背景色和字体
		props.setLook(wlFieldname);
		FormData fdlFieldname = new FormData();
		fdlFieldname.left = new FormAttachment(0, 0);
		fdlFieldname.right = new FormAttachment(middle, -margin);
		fdlFieldname.top = new FormAttachment(lastControl, margin);
		wlFieldname.setLayoutData(fdlFieldname);
		wFieldname = new TextVar(transMeta, shell, SWT.SINGLE | SWT.LEFT
				| SWT.BORDER);
		props.setLook(wFieldname);
		wFieldname.addModifyListener(lsMod);
		FormData fdFieldname = new FormData();
		fdFieldname.left = new FormAttachment(middle, 0);
		fdFieldname.top = new FormAttachment(lastControl, margin);
		fdFieldname.right = new FormAttachment(100, 0);
		wFieldname.setLayoutData(fdFieldname);
		lastControl = wFieldname;

		// Some buttons
		wOK = new Button(shell, SWT.PUSH);
		wOK.setText(BaseMessages.getString(PKG, "System.Button.OK")); //$NON-NLS-1$
		wCancel = new Button(shell, SWT.PUSH);
		wCancel.setText(BaseMessages.getString(PKG, "System.Button.Cancel")); //$NON-NLS-1$

		setButtonPositions(new Button[] { wOK, wCancel }, margin, lastControl);

		// Add listeners
		lsCancel = new Listener() {
			public void handleEvent(Event e) {
				cancel();
			}
		};
		lsOK = new Listener() {
			public void handleEvent(Event e) {
				ok();
			}
		};

		wCancel.addListener(SWT.Selection, lsCancel);
		wOK.addListener(SWT.Selection, lsOK);

		lsDef = new SelectionAdapter() {
			public void widgetDefaultSelected(SelectionEvent e) {
				ok();
			}
		};

		wStepname.addSelectionListener(lsDef);
		wFieldname.addSelectionListener(lsDef);

		// Detect X or ALT-F4 or something that kills this window...
		shell.addShellListener(new ShellAdapter() {//保证了窗口在非正常关闭时，取消用户的编辑
			public void shellClosed(ShellEvent e) {
				cancel();
			}
		});

		// Populate the data of the controls
		//下面的代码把数据从步骤的元数据对象里复制到窗口的控件里
		getData();

		// Set the shell size, based upon previous time...
		//窗口的大小和位置将根据窗口的自然属性、上次窗口大小和位置，以及显示屏的大小自动设置
		setSize();

		input.setChanged(changed);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return stepname;
	}

	/**
	 * Copy information from the meta-data input to the dialog fields.
	 */
	public void getData() {
		wStepname.selectAll();
		//为了防止用户向控件里输入空值，Kettle提供了一个静态方法来检查宿舍，Const.NVL()
		wFieldname.setText(Const.NVL(input.getFieldName(), ""));
	}

	private void cancel() {
		stepname = null;
		input.setChanged(changed);
		dispose();
	}
	//单击OK把控件里用户输入的数据都写入到步骤的元数据对象中。
	private void ok() {
		if (Const.isEmpty(wStepname.getText()))
			return;

		stepname = wStepname.getText(); // return value

		input.setFieldName(wFieldname.getText());

		dispose();
	}

}
