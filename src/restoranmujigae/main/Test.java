/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.main;

import java.util.ArrayList;
import java.util.List;
import restoranmujigae.app.model.order.Pelayan;
import restoranmujigae.app.controller.order.WaiterCtrl;

public class Test {

    public Test() {
//        prepareData();
        Pelayan p = WaiterCtrl.getWaiter(3);
        System.out.println(p.getNama());
    }

    public static void main(String[] args) {
        new Test();
    }

    public void prepareData() {
        List<Pelayan> listWaiter = new ArrayList();

        listWaiter.add(new Pelayan("Sujana", "1234"));
        listWaiter.add(new Pelayan("Sebastian", "1234"));

        WaiterCtrl.createListWaiter(listWaiter);
        
    }
}
