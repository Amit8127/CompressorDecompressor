package Compressor_Decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {

	public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        /*
        This line creates a FileInputStream object named fis and initializes it with the input File object.
         */
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        /*
        This line creates a GZIPInputStream object named gzipIS and initializes it with the FileInputStream object fis.
        This allows the decompressor to read a GZIP compressed file
         */
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFileCheck.txt");
        /*
        This line creates a FileOutputStream object named fos and initializes it with the output file path.
        This will write the decompressed data to a new file named "DecompressedFileCheck.txt" in the same directory as the original compressed file.
         */

        byte[] buffer = new byte[1024];
        /*
        This line creates a byte array named buffer with a size of 1024 bytes.
        This array is used to temporarily store data read from the compressed file
         */

        int len;
        while ((len = gzipIS.read(buffer)) != -1) {
            // System.out.println("length of file" + len);
            fos.write(buffer, 0, len);

        }
        gzipIS.close();
        fis.close();
        fos.close();
        /*
        These lines close the input and output streams to release system resources and ensure that all data is written to the output file.
         */

    }

    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\amitm\\OneDrive\\Desktop\\Compressor_Decompressor\\Compressedfile.gz");
        method(path);

    }
}
