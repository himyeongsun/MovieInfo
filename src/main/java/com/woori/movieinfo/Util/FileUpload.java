package com.woori.movieinfo.Util;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

//파일업로드에 관련된 메소드를 담은 클래스
//poster.jpg==>poster.jpg 저장, poster.jpg새로 저장==>poster.jpg 기존내용되고 새로운파일 저장
//poster.jpg==>32423sd324dsrw3d.jpg 중복되지 않는 이름으로 파일 저장
//UUID : 파일이름을 난수로 생성
@Component
public class FileUpload {
    /*------------------------------
    함수명 : String FileUpload(String imgLocation, MultipartFile imageFile)
    인수 : 저장될 위치, 이미지파일
    출력 : 저장후 생성된 새로운 파일명
    설명 : 이미지파일을 새로운이름으로 지정된 폴더에 저장하고 새로운이름을 전달
     ------------------------------*/
    public String FileUpload(String imgLocation, MultipartFile imageFile) {
        //이미지파일에 파일명을 읽어온다. sample.jpg
        String originalFilename = imageFile.getOriginalFilename();
        //확장자만 분리 .jpg
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        UUID uuid = UUID.randomUUID(); //난수로 이름을 생성, 432-erw3342-4324
        String filename = uuid.toString() + extension; //새로운이름에 확장자 결합,432-erw3342-4324.jpg

        //c:/movie/432-erw3342-4324.jpg
        String path = imgLocation + filename; //최종 저장될 위치와 파일명

        //외부작업은 반드시 try~catch로 예외처리
        try { //정상적인 작업
            File folder = new File(imgLocation); //작업할 파일지정, c:/movie/432-erw3342-4324.jpg
            if(!folder.exists()){ //지정된 위치에 폴더가 없으면, /movie/
                boolean result = folder.mkdir(); //지정된 위치에 폴더를 생성, /movie/
            }
            byte[] filedata = imageFile.getBytes(); //sample.jpg파일을 바이트단위로 읽어서 저장

            //c:/movie/432-erw3342-4324.jpg파일을 쓰기파일로 열기
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(filedata); //해당파일에 이미지데이터를 저장
            fos.close(); //완료 후 파일 닫기
        } catch(Exception e) { //모든 오류 중 하나라도 발생하면
            return null; //실패시 파일명없이 되돌아 간다.
        }

        return filename; //성공시 저장된 파일명을 전달
    }
    /*------------------------------
    함수명 : void FileDelete(String imgLocation, String imageFileName)
    인수 : 저장될 위치, 이미지파일
    출력 : 저장후 생성된 새로운 파일명
    설명 : 이미지파일을 새로운이름으로 지정된 폴더에 저장하고 새로운이름을 전달
     ------------------------------*/
    public void FileDelete(String imgLocation, String imageFileName) {
        //imgLocation(c:/movie), imageFileName(432erw-234w342.jpg)
        String deleteFileName = imgLocation+imageFileName; //c:/movie/432erw-234w342.jpg

        try {
            File deleteFile = new File(deleteFileName); //삭제할 파일
            if(deleteFile.exists()){ //해당파일이 존재하면
                deleteFile.delete(); //파일삭제
            }
        } catch(Exception e) {

        }
    }
}
