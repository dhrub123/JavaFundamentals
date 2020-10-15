package com.dhruba.inputoutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
	
	public static void main(String[] args) {
		
		//Writing
		
		String fileName = "src/main/resources/archive.zip";
		
		try(
			OutputStream os = new FileOutputStream(new File(fileName));
			ZipOutputStream zos = new ZipOutputStream(os);
			DataOutputStream dos = new DataOutputStream(zos);
		){
			ZipEntry dirEntry = new ZipEntry("bin/");
			zos.putNextEntry(dirEntry);
			
			ZipEntry binFileEntry = new ZipEntry("bin/ints.bin");
			zos.putNextEntry(binFileEntry);
			
			IntStream.
			range(0,  1000).
			forEach(
				i -> {
					try {
						dos.writeInt(i);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			);
			
			ZipEntry textdirEntry = new ZipEntry("text/");
			zos.putNextEntry(textdirEntry);
			
			ZipEntry textFileEntry = new ZipEntry("text/file.txt");
			zos.putNextEntry(textFileEntry);
			
			dos.writeUTF("This is some text content");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading
		String fileNameToRead = "src/main/resources/archive.zip";
		
		try(
				InputStream is = new FileInputStream(new File(fileNameToRead));
				ZipInputStream zis = new ZipInputStream(is);
				DataInputStream dis = new DataInputStream(zis);
		){
			
			ZipEntry nextEntry = zis.getNextEntry();
			while(nextEntry!= null) {
				
				if(nextEntry.isDirectory()) {
					System.out.println("Reading Directory " + nextEntry);
				}else {
					System.out.println("Reading file " + nextEntry);
					if(nextEntry.getName().endsWith(".bin")) {
						
						List<Integer> ints = new ArrayList<>();
						try {
							while(true) {
								ints.add(dis.readInt());
							}
						} catch (EOFException e) {
							//e.printStackTrace();
						}
						System.out.println("ints: " + ints.size());
						
					}else if(nextEntry.getName().endsWith(".txt")) {
						String readUTF = dis.readUTF();
						System.out.println("Content = " + readUTF);
					}
				}
				nextEntry = zis.getNextEntry();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
