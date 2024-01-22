package Dao;

import Core.Db;
import Entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection con;
    private final BrandDao brandDao = new BrandDao();

    // Constructor
    public ModelDao() {
        this.con = Db.getInstance(); // Get a database connection instance
    }

    // Retrieve a model by its ID
    public Model getById(int id) {
        Model obj = null;
        String query = "SELECT * FROM public.model WHERE (model_id) = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Retrieve all models from the database
    public ArrayList<Model> findAll() {
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id");
    }

    // Retrieve models by brand ID
    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    }

    // Save a new model to the database
    public boolean save(Model model) {
        String query = "INSERT INTO public.model " +
                "(" +
                "model_brand_id," +
                "model_name," +
                "model_type," +
                "model_year," +
                "model_fuel," +
                "model_gear" +
                ")" +
                "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, model.getBrand_id());
            ps.setString(2, model.getName());
            ps.setString(3, model.getType().toString());
            ps.setString(4, model.getYear());
            ps.setString(5, model.getFuel().toString());
            ps.setString(6, model.getGear().toString());
            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Update an existing model in the database
    public boolean update(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ? , " +
                "model_name = ? , " +
                "model_type = ? , " +
                "model_year = ? , " +
                "model_fuel = ? , " +
                "model_gear = ? " +
                "WHERE model_id = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, model.getBrand_id());
            ps.setString(2, model.getName());
            ps.setString(3, model.getType().toString());
            ps.setString(4, model.getYear());
            ps.setString(5, model.getFuel().toString());
            ps.setString(6, model.getGear().toString());
            ps.setInt(7, model.getId());
            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Delete a model from the database by its ID
    public boolean delete(int id) {
        String query = "DELETE FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Retrieve models based on a custom query
    public ArrayList<Model> selectByQuery(String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                modelList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    // Map the ResultSet to a Model object
    public Model match(ResultSet rs) throws SQLException {
        Model model = new Model();
        model.setId(rs.getInt("model_id"));
        model.setName(rs.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(rs.getString("model_gear")));
        model.setType(Model.Type.valueOf(rs.getString("model_type")));
        model.setYear(rs.getString("model_year"));
        model.setBrand(this.brandDao.getById(rs.getInt("model_brand_id")));
        model.setBrand_id(rs.getInt("model_brand_id"));
        return model;
    }
}
