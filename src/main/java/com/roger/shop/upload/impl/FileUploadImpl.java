package com.roger.shop.upload.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.roger.shop.constant.SeperateConstant;
import com.roger.shop.upload.FileImage;
import com.roger.shop.upload.FileUpload;

@Component(value = "fileUpload")
public class FileUploadImpl implements FileUpload {

	@Value("#{prop.filePath}")
	private String filePath;
	
	private String getExtension(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	private String createNewFileName(String fileName) {
		String ext = getExtension(fileName);
		return UUID.randomUUID() + SeperateConstant.DOT+ ext;
	}

	@Override
	public String uploadFile(FileImage fileImage) {
		String newFileName = createNewFileName(fileImage.getFilename());
		try {
			FileUtils.copyFile(fileImage.getFile(), new File(filePath,newFileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			fileImage.getFile().delete();
		}
		return newFileName;
	}
}
