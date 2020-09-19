package kovacic.ljetnizadatak;

public class Student {

	private int sifra;
	private String ime;
	private String prezime;
	private String jmbag;

	public Student(int sifra, String ime, String prezime, String jmbag) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbag = jmbag;
	}

	public Student() {

	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbag() {
		return jmbag;
	}

	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime);
		sb.append(" ");
		sb.append(prezime);
		return sb.toString();
	}

	/*
	 * public String toString() { return prezime + " " + ime; }
	 */

}
