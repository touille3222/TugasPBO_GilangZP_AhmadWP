import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Player {
    //item defulat yang dimiliki player
    private ItemDiambil objCincin = new ItemDiambil("Cincin Emas");
    private ArrayList<Item>arrItem = new ArrayList<>();;
    private Ruangan ruanganAktif;  //ruangan tempat player saat ini berada
    private Scanner sc = new Scanner(System.in);
    private GameInfo objGameInfo;

    public ItemDiambil getObjCincin() {
        return objCincin;
    }

    public void setObjCincin(ItemDiambil objCincin) {
        this.objCincin = objCincin;
    }

    public ArrayList<Item> getArrItem() {
        return arrItem;
    }

    public void setArrItem(ArrayList<Item> arrItem) {
        this.arrItem = arrItem;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objCincin.setObjGameInfo(objGameInfo);
    }

//    public Player() {
//        arrItem = new ArrayList<>();
//        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
//        arrItem.add(objCincin);
//    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    //cari item yang dimiliki oleh player, return TRUE jika ada
    //salah satu yg menggunakan: pintu untuk mengecek apakah player sudah punya kunci
    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
             if (namaItem.equals(objItem.getNama())) {
                 return (true);
            }
        }
        return(false); //tidak ketemu
    }

    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:arrItem) {
            cc++;
            System.out.printf("%d. %s%n",cc,objItem.getNama());
            System.out.println(objItem.getDeskripsi());
        }
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }


    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

}
