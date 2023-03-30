import java.util.*; 

public class SpellChecker
  {
    ArrayList<String> position = new ArrayList<String>();


    private void transpose(String incorrectWord)
    {
      char[] charList = incorrectWord.toCharArray();
      for(int i = 0; i < charList.length - 1; i++)
        {
          String temp = incorrectWord.substring(0, i) + charList[i + 1] +         
          charList[i] + incorrectWord.substring(i + 2,charList.length);
          position.add(temp);
        }
    }

    public boolean check(String incorrectWord, String wordBank)
    {
      Scanner input = new Scanner(wordBank);
      boolean traverse = true; 
      while(input.hasNext())
        {
          String middle = input.next();
          if(incorrectWord.compareToIgnoreCase(middle) == 0)
          {
            traverse = false; 
          }
        }
      return traverse; 
    }

    private void wrongVowel(String incorrectWord)
    {
      String[] vowels = {"a", "e", "i", "o" , "u"};
      char[] charList = incorrectWord.toCharArray();
      String normal = null;
      for(int i = 0; i < charList.length; i++)
        {
          if(normal.valueOf(charList[i]).compareToIgnoreCase("a") == 0 ||            
             normal.valueOf(charList[i]).compareToIgnoreCase("e") == 0 || 
             normal.valueOf(charList[i]).compareToIgnoreCase("i") == 0 || 
             normal.valueOf(charList[i]).compareToIgnoreCase("o") == 0 ||
             normal.valueOf(charList[i]).compareToIgnoreCase("u") == 0)
            {
              for(int k = 0; k < vowels.length; k++)
                {
                  String temp = incorrectWord.substring(0, i) + vowels[k] +   
                  incorrectWord.substring(i + 1, charList.length);
                  position.add(temp);
                }
            }
        }
    }

    private void doubleLetter(String incorrectWord)
    {
      char[] charList= incorrectWord.toCharArray();
      String holderOne = null;
      String holderTwo = null;

      for(int i = 0; i < charList.length - 1; i++)
      {
          if(holderOne.valueOf(charList[i]).compareToIgnoreCase(holderTwo.valueOf(charList[i +1])) == 0) 
             {
               String temp = incorrectWord.substring(0, i) + incorrectWord.substring(i + 1, charList.length);
               position.add(temp);
             }
      }
    }

    private void omission(String incorrectWord)
    {
      char[] charList = incorrectWord.toCharArray(); 
      String[] alp = {"a", "b", "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q", "r", "s", "t", "u", "v", "w", "x", "y","z"};

      for(int i = 0; i < charList.length + 1; i++)
        {
          for(int k = 0; k < alp.length; k++)
            {
              String temp = incorrectWord.substring(0, i) + alp[k] + incorrectWord.substring(i, charList.length);
              position.add(temp);
            }
        }
      
    }

    public ArrayList correctSentence(String word, String hit)
    {
      ArrayList<String> copy = new ArrayList<String>();
      if(check(word,hit))
      {
        transpose(word);
        wrongVowel(word);
        doubleLetter(word);
        omission(word);
        Scanner input = new Scanner(hit);
        while(input.hasNext())
          {
            String middle = input.next();
            for(int k = 0; k < position.size(); k++)
              {
                if(middle.compareToIgnoreCase(position.get(k)) == 0)
                {
                  copy.add(position.get(k));
                }
              }
          }
      }
      position.clear();
      return copy; 
    }

    
  }
