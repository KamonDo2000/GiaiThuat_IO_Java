package QuanLyNS;

public class NodeNV {
	public InforNhanVien inforNV;
    public NodeNV next;
    public NodeNV pre;

    public NodeNV (InforNhanVien infor){
        this.inforNV = infor;
        this.next = null;
        this.pre = null;
    }
}
