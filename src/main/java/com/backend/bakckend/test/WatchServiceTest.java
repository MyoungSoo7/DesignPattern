package com.backend.bakckend.test;

import java.nio.file.*;

public class WatchServiceTest {

    public static void main(String[] args) {
        try{

            WatchService ws = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("c:\\Java\\temp");
            path.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            while(true){
                WatchKey key = ws.take();
                for(WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path p = (Path) event.context();
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println( p.getFileName());
                    }
                }
                boolean valid = key.reset();
                if(!valid){
                    break;
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
