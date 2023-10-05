
package DAO;

import java.sql.DriverManager;
import java.sql.*;
import model.*;

/**
 *
 * @author jeremie
 */
public class PatientDao {
    // Global Variable Declaration
    private String db_Url = "jdbc:postgresql://localhost:5432/thursday_evening";
    private String username = "jeremie_java";
    private String passwd = "java2023";

    // default Contructor
    public PatientDao() {
    }

    // CRUD Operations
    public String createPatient(Patient patientObj) {
        try {
            // Create Connection
            Connection con = DriverManager.getConnection(db_Url, username, passwd);
            // create statement
            Statement st = con.createStatement();
            // execute Statemetn
            String sql = "insert into patient(patient_id,patient_names) "
                    + "values(" + patientObj.getPatientId() + ",'" + patientObj.getPatientNames() + "')";
            int rowAffected = st.executeUpdate(sql);
            con.close();
            if (rowAffected >= 1) {
                // con.close();
                return "Data Saved!";
            } else {
                // con.close();
                return "Data Not Saved!";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Server Error";
        }
        // return "";
    }

    public String createPatientPrepared(Patient patientObj) {
        try {
            // Create Connection
            Connection con = DriverManager.getConnection(db_Url, username, passwd);
            String sql = "insert into patient (patient_id,patient_names) "
                    + "values(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, patientObj.getPatientId());
            pst.setString(2, patientObj.getPatientNames());
            int rowAffected = pst.executeUpdate();
            con.close();
            if (rowAffected >= 1) {
                // con.close();
                return "Data Saved!";
            } else {
                // con.close();
                return "Data Not Saved!";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Server Error";
        }
        // return "";
    }

}
