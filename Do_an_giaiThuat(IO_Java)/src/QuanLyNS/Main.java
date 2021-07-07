package QuanLyNS;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static DocGhiNV docGhiNV = new DocGhiNV();

    static DocGhiKH docGhiKH = new DocGhiKH();
    
    static void Menu(QuanLyKH quanlyKH, QuanLyNV quanlyNV) {
        String Chon;
        boolean i = true;
        do {
            System.out.println("================ Cong Ty ABC ================");
            System.out.println("|	1. Quan Ly Khach Hang.	|");
            System.out.println("|	2. Quan Ly Nhan Vien.	|");
            System.out.println("|	0. Thoat.		|");
            System.out.println("=============================================");
            System.out.print("Chon chuc nang: ");
            Chon = sc.nextLine();
            System.out.print("\n");
            
            switch (Chon){
                case "1":
                	MenuKH(quanlyKH);
                    break;
                case "2":
                    MenuNV(quanlyNV);
                    break;
                case "0":
                	i = false;
                    break;
                default:
                    System.out.println("Chon sai!");
                    break;
            }
        } while (i);
    }
    
    static void MenuKH(QuanLyKH danhsachKH){
        String Chon;
        boolean i = true;
        do {
            System.out.println("========== Quan Ly Khach Hang ==========");
            System.out.println("|	1. Them khach hang.				");
            System.out.println("|	2. Xoa khach hang. 				");
            System.out.println("|	3. Sua thong tin khach hang.	");
            System.out.println("|	4. Tim kiem khach hang.			");
            System.out.println("|	5. Xem danh sach khach hang.	");
            System.out.println("|	0. Back.						");
            System.out.println("======================================");
            System.out.print("Chon chuc nang: ");
            Chon = sc.nextLine();
            System.out.print("\n");
            
            switch (Chon) {
                case "1":
                	InforKhachHang them = new InforKhachHang();
                	System.out.printf("Nhap ma hoa don khach: ");
                    String soHoaDon = sc.nextLine();
                    them.setBillID(soHoaDon);
                    System.out.printf("Nhap ten khach: ");
                    String ten = sc.nextLine();
                    them.setTen(ten);
                    System.out.printf("Nhap dia chi khach hang: ");
                    String diaChi = sc.nextLine();
                    them.setDiaChi(diaChi);
                    System.out.printf("Nhap so dien thoai ");
                    String dienThoai = sc.nextLine();
                    them.setDienThoai(dienThoai);
                    System.out.printf("Nhap nam sinh ");
                    String namSinh = sc.nextLine();
                    them.setNamSinh(namSinh);
                    System.out.printf("so tien giao dich ");
                    String hoaDon = sc.nextLine();
                    them.setHoaDon(hoaDon);
                    
                        NodeKH Them = new NodeKH(them);
                        danhsachKH.ThemNode(Them);
                        docGhiKH.Ghifile(them);
                        System.out.println("\nDa them!");
                    break;
                	
                	
                case "2":
                	System.out.print("Xoa khach hang co ma: ");
                    String xoa = sc.nextLine();
                    NodeKH Xoa= danhsachKH.TimNode(xoa);
                    if(Xoa == null)
                        System.out.println("Ma hoa don " + xoa + " khong ton tai !! ");
                    else {
                            danhsachKH.XoaNode(Xoa);
                            docGhiKH.GhideFile(danhsachKH);
                            System.out.println("\nDa xoa.");
                    }
                    break;
                    
                case "3":
                	System.out.print("Sua thong tin khach hang co ma: ");
                    String sua = sc.nextLine();
                    System.out.print("\n");
                    NodeKH Sua = danhsachKH.TimNode(sua);
                    if(Sua == null)
                    	System.out.println("Ma hoa don " + sua + " khong ton tai !! ");
                    else {
                    	System.out.println("Ma khach: " + Sua.inforKH.SoHoaDon);
                        System.out.println("Ten khach: " + Sua.inforKH.Ten);
                        System.out.println("diachi: " + Sua.inforKH.DiaChi);
                        System.out.println("so Dien thoai: " + Sua.inforKH.DienThoai);
                        System.out.println("nam sinh: " + Sua.inforKH.NamSinh);
                        System.out.println("So tien giao dich: " + Sua.inforKH.HoaDon);
                        danhsachKH.SuaNode(Sua);
                        docGhiKH.GhideFile(danhsachKH);
                    }
                    break;
                    
                case "4":
                	System.out.print("Tim thong tin khach hang co ma: ");
                    String tim = sc.nextLine();
                    NodeKH Tim = danhsachKH.TimNode(tim);
                    if(Tim == null)
                    	System.out.println("Ma hoa don " + tim + " khong ton tai !! ");
                    else {
                        System.out.println("\nThong tin can tim: ");
                        System.out.println("Ma khach: " + Tim.inforKH.SoHoaDon);
                        System.out.println("Ten khach: " + Tim.inforKH.Ten);
                        System.out.println("diachi: " + Tim.inforKH.DiaChi);
                        System.out.println("so Dien thoai: " + Tim.inforKH.DienThoai);
                        System.out.println("nam sinh: " + Tim.inforKH.NamSinh);
                        System.out.println("So tien giao dich: " + Tim.inforKH.HoaDon);
                    }
                    break;
                    
                case "5":
                    System.out.println("Thong Tin khach hang:");
                    danhsachKH.Show();
                    break;
                case "0":
                	i = false;
                    break;
                default:
                    System.out.println("Chon sai!");
                    break;
            }
        }
        while(i);
    }

    static void MenuNV( QuanLyNV danhsachNV ){
    	
        String Chon;
        boolean i = true;
        do {
            System.out.println("=========== Quan Ly Nhan Vien ===========");
            System.out.println("|	1. Them nhan vien moi.		");
            System.out.println("|	2. Xoa thong tin nhan vien.");
            System.out.println("|	3. Sua thong tin nhan vien.");
            System.out.println("|	4. Tim kiem nhan vien.		");
            System.out.println("|	5. Xem danh sach nhan vien.");
            System.out.println("|	0. Back.			");
            System.out.println("=========================================");
            System.out.print("Chon chuc nang: ");
            Chon = sc.nextLine();
            System.out.print("\n");
            
            switch (Chon){
            	case "1":
                    InforNhanVien them = new InforNhanVien();
                    System.out.printf("Nhap ID: ");
                    String id = sc.nextLine();
                    them.setID(id);
                    System.out.printf("Nhap ten Nhan Vien: ");
                    String ten = sc.nextLine();
                    them.setTen(ten);
                    System.out.printf("Nhap gioi tinh: ");
                    String gioi = sc.nextLine();
                    them.setGioi(gioi);
                    System.out.printf("Nhap ngay sinh: ");
                    String ngaySinh = sc.nextLine();
                    them.setNgaySinh(ngaySinh);
                    System.out.printf("Nhap dia chi: ");
                    String diaChi = sc.nextLine();
                    them.setDiaChi(diaChi);
                    System.out.printf("Nhap Email: ");
                    String email = sc.nextLine();
                    them.setEmail(email);
                    System.out.printf("Nhap so dien thoai: ");
                    String dienThoai = sc.nextLine();
                    them.setDienThoai(dienThoai);
                    System.out.printf("Nhap Luong: ");
                    String luong = sc.nextLine();
                    them.setLuong(luong);
                        NodeNV Them = new NodeNV(them);
                        danhsachNV.ThemNode(Them);
                        docGhiNV.Ghifile(them);
                        System.out.println("\nDa them.");
                    break;
                    
                case "2":
                    System.out.print("Xoa nhan vien co ma: ");
                    String xoa = sc.nextLine();
                    NodeNV Xoa= danhsachNV.TimNode(xoa);
                    if(Xoa == null)
                        System.out.println("Ma nhan vien " + xoa + " khong ton tai !! ");
                    else {
                            danhsachNV.XoaNode(Xoa);
                            docGhiNV.GhideFile(danhsachNV);
                            System.out.println("\nDa xoa.");
                    }
                    break;
                    
                case "3":
                    System.out.print("Sua thong tin nhan vien co ma: ");
                    String sua = sc.nextLine();
                    System.out.print("\n");
                    NodeNV Sua = danhsachNV.TimNode(sua);
                    if(Sua == null)
                    	System.out.println("Ma nhan vien " + sua + " khong ton tai !! ");
                    else {
                    	 System.out.println("ma nhan vien: " + Sua.inforNV.ID);
                         System.out.println("ho va ten: " + Sua.inforNV.Ten);
                         System.out.println("gioi tinh: " + Sua.inforNV.Gioi);
                         System.out.println("ngay sinh: " + Sua.inforNV.NgaySinh);
                         System.out.println("dia chi: " + Sua.inforNV.DiaChi);
                         System.out.println("Email: " + Sua.inforNV.Email);
                         System.out.println("So dien thoai: " + Sua.inforNV.DienThoai);
                         System.out.println("Luong: " + Sua.inforNV.Luong);
                         danhsachNV.SuaNode(Sua);
                         docGhiNV.GhideFile(danhsachNV);
                    }
                    break;
                    
                case "4":
                    System.out.print("Tim thong tin nhan vien co ma: ");
                    String tim = sc.nextLine();
                    NodeNV Tim = danhsachNV.TimNode(tim);
                    if(Tim == null)
                    	System.out.println("Ma nhan vien " + tim + " khong ton tai !! ");
                    else {
                        System.out.println("\nThong tin can tim: ");
                        System.out.println("ma nhan vien: " + Tim.inforNV.ID);
                        System.out.println("ho va ten: " + Tim.inforNV.Ten);
                        System.out.println("gioi tinh: " + Tim.inforNV.Gioi);
                        System.out.println("ngay sinh: " + Tim.inforNV.NgaySinh);
                        System.out.println("dia chi: " + Tim.inforNV.DiaChi);
                        System.out.println("Email: " + Tim.inforNV.Email);
                        System.out.println("So dien thoai: " + Tim.inforNV.DienThoai);
                        System.out.println("Luong: " + Tim.inforNV.Luong);
                    }
                    break;
                    
                case "5":
                    System.out.println("\nDanh sach nhan vien:\n");
                    danhsachNV.Show();
                    break;
                    
                case "0":
                	i = false;
                    break;
                default:
                    System.out.println("Chon sai");
                    break;
            }
        }while(i);
    }
    
    public static void main(String[] args) {
    	
    	QuanLyKH quanLyKH = new QuanLyKH();
        QuanLyNV quanLyNV = new QuanLyNV();
        

        docGhiKH.Read(quanLyKH);
        docGhiNV.Read(quanLyNV);
        
        Menu(quanLyKH, quanLyNV);
        System.out.print("\n ESC to Exit");
    }
}
