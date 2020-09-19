package kovacic.ljetnizadatak;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Start {

	private List<Student> studenti;

	public Start() {
		studenti = new ArrayList<Student>();
		izbornik();

	}

	private void izbornik() {
		System.out.println(" * * * STUDENTI * * * ");
		System.out.println(" 1. Poveznica na Era dijagram ");
		System.out.println(" 2. Poveznica na kod ");
		System.out.println(" 3. Unos novog studenta ");
		System.out.println(" 4. Pregled studenata ");
		System.out.println(" 5. Promjena studenta ");
		System.out.println(" 6. Brisanje studenta ");
		System.out.println(" 7. IZLAZ ");
		System.out.println(" * * * * * * * * * * * ");
		odrediAkciju();
		Baza.zatvoriVezu();
	}

	private void odrediAkciju() {
		int akcija = Pomocno.ucitajBroj("Odaberite akciju");
		switch (akcija) {
		case 1:
			otvoriEraDijagram();
			break;
		case 2:
			otvoriGitKod();
			break;
		case 3:
			unosNovogStudenta();
			break;
		case 4:
			pregledStudenata();
			break;
		case 5:
			promjenaStudenta();
			break;
		case 6:
			brisanjeStudenta();
			break;
		case 7:
			System.out.println("Bye");
			return;

		default:
			System.out.println("Nepostojeća akcija");
		}
		izbornik();
	}

	private void otvoriGitKod() {

	}

	private void otvoriEraDijagram() {

	}

	private void pregledStudenata() {
		System.out.println(" ### STUDENTI U SUSTAVU ### ");
		List<Student> studenti = CRUDStudent.read();
		/*
		 * String redniBroj; for (int i = 0; i < studenti.size(); i++) { redniBroj =
		 * Pomocno.vodecePraznine(studenti.size() + (i + 1)); redniBroj =
		 * redniBroj.substring(redniBroj.length() -
		 * Pomocno.brojZnamenki(studenti.size())); System.out.println(redniBroj + ". " +
		 * studenti.get(i)); }
		 */

		int i = 1;
		for (Student student : studenti) {
			System.out.print(i++ + ". ");
			System.out.println(student);
		}

		// CRUDStudent.read().forEach(student -> System.out.println(student));

	}

	private void brisanjeStudenta() {
		System.out.println(" ### BRISANJE STUDENTA ###");
		/*pregledStudenata();

		int redniBroj = Pomocno.ucitajBroj("Redni broj studenta kojeg želite obrisati:");
		int index = redniBroj - 1;

		if (Pomocno.ucitajBroj("1 za brisanje " + studenti.get(index) + ", ostalo za odustati") != 1) {
			return;
		}

		studenti.remove(index);*/
		
		Student student = odaberiStudenta(("Unesi redni broj osobe koju želite brisati"));
		if (student == null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			return;
		}
		CRUDStudent.delete(student.getSifra());
	}

	private void promjenaStudenta() {
		System.out.println(" ### PROMJENA PODATAKA STUDENTA ###");
		Student student = odaberiStudenta(("Unesi redni broj osobe koju želite mijenjati"));
		if (student == null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			return;
		}
		student.setIme(Pomocno.ucitajString("Promjeni ime", student.getIme()));
		student.setPrezime(Pomocno.ucitajString("Promjeni prezime", student.getPrezime()));
		student.setJmbag(Pomocno.ucitajString("Promjeni JMBAG", student.getJmbag()));
		CRUDStudent.update(student);
	// int index = redniBroj - 1;

	// promjenaPodatakaStudenta(studenti.get(index));

	}
	
	private Student odaberiStudenta(String poruka) {
		pregledStudenata();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDStudent.getStudent(redniBroj);
	}


	/*
	 * private void promjenaPodatakaStudenta(Student student) {
	 * 
	 * student.setIme(Pomocno.ucitajString("Promijeni ime", student.getIme()));
	 * student.setPrezime(Pomocno.ucitajString("Promijeni prezime",
	 * student.getPrezime()));
	 * 
	 * }
	 */

	
	/*
	 * private void unosNovogStudenta() { 
	 * Student student = new Student();
	 * student.setIme(Pomocno.ucitajString("Unesi ime"));
	 * student.setPrezime(Pomocno.ucitajString("Unesi prezime")); // jos koda
	 * 
	 * studenti.add(student); System.out.println("Student/ica " + student +
	 * " uspješno unesen/a!");
	 * 
	 * }
	 */
	
	private void unosNovogStudenta() {
		CRUDStudent.create(new Student(1, 
				Pomocno.ucitajString("Unesi ime"), 
				Pomocno.ucitajString("Unesi prezime"),
				Pomocno.ucitajString("Unesi JMBAG")));
	}

	public static void main(String[] args) {
		new Start();

	}

}
