package es.iescelia.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import es.iescelia.dao.connection.ConexionBD;
import es.iescelia.model.*;

public class RegistroPrivacidadDAO implements DAO<RegistroPrivacidad> {

    @Override
    public Optional<RegistroPrivacidad> findById(int id) {
        String sql = "SELECT * FROM registros_privacidad WHERE id_registro = ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idRegistro = rs.getInt("id_registro");
                    String tipoDato = rs.getString("tipo_dato");
                    LocalDateTime fechaHora = rs.getTimestamp("fecha_hora").toLocalDateTime();
                    String detalleDato = rs.getString("detalle_dato");
                    NivelSensibilidad nSensibilidad = NivelSensibilidad.valueOf(rs.getString("nivel_sensibilidad"));
                    Empresa empresa = new Empresa(rs.getInt("id_empresa"));

                    if (tipoDato.equalsIgnoreCase("ACTIVIDAD")) {
                        RegistroActividad registroEncontrado = new RegistroActividad(idRegistro, fechaHora, detalleDato,
                                nSensibilidad, empresa);
                        return Optional.of(registroEncontrado);
                    } else if (tipoDato.equalsIgnoreCase("UBICACION")) {
                        RegistroUbicacion registroEncontrado = new RegistroUbicacion(idRegistro, fechaHora, detalleDato,
                                nSensibilidad, empresa);
                        return Optional.of(registroEncontrado);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Error al buscar un registro con su id: " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public List<RegistroPrivacidad> findAll() {
        List<RegistroPrivacidad> listaRegistros = new ArrayList<>();
        String sql = "SELECT r.*, e.nombre AS nombre_empresa, e.sector AS sector_empresa " +
                     "FROM registros_privacidad r " +
                     "INNER JOIN empresas e ON r.id_empresa = e.id_empresa";

        try (Connection conn = ConexionBD.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                int idRegistro = rs.getInt("id_registro");
                String tipoDato = rs.getString("tipo_dato");
                LocalDateTime fechaHora = rs.getTimestamp("fecha_hora").toLocalDateTime();
                String detalleDato = rs.getString("detalle_dato");
                NivelSensibilidad nSensibilidad = NivelSensibilidad.valueOf(rs.getString("nivel_sensibilidad"));
                Empresa empresa = new Empresa(rs.getInt("id_empresa"));

                // Empresa empresa = new Empresa(rs.getInt("id_empresa"), rs.getString("nombre"), rs.getString("sector") );
                // Empresa empresa = new Empresa(rs.getInt("id_empresa"), "Desconocido", "Desconocido");

                if (tipoDato.equalsIgnoreCase("ACTIVIDAD")) {
                    RegistroActividad registroAct = new RegistroActividad(idRegistro, fechaHora, detalleDato,
                            nSensibilidad, empresa);
                    listaRegistros.add(registroAct);
                } else if (tipoDato.equalsIgnoreCase("UBICACION")) {
                    RegistroUbicacion registroUbi = new RegistroUbicacion(idRegistro, fechaHora, detalleDato,
                            nSensibilidad, empresa);
                    listaRegistros.add(registroUbi);
                }

            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar todos los datos en la BD: " + e.getMessage());
        }

        return listaRegistros;

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
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
         // Averiguamos de qué tipo es para la primera columna
        String tipoDato = "";
        if (entity instanceof RegistroActividad) {
            tipoDato = "ACTIVIDAD";
        } else if(entity instanceof RegistroUbicacion){
            tipoDato = "UBICACION";   
        }

         String sql = "UPDATE registros_privacidad SET tipo_dato = ?, fecha_hora = ?, detalle_dato = ?, nivel_sensibilidad = ?, id_empresa = ? WHERE id_registro = ?";

         try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, tipoDato);
                    pstmt.setObject(2, entity.getFechaHora());
                    pstmt.setString(3, entity.getDetalleDato());
                    pstmt.setString(4, entity.getNivelSensibilidad().name());
                    pstmt.setInt(5, entity.getEmpresa().getId());
                    pstmt.setInt(6, entity.getIdRegistro());

                    pstmt.executeUpdate();
                    System.out.println("Registro actualizado correctamente  en la BD.");
            
         } catch (SQLException e) {
            System.err.println("Error al actualizar un registro: " + e.getMessage());
         }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM registros_privacidad WHERE id_registro = ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Registro borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar un registro: " + e.getMessage());
        }
    }

}
