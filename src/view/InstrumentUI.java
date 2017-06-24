package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Coordinator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class InstrumentUI extends JFrame implements ActionListener, IinstrumentView{

	
	private JPanel contentPane;
	private JTable myTable;
	private Coordinator myCoordinator;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnExit;
	private JButton btnInsert;
	private JScrollPane scrollPane;
	private static final String ACTION_COMMAND_PREVIOUS = "Previous";
	private static final String ACTION_COMMAND_NEXT 	= "Next";
	private static final String ACTION_COMMAND_EXIT	 	= "Exit";
	private static final String ACTION_COMMAND_INSERT 	= "Insert";
	private static final String ACTION_COMMAND_DELETE 	= "Delete" ;
	private static final String ACTION_COMMAND_EDIT 	= "Edit";
	private JButton btnDelete;
	private JButton btnEdit;
	
	

	// build
	public InstrumentUI(Coordinator coordinator, JTable table) {
		this.myCoordinator = coordinator;
		this.myTable = table;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addScrollPane();
		addPanelButtons();
		
		setVisible(true);
	}
	
	

	@Override
	public void addScrollPane() {
		// TODO Auto-generated method stub
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(myTable);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		
		JPanel panelSouth = new JPanel();
		btnBack = new JButton("<<");
		btnNext = new JButton(">>");
		btnExit = new JButton("Exit");
		btnInsert = new JButton("Insert");
		btnDelete = new JButton("Delete");
		btnEdit = new JButton("Edit");
		
		btnBack.setActionCommand(ACTION_COMMAND_PREVIOUS);
		btnNext.setActionCommand(ACTION_COMMAND_NEXT);
		btnExit.setActionCommand(ACTION_COMMAND_EXIT);
		btnInsert.setActionCommand(ACTION_COMMAND_INSERT);
		btnDelete.setActionCommand(ACTION_COMMAND_DELETE);
		btnEdit.setActionCommand(ACTION_COMMAND_EDIT);
		
		this.btnExit.addActionListener(this);
		this.btnBack.addActionListener(this);
		this.btnNext.addActionListener(this);
		this.btnInsert.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnEdit.addActionListener(this);
		
		panelSouth.add(btnBack);
		panelSouth.add(btnNext);
		panelSouth.add(btnInsert);
		
		
		panelSouth.add(btnEdit);
		panelSouth.add(btnDelete);
		panelSouth.add(btnExit);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		
		
	}

	// getters and setters
	public JTable getTable() {
		return myTable;
	}

	public void setTable(JTable table) {
		this.myTable = table;
	}

	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case ACTION_COMMAND_NEXT:
			myCoordinator.moveToNextInstrumentList();
			break;

		case ACTION_COMMAND_PREVIOUS:
			myCoordinator.moveToPrevInstrumentList();
			break;
			
		case ACTION_COMMAND_EXIT:
			myCoordinator.exit();
			break;
			
		case ACTION_COMMAND_INSERT:
			hideView();
			myCoordinator.insertItemEvent();
			break;
			
		case ACTION_COMMAND_DELETE:
			myCoordinator.deletetItemEvent();
			break;
			
		case ACTION_COMMAND_EDIT:
			hideView();
			myCoordinator.editItemEvent();
			break;
		default:
			break;
		}
	}

	@Override
	public void addPanelForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideView() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

}
