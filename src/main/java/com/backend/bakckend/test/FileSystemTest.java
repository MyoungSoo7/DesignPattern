package com.backend.bakckend.test;

public class FileSystemTest {

    public static void main(String[] args) throws Exception {

      /* 파일 내용 읽기
       
         Path path = Paths.get("c:\\Java\\temp\\file.txt");
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
        Charset charset = Charset.defaultCharset();

        StringBuffer sb = new StringBuffer();
        int byteCount;
        while((byteCount = fileChannel.read(buffer)) >=0) {
            buffer.flip();
            sb.append(charset.decode(buffer));
            buffer.clear();
        }
        System.out.println(sb);
        fileChannel.close();*/




      /*  파일만들기
      
         String[] data = {"안녕하세요", "반갑습니다", "감사합니다"};

        Path path = Paths.get("c:\\Java\\temp\\file.txt");
        Files.createDirectories(path.getParent());

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        Charset charset = Charset.defaultCharset();
        ByteBuffer buffer;
        int byteCount=0;

        for(int i=0; i<data.length; i++) {
            buffer = charset.encode(data[i]);
            byteCount += fileChannel.write(buffer);
        }

        fileChannel.close();*/

        /* 디렉토리 내에 폴더,파일 목록 가져오기

        Path path = Paths.get("C:\\metanet");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
        for (Path path1 : directoryStream) {
            if(Files.isDirectory(path1)) {
                System.out.println("디렉토리" + path1.getFileName());
            }else  {
                System.out.println("파일 :" +path1.getFileName());
                System.out.println("파일크기 :" + Files.size(path1) + "byte");
            }

        }*/



        /* C드라이브 내용 가져오기
        
        FileSystem fs = FileSystems.getDefault();
        for(FileStore store : fs.getFileStores()){
            System.out.println("드라이버명 : " + store.name());
            System.out.println("파일시스템 : " + store.type());
            System.out.println("전체공간 : " + store.getTotalSpace() + "byte");
            System.out.println("사용가능공간 : " + store.getUsableSpace() + "byte");
            System.out.println("사용중인공간 : " + (store.getTotalSpace() - store.getUsableSpace()) + "byte");

        }
*/

    }
}
