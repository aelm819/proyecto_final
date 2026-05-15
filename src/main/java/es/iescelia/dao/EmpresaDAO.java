package es.iescelia.dao;

import java.sql.*;
import java.util.*;

import es.iescelia.model.*;
import es.iescelia.util.*;;

public class EmpresaDAO implements DAO<Empresa> {

    @Override
    public Optional<Empresa> findById(int id) {

        String sql = "SELECT id_empresa, nombre, sector FROM empresas WHERE id_empresa = ?";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    Empresa empresaEncontrada = new Empresa(
                            rs.getInt("id_empresa"),
                            rs.getString("nombre"),
                            rs.getString("sector"));
                    return Optional.of(empresaEncontrada);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar la empresa por su id: " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public List<Empresa> findAll() {

        List<Empresa> listaEmpresas = new ArrayList<>();

        String sql = "SELECT id_empresa, nombre, sector FROM empresas";

        try (Connection conn = ConexionBD.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("sector"));

                listaEmpresas.add(empresa);
            }

        } catch (SQLException e) {
            System.err.println("Error al recuperar las empresas: " + e.getMessage());
        }

        return listaEmpresas;
    }

    @Override
    public void insert(Empresa entity) {

        String sql = "INSERT INTO empresas (nombre, sector) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getSector());

            pstmt.executeUpdate();
            System.out.println("Empresa insertada correctamente en la BD.");

        } catch (SQLException e) {
            System.err.println("Error al insertar la empresa: " + e.getMessage());
        }
    }

    @Override
    public void update(Empresa entity) {
         
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
