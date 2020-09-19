package kovacic.ljetnizadatak;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDStudent {

	public static void create(Student student) {
		// ovdje unijeti u bazu
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					" insert into student " 
					+ " (ime, prezime, jmbag) "
					+ " values (?, ?, ?)"); 
			izraz.setString(1, student.getIme());
			izraz.setString(2, student.getPrezime());
			izraz.setString(3, student.getJmbag());
			
			izraz.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Student> read() {
		List<Student> studenti = new ArrayList<>();
		// ovdje treba iscitati iz baze
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement("select * from student order by prezime");
			ResultSet rs = izraz.executeQuery();
			while (rs.next()) {
				studenti.add(new Student(rs.getInt("sifra"), rs.getString("ime"), rs.getString("prezime"),
						rs.getString("jmbag")));

			}
			rs.close();
			izraz.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studenti;
	}

	public static void update(Student student) {
		// ovdje promjeniti u bazi
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"update student set "
					+ " ime = ?, "
					+ " prezime = ?, "
					+ " jmbag = ? "
					+ " where sifra = ? ");
			izraz.setString(1, student.getIme());
			izraz.setString(2, student.getPrezime());
			izraz.setString(3, student.getJmbag());
			izraz.setInt(4, student.getSifra());
			
			izraz.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void delete(int sifra) {
		// ovdje obrisati u bazi
		try {
			PreparedStatement izraz = Baza.getVeza().prepareStatement(
					"delete from osoba where sifra "
					+ " where sifra = ? ");
			
			izraz.setInt(1, sifra);
			
			izraz.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Student getStudent(int redniBroj) {
		int rb = 0;
		for (Student s : read()) {
			if(++rb == redniBroj) {
				return s;
			}
		}
		return null;
	}

}
