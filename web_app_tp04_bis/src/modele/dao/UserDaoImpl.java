package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.domaine.User;

public class UserDaoImpl implements UserDaoInterface {

    @Override
    public User getUserById(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DBConnexion.getConnection();
            ps = conn.prepareStatement("SELECT * FROM User WHERE id = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            conn = DBConnexion.getConnection();
            ps = conn.prepareStatement("SELECT * FROM User");
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    @Override
    public void insertUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnexion.getConnection();
            ps = conn.prepareStatement("INSERT INTO User (nom, prenom, login, password) VALUES (?, ?, ?, ?)");
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnexion.getConnection();
            ps = conn.prepareStatement("UPDATE User SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?");
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnexion.getConnection();
            ps = conn.prepareStatement("DELETE FROM User WHERE id = ?");
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
