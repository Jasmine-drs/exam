package com.drs.shangxuan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class ShangXuanApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String image = "C:\\Users\\asus\\Desktop\\T}K~P0BW28_`CQ`Y_RDC~_S.png";
//        byte[] data = Util.readFileByBytes(image);
//        System.out.println(Arrays.toString(data));

        InputStreamReader reader = new InputStreamReader(Files.newInputStream(Paths.get(image)));
        char[] a = new char[1024];
        int read;
        while ((read = reader.read(a)) != -1) {
            System.out.println(read);
        }
    }

}
