package com.dhruba.inputoutput.hybrid;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import com.dhruba.inputoutput.hybrid.model.Fable;
import com.dhruba.inputoutput.hybrid.util.AesopReader;
import com.dhruba.inputoutput.hybrid.util.FableData;

public class WritingHybridStreams {
	
	public static void main(String[] args) {
		
		AesopReader reader = new AesopReader();
		List<Fable> fables = reader.readFable("src/main/resources/aesop.txt");
		
		System.out.println("# fable = " + fables.size());
		
		//format
//		Aesop's Fables
//		291
//		   1235     123 The Wolf and the Lamb
//		   3271     245 The Bat and the Weasels
//		<binary texts>
		
		try(
			ByteArrayOutputStream aesopbos = new ByteArrayOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(aesopbos,StandardCharsets.UTF_8);
		){
			PrintWriter printer = new PrintWriter(out);
			
			printer.println("Aesop's Fables");
			printer.printf("%d\n", fables.size());
			for(Fable fable: fables) {
				printer.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
			}
			printer.flush();
			out.close();
			int textOffset = aesopbos.size();
			
			//System.out.println(new String(aesopbos.toByteArray()));
			ByteArrayOutputStream textBos = new ByteArrayOutputStream();
			
			int offset = textOffset;
			List<FableData> fableDatas = new ArrayList<>();
			for (Fable fable: fables) {
				ByteArrayOutputStream fablebos = new ByteArrayOutputStream();
				try(
					GZIPOutputStream gzipos = new GZIPOutputStream(fablebos);
				){
					gzipos.write(fable.getText().getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				int length = fablebos.size();
				textBos.write(fablebos.toByteArray());
				FableData fableData = new FableData(fable, offset, length);
				offset = offset + length;
				
				fableDatas.add(fableData);
				
			}
			textBos.close();
			
			//
			
			ByteArrayOutputStream aesopbos1 = new ByteArrayOutputStream();
			OutputStreamWriter out1 = new OutputStreamWriter(aesopbos1,StandardCharsets.UTF_8);
			printer = new PrintWriter(out1);
			
			printer.println("Aesop's Fables");
			printer.printf("%d\n", fables.size());
			for(FableData fableData: fableDatas) {
				printer.printf("%7d %7d %s\n", fableData.getOffset(), fableData.getLength(), fableData.getFable().getTitle());
			}
			printer.flush();
			out1.close();
			
			System.out.println(new String(aesopbos1.toByteArray()));
			
			aesopbos1.write(textBos.toByteArray());
			aesopbos1.close();
			
			File file = new File("src/main/resources/aesops-compressed.bin");
			try(OutputStream os = new FileOutputStream(file)){
				os.write(aesopbos1.toByteArray());
			}
			 //
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
