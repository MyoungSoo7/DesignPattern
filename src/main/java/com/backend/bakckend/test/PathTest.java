package com.backend.bakckend.test;

import java.nio.file.Path;
import java.util.Iterator;

public class PathTest {
    public static void main(String[] args) {
        try {
            Path path = Path.of("C:\\windows\\system32\\drivers\\etc\\hosts");

            System.out.println("파일이름 :" + path.getFileName());
            System.out.println("상위폴더 :" + path.getParent().getFileName());
            System.out.println("경로길이 :" + path.getNameCount());

            System.out.println("현재경로 : " );
            for (int i = 0; i < path.getNameCount(); i++) {
                System.out.println(path.getName(i));
            }

            Iterator<Path> iterator = path.iterator();
            System.out.println("\n 현재경로 : ");
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getFileName() + "\\" );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
