package com.example.netty.model;

import java.io.File;
import java.io.Serializable;

public class FileUploadFile implements Serializable {

	private static final long serialVersionUID = 1L;
	private File file;
	private String file_md5;
	private int starPos;
	private byte[] bytes;
	private int endPos;
	private long fileSize;

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getStarPos() {
		return starPos;
	}

	public void setStarPos(int starPos) {
		this.starPos = starPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFile_md5() {
		return file_md5;
	}

	public void setFile_md5(String file_md5) {
		this.file_md5 = file_md5;
	}
}