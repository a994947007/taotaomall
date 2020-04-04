package com.taotao.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FTPTest {

    @Test
    public void test() throws IOException {
        FTPClient client = new FTPClient();
        client.connect("192.168.80.140",21);
        client.login("hadoop","luoyao123");
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Lenovo\\Pictures\\timg (3).jpg"));
        client.changeWorkingDirectory("/usr/local/uftp/images");
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.storeFile("hello.jpg",fis);
        client.logout();
    }
}
