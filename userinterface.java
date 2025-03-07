import java.util.Scanner;

public class userinterface {
    public static void TampilkanMenu(){
        System.out.println();
        System.out.println("+================+");
        System.out.println("|    PILIH MENU  |");
        System.out.println("+----------------+");
        System.out.println("|   [C] : Create |");
        System.out.println("|   [R] : Read   |");
        System.out.println("|   [U] : Update |");
        System.out.println("|   [D] : Delete |");
        System.out.println("|   [x] : Exit   |");
        System.out.println("+================+");

    }
    public static void main(String[]args){
        Database db = new Database();
        System.out.println("Welcome App CRUD");
        while (true){
            TampilkanMenu();
            Scanner sc = new Scanner(System.in);
            System.out.println("PILIH :");
            String pilihan = sc.nextLine();
            pilihan = pilihan.toUpperCase();
            switch (pilihan){
                case "C":
                    System.out.println("halaman menu create");
                    System.out.println("-------------------------------------------");
                    System.out.println("input data");
                    System.out.print("NIM           :");
                    String nim = sc.nextLine();
                    System.out.print("NAMA          :");
                    String nama = sc.nextLine();
                    System.out.print("ALAMAT        :");
                    String alamat = sc.nextLine();
                    System.out.print("SEMESTER      :");
                    int Semester = sc.nextInt();
                    System.out.print("SKS           :");
                    int sks = sc.nextInt();
                    System.out.print("IPK           :");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("-------------------------------------------");
                    boolean status = db.insert(nim,nama,alamat, Semester,sks,ipk);
                    if (status==true) {
                        System.out.println("data baru berhasil di tambahkan");
                    }else{
                        System.out.println("Nim "+nim+"data sudah ada");
                        System.err.println("gagal menambahkan data baru");
                    }
                    System.out.println("-------------------------------------------");
                break;
                case "R":
                    System.out.println("halaman menu Read");
                    db.view();
                break;
                case "U":
                    System.out.println("halaman menu update");
                    db.view();
                    System.out.println("input key mahasiswa yang akan di update");
                    String key = sc.nextLine();
                    int index = db.search(key);
                    if (index >=0){
                        System.out.println("anda akan melakukan update data" + db.getData().get(index));
                        System.out.println("halaman menu create");
                        System.out.println("-------------------------------------------");
                        System.out.println("input data");
                        System.out.print("NIM           :");
                        nim = sc.nextLine();
                        System.out.print("NAMA          :");
                        nama = sc.nextLine();
                        System.out.print("ALAMAT        :");
                        alamat = sc.nextLine();
                        System.out.print("SEMESTER      :");
                        Semester = sc.nextInt();
                        System.out.print("SKS           :");
                        sks = sc.nextInt();
                        System.out.print("IPK           :");
                        ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("-------------------------------------------");
                        status = db.update(index, nim,nama,alamat,Semester,sks,ipk);
                        if (status==true) {
                            System.out.println("data baru berhasil di update");
                        }else{
                            System.err.println("gagal menambahkan update data");
                        }
                        System.out.println("-------------------------------------------");
                    }
                break;
                case "D":
                    System.out.println("halaman delete");
                    db.view();
                    System.out.println("masukkan nim mahasiswa yang akan di hapus: ");
                    key = sc.nextLine();
                    index = db.search(key);
                    if (index >=0){
                        System.out.println("apakah anda akan menghapus data ini"+db.getData().get(index));
                        System.out.println("Apakah anda yakin akan Menghapus data ini? Y/N");
                        System.out.println("pilih : ");
                        pilihan = sc.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")){
                            status = db.delete(index);
                            if (status==true);
                            System.out.println("data berhasil dihapus");
                        }else {
                            System.err.println("gagal menghapus data");
                        }

                    }else {
                        System.err.println("mahasiswa dengan nim: " + key + "tidak ada di data bese");
                    }
                break;
                case "X":
                    System.out.println("INFO : Anda memilih menu Exit");
                    System.out.println("Apakah anda yakin akan keluar dari aplikasi? Y/N");
                    System.out.print("Pilih : ");
                    pilihan = sc.nextLine();
                    if (pilihan.equalsIgnoreCase( "Y")){
                        System.exit(0);
                }
                break;

            }
        }
    }
}
