package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Coordinator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class InstrumentDetailView extends JFrame implements ActionListener, IinstrumentView{
	
	
	private JPanel contentPane;
	private Coordinator myCoordinator;
	private JTextField textFieldName;
	private JTextField textFieldType;
	private JTextField textFieldId;
	private JTextField textFieldDate;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox<String> comboBoxDay;
	private JComboBox<String> comboBoxMonth;
	private JComboBox<String> comboBoxYear;
	
	private static final String ACTION_COMMAND_SAVE 	= "Save";
	private static final String ACTION_COMMAND_CANCEL 	= "Cancel";
	
	public InstrumentDetailView(Coordinator coordinator) {
		this.myCoordinator = coordinator;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(600, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addPanelForm();
		addPanelButtons();
		setVisible(true);
		
	}

	// getters and setters
	public JTextField getTextFieldName() {
		return textFieldName;
	}


	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}


	public JTextField getTextFieldType() {
		return textFieldType;
	}


	public void setTextFieldType(JTextField textFieldType) {
		this.textFieldType = textFieldType;
	}


	public JTextField getTextFieldId() {
		return textFieldId;
	}


	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}


	public JTextField getTextFieldDate() {
		return textFieldDate;
	}


	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}

	public JComboBox<String> getComboBoxDay() {
		return comboBoxDay;
	}

	public void setComboBoxDay(JComboBox<String> comboBoxDay) {
		this.comboBoxDay = comboBoxDay;
	}

	public JComboBox<String> getComboBoxMonth() {
		return comboBoxMonth;
	}

	public void setComboBoxMonth(JComboBox<String> comboBoxMonth) {
		this.comboBoxMonth = comboBoxMonth;
	}

	public JComboBox<String> getComboBoxYear() {
		return comboBoxYear;
	}

	public void setComboBoxYear(JComboBox<String> comboBoxYear) {
		this.comboBoxYear = comboBoxYear;
	}


	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	@Override
	public void addPanelForm() {
		// TODO Auto-generated method stub
		JPanel panelForm 		= new JPanel();
		JLabel lblName 			= new JLabel("Name");
		JLabel lblType			= new JLabel("Type");
		JLabel lblId 			= new JLabel("Id");
		JLabel lblDate 			= new JLabel("Date");
		JLabel lblDay 			= new JLabel("Day");
		JLabel lblMonth 		= new JLabel("Month");
		JLabel lblYear 			= new JLabel("Year");
		textFieldName 	= new JTextField();
		textFieldType 	= new JTextField();
		textFieldId 	= new JTextField();
		textFieldDate 	= new JTextField();
		comboBoxYear 	= new JComboBox<>();
		comboBoxMonth 	= new JComboBox<>();
		comboBoxDay 	= new JComboBox<>();
		
		textFieldDate.setEditable(false);
		textFieldId.setEditable(false);
		textFieldType.setEditable(false);
		textFieldName.setEditable(false);
		comboBoxDay.setEnabled(false);
		comboBoxMonth.setEnabled(false);
		comboBoxYear.setEnabled(false);
		
		
		textFieldName.setColumns(10);
		textFieldType.setColumns(10);
		textFieldDate.setColumns(10);
		textFieldId.setColumns(10);
		// use to form layout
		panelForm.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("114px"),
				ColumnSpec.decode("28px"),
				ColumnSpec.decode("28px"),
				ColumnSpec.decode("24px"),
				ColumnSpec.decode("28px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("160px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		panelForm.add(lblName, "2, 2, left, top");
		panelForm.add(lblType, "2, 6, left, top");
		panelForm.add(lblId, "8, 6, left, top");
		panelForm.add(lblDate, "2, 10, left, top");
		panelForm.add(lblDay, "2, 14, fill, top");
		panelForm.add(lblMonth, "2, 16, left, top");
		panelForm.add(lblYear, "2, 18, default, top");
		panelForm.add(comboBoxDay, "3, 14, 2, 1, fill, default");
		panelForm.add(comboBoxMonth, "3, 16, 2, 1, fill, default");
		panelForm.add(comboBoxYear, "3, 18, 3, 1, fill, top");
		panelForm.add(textFieldName, "2, 4, 7, 1, fill, top");
		panelForm.add(textFieldType, "2, 8, 5, 1, fill, top");
		panelForm.add(textFieldId, "8, 8, fill, top");
		panelForm.add(textFieldDate, "2, 12, left, top");
		contentPane.add(panelForm, BorderLayout.CENTER);
		
		
		
	}

	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		btnCancel = new JButton("Cancel");
		btnSave = new JButton("Save");
		
		btnCancel.setActionCommand(ACTION_COMMAND_CANCEL);
		btnSave.setActionCommand(ACTION_COMMAND_SAVE);
		
		btnSave.setEnabled(false);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		
		panelButtons.add(btnSave);
		panelButtons.add(btnCancel);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
	}

	@Override
	public void addScrollPane() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		
		case ACTION_COMMAND_CANCEL:
			hideView();
			myCoordinator.setEnabledCompDetailView(false);
			myCoordinator.displayViewUI();

			break;
		
		case ACTION_COMMAND_SAVE:
			myCoordinator.saveEvent();
		
			break;

		default:
			break;
		}
		
	}

	@Override
	public void hideView() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
	
}
