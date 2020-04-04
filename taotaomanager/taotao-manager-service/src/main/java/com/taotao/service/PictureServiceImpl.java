package com.taotao.service;

import com.taotao.common.bean.PictureUploadResult;
import com.taotao.common.utils.FTPUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {
    @Value("${FTP_IP}")
    private String FTP_IP;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public PictureUploadResult uploadPicture(MultipartFile uploadFile) {
        if(null == uploadFile || uploadFile.isEmpty()){
            return PictureUploadResult.error("上传图片为空");
        }
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String imageName = UUID.randomUUID() + ext;
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        try{
            boolean isSuccess = FTPUtil.uploadFile(FTP_IP,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FTP_BASE_PATH,filePath,imageName,uploadFile.getInputStream());
            if(!isSuccess){
                return PictureUploadResult.ok("图片上传失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return PictureUploadResult.error("上传图片异常");
        }
        return PictureUploadResult.ok(IMAGE_BASE_URL + filePath + "/" + imageName);
    }
}
