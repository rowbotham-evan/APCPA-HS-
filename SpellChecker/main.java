import java.util.*; 

class Main 
{
  public static void main(String[] args) 
  {
    // Objects 
    SpellChecker check = new SpellChecker(); 
    TextLoader tl = new TextLoader("top500words.txt");
    Scanner scan = new Scanner(tl.getFile());
    Scanner userInput = new Scanner(System.in);

    // Vars 
    boolean rerun = true;
    String dictionary = ""; 
    String output = "";
    String response = "";

    while(scan.hasNext())
      {
        dictionary = dictionary + " " + scan.next(); 
      }
    System.out.println("Enter a sentence to be corrected:");
    String userSentence = userInput.nextLine(); 
    System.out.println("Please answer the following prompts with yes or no."); 
    Scanner interpret = new Scanner(userSentence);
    String word;
    while(interpret.hasNext())
      {
        word = interpret.next();
        ArrayList mockList = check.correctSentence(word, dictionary);
        ListIterator mockIterator = mockList.listIterator();
        boolean choice = true;
        if(mockList.size() > 0)
        {
          while(choice)
            {
              System.out.println("Did you mean: " + mockIterator.next());
               response = userInput.nextLine();
              if(response.compareToIgnoreCase("yes") == 0)
              {
                output = output + " " + mockIterator.previous();
                choice = false;
              }
              else if(!mockIterator.hasNext())
              {
                output += " " + word; 
                choice = false; 
              }
            }
          
        }
        else
        {
          output += " " + word; 
        }
    
      }
    
       System.out.println("The revised sentence is: ");
        System.out.println(output.substring(1, output.length()));
    
    
  }
}
