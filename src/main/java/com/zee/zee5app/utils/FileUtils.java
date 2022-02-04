package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.zee.zee5app.exception.IdNotFoundException;

@Component
public class FileUtils {
	public byte[] readFile(File file) throws IOException
	{
		FileInputStream inputStream=new FileInputStream(file);
		byte [] allbytes=new byte[(int) file.length()];
		inputStream.read(allbytes);
		return allbytes;
	}
	public byte[] writeFile(File file) throws IOException
	{
		FileOutputStream outputStream=new FileOutputStream(file);
		byte[] allbytes=new byte[(int) file.length()];
		outputStream.write(allbytes);
		return allbytes;
	}
}
