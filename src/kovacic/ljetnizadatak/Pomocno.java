package kovacic.ljetnizadatak;

import javax.swing.JOptionPane;

public class Pomocno {

	// metoda koja ne dozvoljava korisniku da pogrijesi
	public static int ucitajBroj(String poruka) {
		while (true) { // beskonacno
			try { // probaj procitat korisnikov broj ("a" -> exception u catchu)
				return Integer.parseInt(JOptionPane.showInputDialog(poruka));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Krivi unos");
			}
		}
	}

	public static int ucitajBroj(String poruka, int trenutno) {
		while (true) { // beskonacno
			try { // probaj procitat korisnikov broj ("a" -> exception u catchu)
				return Integer.parseInt(JOptionPane.showInputDialog(poruka, trenutno));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Krivi unos");
			}
		}
	}

	// metoda ucitajString koja osigurava unos niza znakova
	// ne smije ostati prazno

	public static String ucitajString(String poruka) {
		String s; // jer nakon sto ucitamo korisnikov string pitamo jel poruka prazna
		while (true) {
			s = JOptionPane.showInputDialog(poruka);
			if (s.trim().isEmpty()) {
				JOptionPane.showConfirmDialog(null, "Obavezan unos");
				continue; // da preskocimo return s ako poruka je prazna
			}
			return s;
		}

	}

	public static String ucitajString(String poruka, String trenutno) {
		String s; // jer nakon sto ucitamo korisnikov string pitamo jel poruka prazna
		while (true) {
			s = JOptionPane.showInputDialog(poruka, trenutno);
			if (s.trim().isEmpty()) {
				JOptionPane.showConfirmDialog(null, "Obavezan unos");
				continue; // da preskocimo return s ako poruka je prazna
			}
			return s;
		}

	}

	public static int brojZnamenki(int broj) {
		int znamenke = 0;
		while (broj > 0) {
			broj = broj / 10;
			znamenke++;
		}
		return znamenke;
	}

	public static String vodecePraznine(int broj) {
		String praznine = "";
		while (broj > 0) {
			broj = broj / 10;
			praznine += " ";
		}
		return praznine;
	}

}
