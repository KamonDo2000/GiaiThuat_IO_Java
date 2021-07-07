package QuanLyNS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocGhiNV {
	private static final String FILENAME = "nhanvien.txt";

	public void Ghifile(InforNhanVien infor)
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
            bw.write(infor.ID);
            bw.newLine();
			bw.write(infor.Ten);
			bw.newLine();
			bw.write(infor.Gioi);
			bw.newLine();
			bw.write(infor.NgaySinh);
			bw.newLine();
			bw.write(infor.DiaChi);
			bw.newLine();
			bw.write(infor.Email);
			bw.newLine();
			bw.write(infor.DienThoai);
			bw.newLine();
			bw.write(infor.Luong);
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
	 public void GhideFile(QuanLyNV list) {
	    	try {
	    		FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
	    		BufferedWriter bw = new BufferedWriter(fw);
	    		for (NodeNV nodec = list.Head; nodec != null; nodec = nodec.next) {
	    			bw.write(nodec.inforNV.ID);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.Ten);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.Gioi);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.NgaySinh);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.DiaChi);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.Email);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.DienThoai);
	    			bw.newLine();
	    			bw.write(nodec.inforNV.Luong);
	    			bw.newLine();
	    			bw.newLine();
	    		}
	    		bw.close();
	    		fw.close();
	    	}
	    	catch (IOException infor) {
	    		infor.printStackTrace();
	    	}
	    }
	 
    
    public void Read(QuanLyNV list) {
        try {
            FileReader fr = new FileReader(FILENAME);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                if(line.isEmpty()){
                    line = br.readLine();
                }
                else{
                    InforNhanVien infor = new InforNhanVien();
                    infor.ID = line;
                    infor.Ten = br.readLine();
                    infor.Gioi = br.readLine();
                    infor.NgaySinh = br.readLine();
                    infor.DiaChi = br.readLine();
                    infor.Email = br.readLine();
                    infor.DienThoai = br.readLine();
                    infor.Luong = br.readLine();
                    br.readLine();
                    NodeNV nodec = new NodeNV(infor);
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
