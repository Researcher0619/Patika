public class Main {
    public static void main(String[] args) {
        // Employee sınıfından bir örnek oluştur
        Employee kemal = new Employee("Kemal", 2000.0, 45, 1985);

        // toString metodunu çağırarak bilgileri ekrana bastır
        System.out.println(kemal.toString());
    }
}
