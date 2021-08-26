package com.example.jsontry02.dto;

public class Resource {
    private String file;
    private String fileName;
    private String fileType;
    private String fileModuleTitle;

    public Resource() {
        this.file = file;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileModuleTitle = fileModuleTitle;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileModuleTitle() {
        return fileModuleTitle;
    }

    public void setFileModuleTitle(String fileModuleTitle) {
        this.fileModuleTitle = fileModuleTitle;
    }
}
