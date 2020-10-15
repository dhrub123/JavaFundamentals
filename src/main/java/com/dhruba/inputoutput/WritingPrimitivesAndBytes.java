package com.dhruba.inputoutput;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

public class WritingPrimitivesAndBytes {
	
	public static void main(String[] args) {
		
		String pathname = "src/main/resources/ints.bin";
		String compressedPathName = "src/main/resources/ints.bin.gz";
		File file = new File(pathname);
		File compressedFile = new File(compressedPathName);
		
		try(OutputStream os = new FileOutputStream(file);
			OutputStream compressedOs = new FileOutputStream(compressedFile);	
			DataOutputStream dos = new DataOutputStream(os);
			GZIPOutputStream gzos = new GZIPOutputStream(compressedOs);
			DataOutputStream compresseddos = new DataOutputStream(gzos);
				){
			
			
			
			dos.writeInt(10);
			dos.writeDouble(10d);
			dos.writeUTF("Hello");
			
			IntStream.
				range(0,  1000).
				forEach(
					i -> {
						try {
							dos.writeInt(i);
							compresseddos.writeInt(i);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Path path = Paths.get(pathname);
			long size = Files.size(path);
			System.out.println(path + " size : " + size);//4 for integer + 8 for double + 7 for string = 19 
														//+ 1000*4 for intstream of 1000 ints each of 4 bytes = 4019
			System.out.println(Paths.get(compressedPathName) + " size : " + Files.size(Paths.get(compressedPathName)));//only 1731 bytes
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
