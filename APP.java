
package pkgprojectUAS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;
public class APP {
    public static void main(String[] args) {
        Scanner ac=new Scanner(System.in);
        cItem itm1= new cItem("gula    ",12000);
        cItem itm2= new cItem("kecap   ",7000);
        cItem itm3= new cItem("beras   ",15000);
        cItem itm4= new cItem("ketumbar",10000);
        cItem itm5= new cItem("jahe    ",8000);
        
        //membuat kode transaksi menggunakan tanggal dan bulan
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("MMdd");
        String formatdate = date.format(mydate);
        
        cProsesTransaksi jual = new cProsesTransaksi();
        int pilih=0, pilih1=0,pilih2=0;
        int jumlah=0;
        int kode=0;
        do{
            System.out.println("");
            System.out.println("/App toko");
            System.out.println("1.Pembeli");
            System.out.println("2.Member");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("Pilih : ");
            pilih=ac.nextInt();
            switch(pilih){
                case 1://pembeli
                    kode++;
                    String kd=formatdate+String.valueOf(kode);
                    cProsesTransaksi beli = new cProsesTransaksi();
                    System.out.print("Masukkan Nama : ");
                    String nm = ac.next();
                    do{
                        System.out.println("\nAkun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Exit");
                        System.out.print("Pilih : ");
                        pilih1=ac.nextInt();
                        switch(pilih1){
                            case 1://tambah
                                cTraansaksi js = null;
                                System.out.println("\n Daftar Barang");
                                System.out.println("1.Gula");
                                System.out.println("2.Kecap");
                                System.out.println("3.Beras");
                                System.out.println("4.Ketumbar");
                                System.out.println("5.Jahe");
                                System.out.print("Pilih : ");
                                pilih2=ac.nextInt();
                                System.out.print("Jumlah :");
                                jumlah=ac.nextInt();
                                
                                switch(pilih2){
                                    case 1:                                     
                                        js = new cTraansaksi(kd,nm,itm1,jumlah,0);
                                       break;
                                    case 2:
                                        js = new cTraansaksi(kd,nm,itm2,jumlah,0);
                                       break;
                                    case 3:
                                        js = new cTraansaksi(kd,nm,itm3,jumlah,0);
                                        break;
                                    case 4:
                                        js = new cTraansaksi(kd,nm,itm4,jumlah,0);
                                        break;
                                    case 5:
                                        js = new cTraansaksi(kd,nm,itm5,jumlah,0);
                                        break;                                   
                                }
                                beli.AddTransaksi(js);
                                break;
                            case 2://hapus
                                beli.showTransaksi();
                                System.out.print("Pilih Nomor : ");
                                int hapus=ac.nextInt();
                                beli.deleteTransaksi(hapus);
                                break;
                            case 3://lihat
                                beli.showTransaksi();
                                break;
                            case 4://exit
                                break;
                        }
                    }while(pilih1!=4);
                    break;
                case 2://member
                    break;
                case 3://admin
                    break;
                case 4://pemilik
                    break;
                case 5://kembali
                    break;
            }
        }while(pilih!=5);
    }
}
