package com.backend.bakckend.designpattern.interpreter;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

abstract class Node {
    abstract void parse(Context context) throws ParseException;
}
class ProgramNode extends Node {
    private Node commandListNode;
    void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}

class CommandListNode extends Node{
   private Vector list = new Vector();

    void parse(Context context) throws ParseException {
         while(true){
              if(context.currentToken() == null){
                throw new ParseException("Missing 'end'", 0);
              }else if(context.currentToken().equals("end")){
                context.skipToken("end");
                break;
              }else{
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
              }
         }
    }

    public String toString() {
        return list.toString();
    }
}

class CommandNode extends Node{
    private Node node;
    void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")){
            node = new RepeatCommandNode();
            node.parse(context);
        }else{
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }
    public String toString() {
        return node.toString();
    }
}

class RepeatCommandNode extends Node{
    private int number;
    private Node commandListNode;
    void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}

class PrimitiveCommandNode extends Node{
    private String name;
    void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if(!name.equals("go") && !name.equals("right") && !name.equals("left")){
            throw new ParseException(name + " is undefined", 0);
        }
    }
    public String toString() {
        return name;
    }
}

class Context{
   private StringTokenizer tokenizer;
   private String currentToken;
   public Context(String text){
       tokenizer = new StringTokenizer(text);
       nextToken();
   }
   public String nextToken(){
       if(tokenizer.hasMoreTokens()){
           currentToken = tokenizer.nextToken();
       }else{
           currentToken = null;
       }
       return currentToken;
   }
   public String currentToken(){
       return currentToken;
   }
    public void skipToken(String token) throws ParseException {
         if(!token.equals(currentToken)){
              throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.", 0);
         }
         nextToken();
    }
    public int currentNumber() throws ParseException {
         int number = 0;
         try{
              number = Integer.parseInt(currentToken);
         }catch(NumberFormatException e){
              throw new ParseException("Warning: " + e, 0);
         }
         return number;
    }

}

class ParseException extends Exception{
    public ParseException(String msg, int errorPos){
        super(msg);
    }
}


public class InterpreterTest {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
            String text;
            while((text = reader.readLine()) != null){
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
