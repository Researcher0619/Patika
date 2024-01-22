package Business;

import Core.Helper;
import Dao.ModelDao;
import Entity.Model;

import java.util.ArrayList;

public class ModelManager {

    // DAO for Model operations
    private final ModelDao modelDao = new ModelDao();

    // Retrieve a model by its ID
    public Model getById(int id) {
        return this.modelDao.getById(id);
    }

    // Retrieve all models
    public ArrayList<Model> findAll() {
        return this.modelDao.findAll();
    }

    // Get model information for table display
    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> modelList) {
        ArrayList<Object[]> modelObjList = new ArrayList<>();
        for (Model obj : modelList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelObjList.add(rowObject);
        }
        return modelObjList;
    }

    // Save a new model
    public boolean save(Model model) {
        // Check if the model with the same ID already exists
        if (this.getById(model.getId()) != null) {
            Helper.showMessage("Error: Model with ID " + model.getId() + " already exists.");
            return false;
        }
        return this.modelDao.save(model);
    }

    // Update an existing model
    public boolean update(Model model) {
        // Check if the model with the given ID exists before updating
        if (this.getById(model.getId()) == null) {
            Helper.showMessage("Error: Model with ID " + model.getId() + " not found for update.");
            return false;
        }
        return this.modelDao.update(model);
    }

    // Delete a model by its ID
    public boolean delete(int id) {
        // Check if the model with the given ID exists before deleting
        if (this.getById(id) == null) {
            Helper.showMessage("Error: Model with ID " + id + " not found for deletion.");
            return false;
        }
        return this.modelDao.delete(id);
    }

    // Get models by Brand ID
    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.modelDao.getByListBrandId(brandId);
    }

    // Search for models based on criteria for table display
    public ArrayList<Model> searchForTable(int brandId, Model.Fuel fuel, Model.Gear gear, Model.Type type) {
        // Base query to select models
        String select = "SELECT * FROM public.model";

        // List to store conditions for WHERE clause
        ArrayList<String> whereList = new ArrayList<>();

        // Add condition for Brand ID
        if (brandId != 0) {
            whereList.add("model_brand_id = " + brandId);
        }

        // Add conditions for Fuel, Gear, and Type
        if (fuel != null) {
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }

        if (gear != null) {
            whereList.add("model_gear = '" + gear.toString() + "'");
        }

        if (type != null) {
            whereList.add("model_type = '" + type.toString() + "'");
        }

        // Concatenate WHERE conditions
        String whereStr = String.join(" AND ", whereList);
        String query = select;

        // Add WHERE conditions to the base query
        if (whereStr.length() > 0) {
            query += " WHERE " + whereStr;
        }

        // Execute query to get a list of searched models
        return this.modelDao.selectByQuery(query);
    }
}
