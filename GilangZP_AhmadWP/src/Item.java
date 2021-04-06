import java.util.ArrayList;

public class Item {
    private String deskripsi;
    private String nama;
    private ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item
    private Ruangan objRuangan;  //ruangan tempat item, jika null artinya item dipegang npc atau plyaer
    private GameInfo objGameInfo;

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<String> getArrAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }

    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    //constructor
//    public Item(String nama) {
//        this.nama = nama;
//        // -- dipindahkan karena dinamik tergantung diambil atau dibuang
//        //  arrAksi.add("Deskripsi Item");
//        //  arrAksi.add("Ambil item");
//    }

    public void prosesAksi(int pil) {

    }

    public void printItem() {
        //print deskripsi item
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if (objRuangan==null) {
            //ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            //ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return(arrOut);
    }


}
