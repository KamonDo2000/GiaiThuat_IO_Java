package QuanLyNS;

import java.util.Scanner;

public class QuanLyNV {
    public NodeNV Head;
    public NodeNV Tail;

    Scanner sc = new Scanner(System.in);
   
    public void ThemNode(NodeNV node) {
        if(this.Head == null && this.Tail == null)
            this.Head = this.Tail = node;
        else{
            this.Tail.next = node;
            node.pre = this.Tail;
            this.Tail = node;
        }
    }

    public void XoaNode(NodeNV node) {
        if (this.Head == node) {
            this.Head.next.pre = null;
            this.Head = this.Head.next;
        }
        else if(this.Tail == node) {
            this.Tail.pre.next = null;
            this.Tail = this.Tail.pre;
        }
        else {
            for (NodeNV nodec = this.Head; nodec != null; nodec = nodec.next) {
                if(nodec == node) {
                    nodec.pre.next = nodec.next;
                    nodec.next.pre = nodec.pre;
                    nodec = null;
                    return;
                }
            }
        }
    }

    public void SuaNode(NodeNV node) {

    	for (NodeNV nodec = this.Head; nodec != null; nodec = nodec.next) {
            if(nodec == node){
            	System.out.println("\n Thong tin chinh sua:");
            	System.out.print("Nhap Ten: ");
            	nodec.inforNV.Ten = sc.nextLine();
            	System.out.print("Gioi Tinh: ");
            	nodec.inforNV.Gioi = sc.nextLine();
            	System.out.print("Ngay Sinh: ");
            	nodec.inforNV.NgaySinh = sc.nextLine();
            	System.out.print("Dia Chi: ");
            	nodec.inforNV.DiaChi = sc.nextLine();
            	System.out.print("Mail: ");
            	nodec.inforNV.Email = sc.nextLine();	
            	System.out.print("So Dien Thoai: ");
            	nodec.inforNV.DienThoai = sc.nextLine();
            	System.out.print("Luong: ");
            	nodec.inforNV.Luong = sc.nextLine();
            	System.out.println("\nDa chinh sua.");            
                return;
            }
        }
    }
    
    public NodeNV TimNode (String ID) {
        for (NodeNV nodec = this.Head; nodec != null; nodec = nodec.next) {
            if(nodec.inforNV.ID.equals(ID))
                return nodec;
        }
        return null;
    }
    
    public void Show(){
        for(NodeNV nodec = this.Head; nodec != null; nodec = nodec.next) {
        	System.out.println("ma nhan vien: " + nodec.inforNV.ID);
            System.out.println("ho va ten: " + nodec.inforNV.Ten);
            System.out.println("gioi tinh: " + nodec.inforNV.Gioi);
            System.out.println("ngay sinh: " + nodec.inforNV.NgaySinh);
            System.out.println("dia chi: " + nodec.inforNV.DiaChi);
            System.out.println("Email: " + nodec.inforNV.Email);
            System.out.println("So dien thoai: " + nodec.inforNV.DienThoai);
            System.out.println("Luong: " + nodec.inforNV.Luong);
            System.out.println("\n");
        }
    }
}