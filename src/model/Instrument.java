package model;

/*
 * Class model Instrument
 * marwilc
 * 
 */

public class Instrument {

	private String name;	// this is obvious name of the instrument 
	private String id;		// this is the identifier 
	private String type;	// is a type of instrument e.g: rope, wind, electric instruments etc
	private String date;	// date format is dd/mm/aaaa 

	
	// construct by default
	public Instrument() {
		super();
		this.date 	= "none";
		this.name 	= "none";
		this.id		= "none";
		this.type	= "none";
	}
	
	// builder with all fields 
	public Instrument(String name, String id, String type, String date) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.date = date;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Instrument [name=" + name + ", id=" + id + ", type=" + type + ", date=" + date + "]";
	}
	
}
