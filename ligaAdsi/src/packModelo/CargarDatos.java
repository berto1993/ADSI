package packModelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CargarDatos
{
	public void cargaDatos()
	{
		
	}
	
	private void cargarTemporadas()
	{
		Temporada aux;
		Connection con = (Connection) ConexionDB.GetConnection();
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select fechaIni from Temporada");
			aux = new Temporada(rs.getDate(1));
			rs = st.executeQuery("select  )
			aux.addJornada(jorn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
