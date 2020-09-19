package kovacic.ljetnizadatak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baza {

	private static Connection veza;

	public static Connection getVeza() {
		if (veza == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				veza = DriverManager.getConnection(
						// javadatabase connectivity/ ime proizvodaca baze // ip adresa servera / ime
						// baze na koju se spajas
						"jdbc:mariadb://localhost/izostanciferit", "edunova", "edunova");
			} catch (ClassNotFoundException | SQLException e) {

			}
		}
		return veza;
	}

	public static void zatvoriVezu() {
		try {
			veza.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
