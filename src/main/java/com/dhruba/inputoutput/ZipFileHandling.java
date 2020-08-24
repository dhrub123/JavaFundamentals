package com.dhruba.inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZipFileHandling {

	public static void main(String[] args) {

		String[] data = { "Line 1", "Line 2 2", "Line 3 3 3", "Line 4 4 4 4", "Line 5 5 5 5 5" };

		try (FileSystem zipFileSystem = openZip(Paths.get("Test.zip"))) {
			copyToZip(zipFileSystem);
			writeToFileInZipOne(zipFileSystem, data);
			writeToFileInZipTwo(zipFileSystem, data);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

	}

	private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {

		// create map of properties for zip file system like whether to create if not
		// exists
		Map<String, String> FileSystemProperties = new HashMap<>();
		FileSystemProperties.put("create", "true");

		URI zipFileUri = new URI("jar:file", zipPath.toUri().getPath(), null);
		FileSystem zipFileSystem = FileSystems.newFileSystem(zipFileUri, FileSystemProperties);
		return zipFileSystem;

	}

	private static void copyToZip(FileSystem zipFileSystem) throws IOException {
		//copy Alphabets.txt before executing this
		Path sourceFile = Paths.get("Alphabets.txt");// This is equivalent to
														// FileSystems.getDefault().getPath("Alphabets.txt");
		Path destinationFile = zipFileSystem.getPath("/Alphabets.txt");// This points to a location inside the
																		// zipFileSystem. We cannot use Paths here
																		// because Paths can be only used for default
																		// file systems
		Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
	}
	
	//Using buffered writer
	private static void writeToFileInZipOne(FileSystem zipFileSystem, String[] data) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(zipFileSystem.getPath("/newFile1.txt"))) {
			for (String line : data) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
	//Using Files.write method
	private static void writeToFileInZipTwo(FileSystem zipFileSystem, String[] data) throws IOException {
		Files.write(
				zipFileSystem.getPath("/newFile2.txt"), 
				Arrays.asList(data), //We need a source which implements iterable
				Charset.defaultCharset(),
				StandardOpenOption.CREATE
				);
	}
}
