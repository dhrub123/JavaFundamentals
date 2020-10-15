package com.dhruba.inputoutput;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ReadingPrimitivesAndBytes {
	
	public static void main(String[] args) {
		
		String fileName = "src/main/resources/ints.bin";
		
		try {
			Path path = Paths.get(fileName);
			long size = Files.size(path);
			System.out.println(path + " size : " + size);
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try(
			InputStream is = new FileInputStream(new File(fileName));
			DataInputStream dis = new DataInputStream(is);
		){
			List<Integer> ints = new ArrayList<>();
			try {
				while(true) {
					ints.add(dis.readInt());
				}
			} catch (EOFException e) {
				//e.printStackTrace();
			}
			System.out.println("ints: " + ints.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//############################################################################################
		
		String compressedFileName = "src/main/resources/ints.bin.gz";
		
		try {
			Path compressedPath = Paths.get(compressedFileName);
			long compressedSize = Files.size(compressedPath);
			System.out.println(compressedPath + " size : " + compressedSize);
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try(
			InputStream cis = new FileInputStream(new File(compressedFileName));
			GZIPInputStream gis = new GZIPInputStream(cis);
			DataInputStream cdis = new DataInputStream(gis);
				
		){
			List<Integer> compressedInts = new ArrayList<>();
			try {
				while(true) {
					compressedInts.add(cdis.readInt());
				}
			} catch (EOFException e) {
				//e.printStackTrace();
			}
			System.out.println("compressed ints: " + compressedInts.size());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//############################################################################################
		
	}

}
