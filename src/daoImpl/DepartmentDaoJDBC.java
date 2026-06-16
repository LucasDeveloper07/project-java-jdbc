package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import db.DB;
import db.DbException;
import entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn = null;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    public void insert(Department department) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO department "
                + "(Name) "
                + "VALUES "
                + "(?)",
                Statement.RETURN_GENERATED_KEYS);

            st.setString(1, department.getName());

            int rowsUpdate = st.executeUpdate();

            if (rowsUpdate > 0) {
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()) {
                    department.setId(rs.getInt(1));
                }

                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado! Nenhuma linha foi atualizada.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }
    
    public void update(Department department) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE department "
                + "SET Name = ? "
                + "WHERE Id = ?");

            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            int rowsUpdate = st.executeUpdate();

            if (rowsUpdate == 0) {
                throw new DbException("Erro inesperado! Nenhuma linha foi atualizada.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    public void deleteById(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM department "
                + "WHERE Id = ?");

            st.setInt(1, id);

            int rowsUpdate = st.executeUpdate();

            if (rowsUpdate == 0) {
                throw new DbException("Erro inesperado! ID inexistente.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    public Department findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department "
                + "WHERE Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Department dept = createDepartment(rs);
                return dept;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department "
                + "ORDER BY Name");

            rs = st.executeQuery();

            List<Department> allDepartments = new ArrayList<>();

            while (rs.next()) {
                Department dept = createDepartment(rs);
                allDepartments.add(dept);
            }

            return allDepartments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Department createDepartment(ResultSet rs) throws SQLException {
        Department dept = new Department();

        dept.setId(rs.getInt("Id"));
        dept.setName(rs.getString("Name"));

        return dept;
    }
}
