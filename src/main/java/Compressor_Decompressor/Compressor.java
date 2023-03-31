package Compressor_Decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
	
	public static void method(File file) throws IOException {
        String filedirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filedirectory + "/compressedfile.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);

        byte[] buffer= new byte[1024];
        int len;

        while((len = fis.read(buffer)) != -1){
            gzipOS.write(buffer, 0, len);
        }

        gzipOS.close();
        fos.close();
        fis.close();

    }
    public static void main(String[] args) throws IOException{

        File path =new File("C:\\Users\\amitm\\OneDrive\\Desktop\\Compressor_Decompressor\\compress");
        method(path);
    }

}
