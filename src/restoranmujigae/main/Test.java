/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.main;

import java.util.ArrayList;
import java.util.List;
import restoranmujigae.app.controller.data.DataCtrl;
import restoranmujigae.app.controller.order.OrderCtrl;
import restoranmujigae.app.model.order.Pelayan;
import restoranmujigae.app.controller.order.WaiterCtrl;
import restoranmujigae.app.controller.transaction.CashierCtrl;
import restoranmujigae.app.model.menu.Kategori;
import restoranmujigae.app.model.menu.Menu;
import restoranmujigae.app.model.order.Meja;
import restoranmujigae.app.model.order.OrderMenuLine;
import restoranmujigae.app.model.transaction.Cashier;

public class Test {

    public Test() {
        addMeja();
//        addWaiter();
//        addCashier();
//        addKategori();
//        addMenu();
    }

    public static void main(String[] args) {
        new Test();
    }

    public void addWaiter() {
        List<Pelayan> listWaiter = new ArrayList();

        listWaiter.add(new Pelayan("Sujana", "1234"));
        listWaiter.add(new Pelayan("Sebastian", "1234"));

        for (Pelayan pelayan : listWaiter) {
            DataCtrl.createWaiter(pelayan);
        }
    }

    public void addCashier() {
        List<Cashier> listCashier = new ArrayList();
        listCashier.add(new Cashier("Richard", true));

        for (int i = 0; i < listCashier.size(); i++) {
            CashierCtrl.createCashier(listCashier.get(i).getNama(), true);
        }
    }

    public void addKategori() {
        List<Kategori> listKategori = new ArrayList();
        listKategori.add(new Kategori(1, "Appetizer", true));
        listKategori.add(new Kategori(2, "Main Course", true));
        listKategori.add(new Kategori(3, "Drink", true));
        listKategori.add(new Kategori(4, "Dessert", true));

        for (int i = 0; i < listKategori.size(); i++) {
            DataCtrl.createKategori(listKategori.get(i).getId(), listKategori.get(i).getNama(), true);
        }
    }

    public void addMeja() {
        List<Meja> listMeja = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            listMeja.add(new Meja("MEJA" + String.format("%02d", i)));
        }
        
        for (Meja meja : listMeja) {
            DataCtrl.createMeja(meja);
        }
    }

    public void addMenu() {
        List<Menu> listMenu = new ArrayList();
        listMenu.add(new Menu("Bacon Wrapped", 25000, 1, true, "Bacon, marry me!"));
        listMenu.add(new Menu("Caribbean Chicken Salad", 25000, 1, true, "This is not a pirates"));
        listMenu.add(new Menu("Feta bites", 25000, 1, true, "A bite's of Heaven is here"));
        listMenu.add(new Menu("Grilled Chicken Wings", 25000, 1, true, "Winner winner chicken dinner"));
        listMenu.add(new Menu("Savory Bake", 25000, 1, true, "Imagine that your bloods are cheese"));
        listMenu.add(new Menu("Turnip Green", 25000, 1, true, "Lick over chips"));
        listMenu.add(new Menu("Taco", 25000, 1, true, "Taco make a peace on your relationship"));
        listMenu.add(new Menu("Vegetable Tian", 25000, 1, true, "Made by a RAT"));

        listMenu.add(new Menu("Eggs in Hell", 50000, 2, true, "Help the eggs!"));
        listMenu.add(new Menu("Grilled Chicken", 50000, 2, true, "This is a breast chicken, not a butt"));
        listMenu.add(new Menu("Pene", 50000, 2, true, "Pene? What is pene?"));
        listMenu.add(new Menu("Quesadilla", 50000, 2, true, "The pork is sleeping under the blanket of tortilla"));
        listMenu.add(new Menu("Pulled Pork", 50000, 2, true, "The pork is pinched by the Buns"));
        listMenu.add(new Menu("Salmon Style", 50000, 2, true, "The grizzly bear bring you some special salmon here"));
        listMenu.add(new Menu("Schnitzle Tower", 50000, 2, true, "Schiii schniit schnitzzt... SCHNITZLE!!"));
        listMenu.add(new Menu("Spaghetti", 50000, 2, true, "Another bule' meal here"));

        listMenu.add(new Menu("Coke", 25000, 3, true, "Coke please!"));
        listMenu.add(new Menu("Cute Pink", 25000, 3, true, "Cute people drink disss"));
        listMenu.add(new Menu("Ice Coffee", 25000, 3, true, "BOLD MAN YO"));
        listMenu.add(new Menu("Juice (random)", 25000, 3, true, "Just a random juice"));
        listMenu.add(new Menu("Choco Milkshake", 25000, 3, true, "Milkshake just for a kid"));
        listMenu.add(new Menu("Orange Juice", 25000, 3, true, "Fresh Juice, Fresh Face"));
        listMenu.add(new Menu("Pineapple Pen", 25000, 3, true, "Apple pen, pen pineapple pen, pen pineapple apple pen"));
        listMenu.add(new Menu("Sexy Smoothies", 25000, 3, true, "This glass is sexier than your girlfriend"));

        listMenu.add(new Menu("Banana Split", 25000, 4, true, "Dont see a man' eyes while you eating a banana"));
        listMenu.add(new Menu("Cake Berries", 25000, 4, true, "Cake won't make you fat, believe me"));
        listMenu.add(new Menu("Classic Ice Cream", 25000, 4, true, "There is no sadness in ice cream"));
        listMenu.add(new Menu("Fruit Salad", 25000, 4, true, "Fruit salad with honey, but you have no honey"));
        listMenu.add(new Menu("Choco Cookies", 25000, 4, true, "Lovely grandma made some cookies for you"));
        listMenu.add(new Menu("Oreo Cake", 25000, 4, true, "Oreoreoreoreoreoreoreoreoreoreoreo"));
        listMenu.add(new Menu("Pan - Cake", 25000, 4, true, "This is Pan-Cake not Pancake"));
        listMenu.add(new Menu("Short Cake", 25000, 4, true, "Short People must eat Short Cake"));

        for (int i = 0; i < listMenu.size(); i++) {
            DataCtrl.createMenu((i + 1), listMenu.get(i).getNama(), listMenu.get(i).getHarga(),
                    null, listMenu.get(i).getId_kategori(), listMenu.get(i).getDeskripsi());
        }
    }

}
