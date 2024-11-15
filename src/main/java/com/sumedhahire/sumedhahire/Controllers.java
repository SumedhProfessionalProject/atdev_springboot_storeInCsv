package com.sumedhahire.sumedhahire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class Controllers {



    @PostMapping("/student/save")
    public Student save(@RequestBody Student student) throws IOException {
        File file = new ClassPathResource("db.csv").getFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile());

        try {

            String content=student.getId()+","+student.getName()+","+student.getAge()+","+student.getStd()+"\n";
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            return student;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAll() throws IOException {
        File file = new ClassPathResource("countries.csv").getFile();

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            String str="";
            int content;
            while ((content = fis.read()) != -1) {

                str+=(char) content;
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
