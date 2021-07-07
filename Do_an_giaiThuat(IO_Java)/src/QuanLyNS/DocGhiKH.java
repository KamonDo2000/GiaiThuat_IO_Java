package QuanLyNS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocGhiKH {
	private static final String FILENAME = "khachhang.txt";
	//sau khi chay mot cai khac roi chay lai add no se co 2 enter
//		Xoa va sua remake lai file cho ra 2 cai enter cuoi cung
		public void Ghifile(InforKhachHang infor)
	    {
	        BufferedWriter bw = null;
	        FileWriter fw = null;
	        File file = new File(FILENAME);
	        try {
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	           
	            fw = new FileWriter(file.getAbsoluteFile(),true);
	            bw = new BufferedWriter(fw);
	            bw.newLine();
	            bw.write(infor.SoHoaDon);
	            bw.newLine();
				bw.write(infor.Ten);
				bw.newLine();
				bw.write(infor.DiaChi);
				bw.newLine();
				bw.write(infor.DienThoai);
				bw.newLine();
				bw.write(infor.NamSinh);
				bw.newLine();
				bw.write(infor.HoaDon);
				bw.newLine();

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                if (bw != null)
	                    bw.close();
	                if (fw != null)
	                    fw.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
		
		
		   File file = new File(FILENAME);
		 public void GhideFile(QuanLyKH list) {
		    	try {
		    		FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
		    		BufferedWriter bw = new BufferedWriter(fw);
		    		for (NodeKH nodec = list.Head; nodec != null; nodec = nodec.next) {
		    			
		    			bw.write(nodec.inforKH.SoHoaDon);
		    			bw.newLine();
		    			bw.write( nodec.inforKH.Ten);
		    			bw.newLine();
		    			bw.write(nodec.inforKH.DiaChi);
		    			bw.newLine();
		    			bw.write(nodec.inforKH.DienThoai);
		    			bw.newLine();
		    			bw.write(nodec.inforKH.NamSinh);
		    			bw.newLine();
		    			bw.write(nodec.inforKH.HoaDon);
		    			bw.newLine();
		    			bw.newLine();
		    		}
		    		bw.close();
		    		fw.close();
		    	}
		    	catch (IOException e) {
		    		e.printStackTrace();
		    	}
		    }
		 
		 
	    public void Read(QuanLyKH list) {
	        try {
	            FileReader fr = new FileReader(FILENAME);
	            BufferedReader br = new BufferedReader(fr);
	            String line;

	            while ((line = br.readLine()) != null){
	                if(line.isEmpty()){
	                    line = br.readLine();
	                }
	                else{
	                    InforKhachHang infor = new InforKhachHang();
	                    infor.SoHoaDon= line;
	                    infor.Ten = br.readLine();
	                    infor.DiaChi = br.readLine();
	                    infor.DienThoai = br.readLine();
	                    infor.NamSinh = br.readLine();
	                    infor.HoaDon = br.readLine();
	                    br.readLine();
	                    NodeKH nodec = new NodeKH(infor);
	                    list.ThemNode(nodec);
	                }
	            }
	            fr.close();
	            br.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}
}
