package library;

public class DVD extends Item {
	private String director;
	private int duration;

	public DVD(String title, int itemID, boolean isCheckedOut, String director, int duration) {
		super(title, itemID, isCheckedOut);
		this.director = director;
		this.duration = duration;
	}

	@Override
	public String displayInfo() {
		return "The DVD " + itemID + " whith title " + title + ", with director " + director + " and duration: "
				+ duration + "min, has a status of been cheaked out: " + isCheckedOut + ".";
	}

}
