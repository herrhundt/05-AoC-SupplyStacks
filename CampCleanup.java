import java.io.*;
import java.util.*;

public class CampCleanup
{
  //static String filename = "input-sample.txt"; //for testing purposes 
  static String filename = "input.txt"; //the original input 
    
  static String [] input;
  static Stack<Character>[] stacks; 
  static Stack<Character> tempStack; 
  static String operation; 
  static int n, from, to; 
  
  
  public static void solvePuzzlePartTwo() //new crane version
  {
      tempStack = new Stack<Character>();
      for(int i=0; i<input.length;i++)
     {
         operation = input[i]; //fetch code 
         operation = operation.replace("move ",""); //remove text move 
         operation = operation.replace("from ",""); //remove text from 
         operation = operation.replace("to ",""); //remove text to 
         
         String[] opcodes = operation.split(" "); 
         n = Integer.parseInt(opcodes[0]);  
         from = Integer.parseInt(opcodes[1]); 
         to =Integer.parseInt(opcodes[2]); 
 
         System.out.println("Move "+n+" from "+from+" to "+to);
         for(int j=0; j<n;j++)
         {
             tempStack.push(stacks[from-1].pop()); //new crane version 
             
         }
         for(int j=0; j<n;j++)
         {
             stacks[to-1].push(tempStack.pop());  //pop from --> push to (index shift!)
         }
         printStacks(); 
     }
     for(int i=0; i<stacks.length;i++)
     {
         System.out.print(stacks[i].pop());
     }
  }  
  public static void solvePuzzle() //part one 
  {
      for(int i=0; i<input.length;i++)
     {
         operation = input[i]; //fetch code 
         operation = operation.replace("move ",""); //remove text move 
         operation = operation.replace("from ",""); //remove text from 
         operation = operation.replace("to ",""); //remove text to 
         
         String[] opcodes = operation.split(" "); 
         n = Integer.parseInt(opcodes[0]);  
         from = Integer.parseInt(opcodes[1]); 
         to =Integer.parseInt(opcodes[2]); 
 
         System.out.println("Move "+n+" from "+from+" to "+to);
         for(int j=0; j<n;j++)
         {
            stacks[to-1].push(stacks[from-1].pop());  //pop from --> push to (index shift!)
         }
         printStacks(); 
     }
     for(int i=0; i<stacks.length;i++)
     {
         System.out.print(stacks[i].pop());
     }
  }  

  public static void printStacks()
  {
      for (int i=0; i<stacks.length;i++)
      {
         System.out.print("["+i+"]:");
         for (int j=0; j<stacks[i].size();j++)
         {
             System.out.print(stacks[i].elementAt(j)+",");
          }
          System.out.println(); 
        }
  }
  
  public static void createStacks(int n)
    {
        stacks = new Stack[n]; 
        for(int i=0; i<n;i++)
        {
            stacks[i] = new Stack<Character>(); //Stack erzeugen   
        }
    }
    public static void loadStack(int n, String words)
    {
        for(int i=0; i<words.length();i++)
        {
            stacks[n].push(words.charAt(i)); //load words onto stack 
        }
    }
    
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new String[arraySize]; //Erstelle leeres Array mit der Anzahl 
    
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
         input[i] = br.readLine();
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
