package Business;

import Core.Helper;
import Dao.BrandDao;
import Entity.Brand;
import Entity.Model;

import java.util.ArrayList;

public class BrandManager {

    // DAO for Brand operations
    private final BrandDao brandDao;

    // Manager for Model operations
    private final ModelManager modelManager;

    // Constructor to initialize dependencies
    public BrandManager() {
        this.modelManager = new ModelManager();
        this.brandDao = new BrandDao();
    }

    // Get brand information for table display
    public ArrayList<Object[]> getForTable(int size) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for (Brand brand : this.findAll()) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getId();
            rowObject[i++] = brand.getName();
            brandRowList.add(rowObject);
        }
        return brandRowList;
    }

    // Retrieve all brands
    public ArrayList<Brand> findAll() {
        return this.brandDao.findAll();
    }

    // Save a new brand
    public boolean save(Brand brand) {
        // Check if the brand has an ID, should be null for a new brand
        if (brand.getId() != 0) {
            Helper.showMessage("Error: Brand ID should be null for a new brand.");
        }
        return this.brandDao.save(brand);
    }

    // Retrieve a brand by its ID
    public Brand getById(int id) {
        return this.brandDao.getById(id);
    }

    // Update an existing brand
    public boolean update(Brand brand) {
        // Check if the brand exists before updating
        if (this.getById(brand.getId()) == null) {
            Helper.showMessage("Error: Brand not found for update.");
        }
        return this.brandDao.update(brand);
    }

    // Delete a brand by its ID
    public boolean delete(int id) {
        // Check if the brand exists before deleting
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID: Brand not found for deletion.");
            return false;
        }

        // Delete associated models before deleting the brand
        for (Model model : modelManager.getByListBrandId(id)) {
            this.modelManager.delete(model.getId());
        }

        return this.brandDao.delete(id);
    }
}
