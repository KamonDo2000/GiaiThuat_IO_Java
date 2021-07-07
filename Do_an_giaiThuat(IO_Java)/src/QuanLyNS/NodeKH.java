package QuanLyNS;

public class NodeKH {
	public InforKhachHang inforKH;
    public NodeKH next;
    public NodeKH pre;

    public NodeKH(InforKhachHang infor) {
        this.inforKH = infor;
        this.next = null;
        this.pre = null;
    }
}
