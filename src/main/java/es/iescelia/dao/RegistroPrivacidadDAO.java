package es.iescelia.dao;

import java.sql.*;
import java.util.*;

import es.iescelia.model.*;
import es.iescelia.util.*;

public class RegistroPrivacidadDAO implements DAO<RegistroPrivacidad> {

    @Override
    public Optional<RegistroPrivacidad> findById(int id) {
         // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Optional'");
    }

    @Override
    public List<RegistroPrivacidad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void insert(RegistroPrivacidad entity) {
        // Averiguamos de qué tipo es para la primera columna
        String tipoDato = "";
        if (entity instanceof RegistroUbicacion) {
            tipoDato = "UBICACIÓN";
        } else if (entity instanceof RegistroActividad) {
             tipoDato = "ACTIVIDAD";
         }

         String sql = "INSERT INTO registros_privacidad (tipo_dato, fecha_hora, detalle_dato, nivel_sensibilidad, id_empresa) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
                    pstmt.setString(1, tipoDato);
                    pstmt.setObject(2, entity.getFechaHora());
                    pstmt.setString(3, entity.getDetalleDato());
                    pstmt.setString(4, entity.getNivelSensibilidad().name());
                    pstmt.setInt(5, entity.getEmpresa().getId());

                    pstmt.executeUpdate();
                    System.out.println("Empresa insertada correctamanete en la BD.");
                
            } catch (SQLException e) {
                 System.err.println("Error al guardar datos en la BD: " + e.getMessage());
            }
    }

    @Override
    public void update(RegistroPrivacidad entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
