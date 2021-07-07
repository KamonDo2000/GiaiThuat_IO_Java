package QuanLyNS;

import java.util.Scanner;

public class QuanLyKH {

    public NodeKH Head;
    public NodeKH Tail;

    Scanner sc = new Scanner(System.in);

    
//Them Node
    public void ThemNode(NodeKH node){
        if(this.Head == null && this.Tail == null)
            this.Head = this.Tail = node;
        else{
            this.Tail.next = node;
            node.pre = this.Tail;
            this.Tail = node;
        }
    }
//Xoa Node
    public void XoaNode(NodeKH node){
        if (this.Head == node) {
            this.Head.next.pre = null;
            this.Head = this.Head.next;
        }
        else if(this.Tail == node) {
            this.Tail.pre.next = null;
            this.Tail = this.Tail.pre;
        }
        else {
            for (NodeKH nodec = this.Head; nodec != null; nodec = nodec.next) {
                if(nodec == node) {
                    nodec.pre.next = nodec.next;
                    nodec.next.pre = nodec.pre;
                    nodec = null;
                    return;
                }
            }
        }
    }

    public void SuaNode(NodeKH node){
    	
    	 for (NodeKH nodec = this.Head; nodec != null; nodec = nodec.next) {
             if(nodec == node){
                     System.out.println("\n Thong tin chinh sua:");
                     System.out.print("Nhap ten: ");
                     nodec.inforKH.Ten = sc.nextLine();
                     System.out.print("Dia chi: ");
                     nodec.inforKH.DiaChi = sc.nextLine();
                     System.out.print("Nam sinh: ");
                     nodec.inforKH.NamSinh = sc.nextLine();
                     System.out.print("So dien thoai: ");
                     nodec.inforKH.DienThoai = sc.nextLine();      
                     System.out.print("Hoa don: ");
                     nodec.inforKH.HoaDon = sc.nextLine();
                     System.out.println("\nDa chinh sua.");
                 return;
             }
         }
    }
  //Find
    public NodeKH TimNode(String SoHoaDon){
        for (NodeKH nodec = this.Head; nodec != null; nodec = nodec.next) {
            if(nodec.inforKH.SoHoaDon.equals(SoHoaDon))
                return nodec;
        }
        return null;
    }
    
    public void Show(){
        for(NodeKH nodec = this.Head; nodec != null; nodec = nodec.next){   
        	System.out.println("Ma khach: " + nodec.inforKH.SoHoaDon);
            System.out.println("Ten khach: " + nodec.inforKH.Ten);
            System.out.println("diachi: " + nodec.inforKH.DiaChi);
            System.out.println("so Dien thoai: " + nodec.inforKH.DienThoai);
            System.out.println("nam sinh: " + nodec.inforKH.NamSinh);
            System.out.println("So tien giao dich: " + nodec.inforKH.HoaDon);
            System.out.println("\n");
        }
    }
}
