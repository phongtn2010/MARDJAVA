package com.nsw.backend.ws.client;
public class Upload {
	protected String filePath;

	protected String fileName;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Upload() {
		
	}

	public Upload(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;
	}
	public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("filePath:");
        sb.append(filePath);
        sb.append("fileName:");
        sb.append(fileName);
        return sb.toString();
	}

}
