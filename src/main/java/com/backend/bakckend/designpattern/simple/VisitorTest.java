package com.backend.bakckend.designpattern.simple;

import java.util.ArrayList;
import java.util.Iterator;

abstract class Visitor{
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}

class ListVisitor extends Visitor{
    private String currentDir = "";


    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String savedDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator<Entry> it = directory.iterator();
        while(it.hasNext()){
            Entry entry = it.next();
            entry.accept(this);
        }
        currentDir = savedDir;
    }
}

interface Acceptor{
    public abstract void accept(Visitor v);
}


abstract class Entry implements Acceptor{
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public Iterator iterator() throws FileTreatmentException {    // Iterator의 생성
        throw new FileTreatmentException();
    }
    public String toString(){
        return getName() + " (" + getSize() + ")";
    }
}

class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

class Directory extends Entry{
    private String name;
    private ArrayList<Entry> directory = new ArrayList<Entry>();

    public Directory(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        int size = 0;
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry){
        directory.add(entry);
        return this;
    }

    public Iterator<Entry> iterator(){
        return directory.iterator();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

class FileTreatmentException extends RuntimeException{
    public FileTreatmentException(){}
    public FileTreatmentException(String msg){
        super(msg);
    }
}

public class VisitorTest {

    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory kim = new Directory("Kim");
            Directory lee = new Directory("Lee");
            Directory park = new Directory("Park");
            usrdir.add(kim);
            usrdir.add(lee);
            usrdir.add(park);
            kim.add(new File("diary.html", 100));
            kim.add(new File("Composite.java", 200));
            lee.add(new File("memo.tex", 300));
            park.add(new File("game.doc", 400));
            park.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());

        }catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }
}
