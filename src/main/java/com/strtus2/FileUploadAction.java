package com.strtus2;

import java.io.File;
import java.util.logging.Logger;

import com.opensymphony.xwork2.Action;

import static com.opensymphony.xwork2.Action.NONE;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by yjh on 16/10/5.
 */
public class FileUploadAction {
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String execute() throws Exception{
        Logger logger1 = Logger.getLogger("console");
        logger1.info("FileUploadAction execute-----:"+Thread.currentThread().getId());
        logger1.info("type:"+getFileUploadContentType());
        return SUCCESS;

    }

    public String display() {
        return NONE;
    }

}
