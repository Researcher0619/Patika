package View;

import Business.BookManager;
import Business.BrandManager;
import Business.CarManager;
import Business.ModelManager;
import Core.ComboItem;
import Core.Helper;
import Entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JComboBox<ComboItem> cmb_s_model_brand;
    private JComboBox<Model.Type> cmb_s_model_type;
    private JComboBox<Model.Fuel> cmb_s_model_fuel;
    private JComboBox<Model.Gear> cmb_s_model_gear;
    private JButton btn_search_model;
    private JButton btn_cncl_model;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private JTable tbl_car;
    private JPanel pnl_booking;
    private JScrollPane scrl_booking;
    private JTable tbl_booking;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JComboBox<Model.Gear> cmb_booking_gear;
    private JComboBox<Model.Fuel> cmb_booking_fuel;
    private JComboBox<Model.Type> cmb_booking_type;
    private JButton btn_booking_search;
    private JButton btn_cncl_booking;
    private JPanel pnl_book;
    private JScrollPane scrl_book;
    private JTable tbl_book;
    private JComboBox<ComboItem> cmb_book_car;
    private JButton btn_book_clean;
    private JButton btn_book_srch;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private DefaultTableModel tmdl_booking = new DefaultTableModel();
    private DefaultTableModel tmdl_book = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;
    private Object[] col_model;
    private JPopupMenu car_menu;
    private JPopupMenu booking_menu;
    private Object[] col_car;
    private BookManager bookManager;
    private JPopupMenu book_menu;
    private Object[] col_book;

    public AdminView(User user) {
        this.bookManager = new BookManager();
        this.carManager = new CarManager();
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitialize(1000, 500);
        this.user = user;
        if (user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();

        loadBookTable(null);
        loadBookComponent();
        loadBookFilterCar();



    }

    private void loadComponent(){
        this.btn_logout.addActionListener(e -> {
            dispose();
            LoginView loginView = new LoginView();
        });
    }

    private void loadBookComponent() {
        tableSelectedRow(this.tbl_book);
        this.book_menu = new JPopupMenu();
        this.book_menu.add("İptal Et").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBookId = this.getTableSelectedRow(this.tbl_book, 0);
                if (this.bookManager.delete(selectBookId)) {
                    Helper.showMessage("done");
                    loadBookTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_book.setComponentPopupMenu(book_menu);

        btn_book_srch.addActionListener(e -> {
            ComboItem selectedCar = (ComboItem) this.cmb_book_car.getSelectedItem();
            int carId = 0;
            if (selectedCar != null) {
                carId = selectedCar.getKey();
            }

            ArrayList<Book> bookListBySearch = this.bookManager.searchForTable(carId);
            ArrayList<Object[]>bookRowListBySearch = this.bookManager.getForTable(this.col_book.length,bookListBySearch);
            loadBookTable(bookRowListBySearch);
        });

        btn_book_clean.addActionListener(e -> {
            loadBookFilterCar();
        });
    }

    public void loadBookTable(ArrayList<Object[]> bookList) {
        col_book = new Object[]{"ID", "Plaka", "Araç Marka", "Araç Model", "Müşteri", "Telefon", "Mail", "T.C.", "Başlangıç Tarihi", "Bitiş Tarihi", "Fiyat"};
        if (bookList == null) {
            bookList = this.bookManager.getForTable(col_book.length, this.bookManager.findAll());
        }
        createTable(this.tmdl_book, this.tbl_book, col_book, bookList);
    }

    public void loadBookFilterCar() {
        this.cmb_book_car.removeAllItems();
        for (Car obj : this.carManager.findAll()) {
            this.cmb_book_car.addItem(new ComboItem(obj.getId(), obj.getPlate()));
        }
        this.cmb_book_car.setSelectedItem(null);
    }

    private void loadBookingComponent() {
        tableSelectedRow(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Rezervasyon Yap").addActionListener(e -> {
            int selectedCarId = this.getTableSelectedRow(this.tbl_booking, 0);
            BookingView bookingView = new BookingView(
                    this.carManager.getById(selectedCarId),
                    this.fld_strt_date.getText(),
                    this.fld_fnsh_date.getText()
            );
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                    loadBookTable(null);
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);

        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );

            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length, carList);
            loadBookingTable(carBookingRow);
        });
        btn_cncl_booking.addActionListener(e -> {
            loadBookingFilter();
        });

    }

    private void loadBookingTable(ArrayList<Object[]> carlist) {
        Object[] col_booking_list = {"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carlist);
    }

    public void loadBookingFilter() {
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);
    }

    private void loadCarComponent() {
        tableSelectedRow(this.tbl_car);
        this.car_menu = new JPopupMenu();
        this.car_menu.add("Yeni").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Güncelle").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_car, 0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.delete(selectCarId)) {
                    Helper.showMessage("done");
                    loadCarTable();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_menu);
    }

    public void loadCarTable() {
        col_car = new Object[]{"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
        createTable(this.tmdl_car, this.tbl_car, col_car, carList);
    }

    private void loadModelComponent() {
        tableSelectedRow(this.tbl_model);
        this.model_menu = new JPopupMenu();
        this.model_menu.add("Yeni").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_menu.add("Güncelle").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadCarTable();
                    loadBookTable(null);
                }
            });
        });
        this.model_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.delete(selectModelId)) {
                    Helper.showMessage("done");
                    loadModelTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(model_menu);

        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );


            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);

        });

        this.btn_cncl_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);


        });
    }

    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID", "Marka", "Model Adı", "Tip", "Yıl", "Yakıt Türü", "Vites"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(this.col_model.length, this.modelManager.findAll());
        }
        createTable(tmdl_model, this.tbl_model, col_model, modelList);

    }

    public void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();

    }

    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }

    public void loadBrandTable() {
        Object[] col_brand = {"Marka ID", "Marka Adı"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);

    }

    // adminView ile sekme aracılığıyla açtığımız marka bölümü
    public void loadBrandComponent() {
        tableSelectedRow(this.tbl_brand);
        // brandManagerdan brand getirmiyoruz çünkü yeni girilecek
        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("Yeni").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();

                }
            });
        });
        this.brand_menu.add("Güncelle").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                    loadBookTable(null);
                }
            });
        });
        this.brand_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if (this.brandManager.delete(selectBrandId)) {
                    Helper.showMessage("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_brand.setComponentPopupMenu(brand_menu);
    }

    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_strt_date.setText("10/10/2023");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_fnsh_date.setText("16/10/2023");
    }
}
