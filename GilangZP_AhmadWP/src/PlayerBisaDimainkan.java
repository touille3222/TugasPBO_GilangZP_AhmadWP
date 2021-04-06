import java.util.ArrayList;
import java.util.Scanner;

public class PlayerBisaDimainkan extends Player{
    private int kesehatan = 100;
    private String nama = "budiwati";
    private Scanner sc = new Scanner(System.in);

    public PlayerBisaDimainkan (){
        super.getObjCincin().setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        super.getArrItem().add(super.getObjCincin());
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        super.setObjGameInfo(super.getObjGameInfo());
        super.getObjCincin().setObjGameInfo(objGameInfo);
    }

    public void printPlayer() {
        System.out.println("Nama Player:"+nama);
        System.out.println("Kesehatan Player:"+kesehatan);
    }

    @Override
    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:super.getArrItem()) {
            cc++;
            System.out.printf("%d. %s%n",cc,objItem.getNama());
            System.out.println(objItem.getDeskripsi());
        }
    }

    @Override
    public boolean cariItem(String namaItem) {
        for (Item objItem:super.getArrItem()) {
            if (namaItem.equals(objItem.getNama())) {
                return (true);
            }
        }
        return(false); //tidak ketemu
    }

    public void pilihanAksi() {
        System.out.println("**** Pilihan Aksi pada Player *** ");
        //disamakan dengan  ruangan
        //bisa direfactoring nanti supaya tdk duplikasi

        //aksi2 item yang dimiliki player
        int urutPil = 0;  //item
        int subPil;   //aksinya
        System.out.println("Item yang dimiliki player");
        for (Item objItem:super.getArrItem()){
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList<String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        //info seputar player
        urutPil++;
        subPil = 0;
        int pilInfoPlayer  = urutPil; //catat untuk pintu
        System.out.println("Info Player");
        //hanya satu
        subPil++;
        System.out.printf("%d%d. info player%n", urutPil, subPil);

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if (pil == pilInfoPlayer) {
            printPlayer();
        } else {
            Item objItemPilih = super.getArrItem().get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
//        System.out.println("2. Item milik player");
//        System.out.print("Pilihan anda?");
//        int pil = sc.nextInt();
//        System.out.println("--");
//        if (pil==1) {
//            printPlayer();
//        } else if (pil==2) {
//            printItem();
//        }
    }
}
