package com.dhruba.inputoutput.hybrid;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class ReadingHybridStreams {

	public static void main(String[] args) {
		
		int lineOfTheFirstFable = 1;
		int n = 290;
		
		String pathName = "src/main/resources/aesops-compressed.bin";
		File file = new File(pathName);
		
		try(
			InputStream is = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(is);
		) {
			
			int size = (int)Files.size(Paths.get(pathName));
			bis.mark(size+1);
			InputStreamReader in = new InputStreamReader(bis);
			LineNumberReader reader = new LineNumberReader(in );
			reader.readLine();
			while (reader.getLineNumber() < n + lineOfTheFirstFable) {
				reader.readLine();
			}
			String fableData = reader.readLine();
			System.out.println(fableData);
			
			int offset = Integer.parseInt(fableData.substring(0,7).trim());
			int length = Integer.parseInt(fableData.substring(9,16).trim());
			String title = fableData.substring(16);
			System.out.printf("%d %d %s\n", offset, length, title);
			bis.reset();
			
			int skip = (int)bis.skip(offset);
			int totalSkip = skip;
			while(totalSkip < offset) {
				skip = (int)bis.skip(offset - totalSkip);
				totalSkip = totalSkip + skip;
			}
			
			byte[] bytes = new byte[4096];
			int read = bis.read(bytes);
			
			ByteArrayInputStream bis2 = new ByteArrayInputStream(bytes, 0, length);
			GZIPInputStream gzis = new GZIPInputStream(bis2);
			
			byte[] bytes2 = new byte[4096];
			int bytesDecompressed = gzis.read(bytes2);
			String fableText = new String(bytes2, 0 , bytesDecompressed);
			System.out.println(fableText);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
