package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Instrument;
import model.InstrumentList;
import view.InstrumentDetailView;
import view.InstrumentUI;
import view.JDialogView;

/*
 * class Coordinator
 * marwilc
 */
public class Coordinator {

	private static final String ERROR_DISPLAY 		= "Empty fields";
	private static final String ACTION_EDIT_ITEM	= "Edit";
	private static final String ACTION_INSERT_ITEM 	= "Insert";
	private static final String SUCCES_MENSSAGE 	= "Save succes";
	private static final String ADVERTISE_MENSSAGE 	= "No currently Items" ;
	private InstrumentList myInstrumentList;					// instance of the InstrumentList 
	private InstrumentUI myInstrumentUI;						// instance of the view
	private int myArrayIndex = 0;								// Current array index
	private InstrumentDetailView myInstrumentDetailView;		// Instance of the detailed view
	private String actionSave;									/*	
																*	Global variable to control the
																*	action of the save button 
																*	when editing or inserts a new item
																*/

	public Coordinator(){
		super();
		this.myInstrumentList 	= new InstrumentList();
		buildInstrumentList(); // build objects to the list
		initializeUI();
	}
	
	// getters and setters
	public InstrumentList getMyInstrumentList() {
		return myInstrumentList;
	}
	public void setMyInstrumentList(InstrumentList myInstrumentList) {
		this.myInstrumentList = myInstrumentList;
	}
	public InstrumentUI getMyInstrumentUI() {
		return myInstrumentUI;
	}
	public void setMyInstrumentUI(InstrumentUI myInstrumentUI) {
		this.myInstrumentUI = myInstrumentUI;
	}
	
	public int getMyArrayIndex() {
		return myArrayIndex;
	}

	public void setMyArrayIndex(int myArrayIndex) {
		this.myArrayIndex = myArrayIndex;
	}
	
	// Initialize the view
	private void initializeUI() {
		// TODO Auto-generated method stub
		JTable table = buildJtable();	// Generates a default table
		this.myInstrumentUI = new InstrumentUI(this, table);
		if(!myInstrumentList.isEmpty()){
			buildViewDetail();
		}
	}

	// Passes the data of the current item to the detail view
	private void setDataDetailView() {
		// TODO Auto-generated method stub
		
		if(!myInstrumentList.isEmpty()){
			String name 	= myInstrumentList.get(myArrayIndex).getName();
			String id		= myInstrumentList.get(myArrayIndex).getId();
			String type		= myInstrumentList.get(myArrayIndex).getType();
			String date 	= myInstrumentList.get(myArrayIndex).getDate();
		
			myInstrumentDetailView.getTextFieldName().setText(name);
			myInstrumentDetailView.getTextFieldId().setText(id);
			myInstrumentDetailView.getTextFieldType().setText(type);
			myInstrumentDetailView.getTextFieldDate().setText(date);
			myInstrumentDetailView.setVisible(true);
		}
		
		
	}

	// Initializes and populates the combobox from the detail view
	private void initializeComboBoxDate() {
		// TODO Auto-generated method stub
		
		ArrayList<String> days    = getDays();
		ArrayList<String> months  = getMonths();
		ArrayList<String> years   = getYears();
		
		fillComboBoxDay(days);
		fillComboBoxYear(years);
		fillComboBoxMonths(months);
		
	}
	// fill combobox´s
	private void fillComboBoxMonths(ArrayList<String> months) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < months.size(); i++) {
			myInstrumentDetailView.getComboBoxMonth().addItem(months.get(i));
		}
		
	}

	private void fillComboBoxYear(ArrayList<String> years) {
		// TODO Auto-generated method stub
		for (int i = 0; i < years.size(); i++) {
			myInstrumentDetailView.getComboBoxYear().addItem(years.get(i));
		}
	}

	private void fillComboBoxDay(ArrayList<String> days) {
		// TODO Auto-generated method stub
		for (int j = 0; j < days.size(); j++) {
			myInstrumentDetailView.getComboBoxDay().addItem(days.get(j));
		}
		
	}

	// Gets an array list with the years
	private ArrayList<String> getYears() {
		// TODO Auto-generated method stub
		ArrayList<String> yearsList = new ArrayList<>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 1900; i <= year; i++) {
			yearsList.add(String.valueOf(i)); 
		}
		return yearsList;
	}


	//Gets an array list with the months
	private ArrayList<String> getMonths() {
		// TODO Auto-generated method stub
		ArrayList<String> months = new ArrayList<>();
		for (int i = 1; i <= 12 ; i++) {
			months.add(String.valueOf(i)); 
		}
		return months;
	}
	
	// Gets an array list with the days
	private ArrayList<String> getDays() {
		// TODO Auto-generated method stub
		ArrayList<String> days = new ArrayList<>();
		for (int i = 1; i <= 31 ; i++) {
			days.add(String.valueOf(i)); 
		}
		return days;
	}

	// Build to list of instrument 
	public void buildInstrumentList() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // format date 
		Calendar cal = Calendar.getInstance();						// get date current
		String dateCurrent = dateFormat.format(cal.getTime());  	// build string date
		myInstrumentList = new InstrumentList();
		// TODO Auto-generated method stub
		String names[][] = 	{{"saxofon", "flauta", "clarinete", "trompeta"},
							{"guitarra", "arpa", "violin", "piano"}, 
							{"timbal", "tambor", "platillos", "bombo"}, 
							{"bajo electrico", "guitarra electrica", "teremin", "sintetizador"}};
		
		String types[]	= {"viento", "cuerda", "percusion", "electricos"};
		
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {
			
				String id = names[i][j].substring(0, 2) + types[i].substring(0, 2) + j; // build id 
				Instrument myInstrument = new Instrument(names[i][j], id, types[i], dateCurrent); 
				this.myInstrumentList.add(myInstrument); // add a new instrument
			}
			
		}
		
		
	}
	
	// build Jtable for view 
	public JTable buildJtable() {
		// TODO Auto-generated method stub
			String columnNames[] = {"Instrument"};// create names for columns 
			DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); 
			
			for (int i = 0; i < myInstrumentList.size(); i++) {
				String name = myInstrumentList.get(i).getName();
		
				Object[] data = {name};		// build object with name instrument 
				
				tableModel.addRow(data);	// add row to table model
			}
		return new JTable(tableModel);
	}

	// move to next item
	public void moveToNextInstrumentList() {
		// TODO Auto-generated method stub
		Instrument myCurrentInstrument = myInstrumentList.next(myArrayIndex);
		if(myCurrentInstrument != null){
			myArrayIndex++;
			setDataDetailView();
			
		}
	}
	// move to prev item
	public void moveToPrevInstrumentList() {
		// TODO Auto-generated method stub
		Instrument myCurrentInstrument = myInstrumentList.previous(myArrayIndex);
		if(myCurrentInstrument != null){
			myArrayIndex--;
			setDataDetailView();
		}
	}

	// exit aplication
	public void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	// insert item action
	public void insertItemEvent() {
		// TODO Auto-generated method stub
		if(myInstrumentDetailView != null){
			cleanDetailView();					// clean fields from detail view
			myInstrumentDetailView.setVisible(true);	// show view
		}else{
			buildViewDetail();					// Creates an instance of detail view if it does not exist
		}
		setEnabledCompDetailView(true);			// enable fields to edit
		actionSave = ACTION_INSERT_ITEM;
	}

	// Creates an instance to detail view
	private void buildViewDetail() {
		// TODO Auto-generated method stub
		this.myInstrumentDetailView = new InstrumentDetailView(this);
		setDataDetailView();		// Set the data to the detail screen
		initializeComboBoxDate();
	}

	// clean detail fields
	private void cleanDetailView() {
		// TODO Auto-generated method stub
		if(myInstrumentDetailView != null){
			myInstrumentDetailView.getTextFieldName().setText("");
			myInstrumentDetailView.getTextFieldId().setText("");
			myInstrumentDetailView.getTextFieldDate().setText("");
			myInstrumentDetailView.getTextFieldType().setText("");
		}
	}

	// show date in texTfield from combobos selected item
	public void displayDateToJtexfield() {
		// TODO Auto-generated method stub
		String day = myInstrumentDetailView.getComboBoxDay().getSelectedItem().toString();
		String month = myInstrumentDetailView.getComboBoxMonth().getSelectedItem().toString();
		String year = myInstrumentDetailView.getComboBoxYear().getSelectedItem().toString();
		
		myInstrumentDetailView.getTextFieldDate().setText(day + "/" + month + "/" + year);
	}

	// remove action event
	public void deletetItemEvent() {
		// TODO Auto-generated method stub
		if(!myInstrumentList.isEmpty()){
			myInstrumentList.remove(myArrayIndex);
			myInstrumentUI.getScrollPane().setViewportView(buildJtable()); // updated jtable
			
			if(myArrayIndex >= myInstrumentList.size())
				myArrayIndex--;
			
			if(!myInstrumentList.isEmpty())
				setDataDetailView();
		}
			
	}

	// set enable fields detail
	public void setEnabledCompDetailView(boolean b) {
		// TODO Auto-generated method stub

		if(myInstrumentDetailView != null){
			myInstrumentDetailView.getTextFieldId().setEditable(b);
			myInstrumentDetailView.getTextFieldName().setEditable(b);
			myInstrumentDetailView.getTextFieldType().setEditable(b);
			myInstrumentDetailView.getComboBoxDay().setEnabled(b);
			myInstrumentDetailView.getComboBoxMonth().setEnabled(b);
			myInstrumentDetailView.getComboBoxYear().setEnabled(b);
			myInstrumentDetailView.getBtnSave().setEnabled(b);
		}
	}

	// edit item event
	public void editItemEvent() {
		// TODO Auto-generated method stub
		JDialogView dialogView;
		if(!myInstrumentList.isEmpty()){
			setDataDetailView();
			setEnabledCompDetailView(true);
			myInstrumentDetailView.setVisible(true);
			actionSave = ACTION_EDIT_ITEM;
		}
		else{
			myInstrumentUI.setVisible(true);
			dialogView = new JDialogView(ADVERTISE_MENSSAGE);
		}
	}
	
	// save event 
	public void saveEvent(){
		
		displayDateToJtexfield();
		String name = myInstrumentDetailView.getTextFieldName().getText();
		String id 	= myInstrumentDetailView.getTextFieldId().getText();
		String type = myInstrumentDetailView.getTextFieldType().getText();
		String date = myInstrumentDetailView.getTextFieldDate().getText();
		
		if(!name.isEmpty() && !id.isEmpty() && !type.isEmpty() && !date.isEmpty()){ // Check If the detail fields are empty
			Instrument instrument = new Instrument(name,id,type,date);
			
			if(actionSave == ACTION_EDIT_ITEM)						// check if event insert or edit
				myInstrumentList.set(myArrayIndex, instrument);    // update item
			else
				myInstrumentList.add(instrument);					// add item to list
				
			myInstrumentUI.getScrollPane().setViewportView(buildJtable());
			myInstrumentDetailView.hideView();
			myInstrumentUI.setVisible(true);
			JDialogView myDialog = new JDialogView(SUCCES_MENSSAGE);
			
		}else{
			JDialogView myDialog = new JDialogView(ERROR_DISPLAY); // launch caution
		}
	}

	public void displayViewUI() {
		// TODO Auto-generated method stub
		myInstrumentUI.setVisible(true);
	}	
}
