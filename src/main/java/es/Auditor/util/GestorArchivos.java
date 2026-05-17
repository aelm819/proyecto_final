package es.auditor.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import es.auditor.dao.*;
import es.auditor.model.*;

public class GestorArchivos {
    private DAO<RegistroPrivacidad> registroDAO = new RegistroDAO();

    public void importarDatos(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipo_dato = partes[0];
                LocalDateTime fecha_hora = LocalDateTime.parse(partes[1], formatter);
                String detalle_dato = partes[2];
                NivelSensibilidad nSensibilidad = NivelSensibilidad.valueOf(partes[3]);
                Empresa empresa = new Empresa(Integer.parseInt(partes[4]));

                if (tipo_dato.equalsIgnoreCase("ACTIVIDAD")){
                 RegistroActividad rActividad = new RegistroActividad(0, fecha_hora, detalle_dato, nSensibilidad, empresa);   
                 registroDAO.insert(rActividad);
                } else if (tipo_dato.equalsIgnoreCase("UBICACION")) {
                    RegistroUbicacion rUbicacion = new RegistroUbicacion(0, fecha_hora, detalle_dato, nSensibilidad, empresa);   
                    registroDAO.insert(rUbicacion);
                }

            }
            

        } catch (IOException e) {
             System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
