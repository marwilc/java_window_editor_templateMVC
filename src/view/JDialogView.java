package view;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.sun.javafx.tk.Toolkit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;

public class JDialogView extends JDialog implements ActionListener,IinstrumentView{
	

	private JButton btnAcept;
	public JDialogView(String message) {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		setResizable(false);
		setBounds(500, 100, 400, 200);
		
		addPanelButtons();
		addPanelMessages(message);
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	
		
	}
	private void addPanelMessages(String message) {
		// TODO Auto-generated method stub
		JPanel panelMessage = new JPanel();
		panelMessage.setAlignmentX(Component.RIGHT_ALIGNMENT);
		getContentPane().add(panelMessage, BorderLayout.CENTER);
		FlowLayout fl_panelMessage = new FlowLayout(FlowLayout.CENTER, 5, 50);
		panelMessage.setLayout(fl_panelMessage);
		
		JLabel lblMessage = new JLabel(message);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panelMessage.add(lblMessage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAcept){
			this.dispose();
		}
	}
	@Override
	public void addPanelForm() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addPanelButtons() {
		// TODO Auto-generated method stub
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		btnAcept = new JButton("Acept");
		btnAcept.addActionListener(this);
		panelButtons.add(btnAcept);
		
	}
	@Override
	public void addScrollPane() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hideView() {
		// TODO Auto-generated method stub
		
	}
	
}
