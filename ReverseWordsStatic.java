import java.util.*;

/* functor that converts an imput string to a list of reversed words */
/* Input string can be given as set of space-separated command-line  */
/* arguments or as a single quoted string */


public class ReverseWordsStatic
   {
   public static List<String>reverse(String input) throws Exception
     {
     String working = input.trim();

     if (working.length() == 0)
        throw new Exception();
        
     List<String> result = new ArrayList<String>();

     if (input.length() < 3)
        {
        result.add(input);
        return result;
        }

     int guess = working.length()-1;

     for (int idx = working.length()-2; idx > 0; --idx)
        {
        if ( Character.isWhitespace( working.charAt(idx) ) )
            continue;

        if ( (guess - idx) > 1)
           {
           result.add(working.substring(guess));
           working = working.substring(0,idx+1);
           guess = working.length()-1;
           }
        else
           {
           --guess;
           }
        }

        if ( guess > 1 )
           {
           result.add(working.substring(guess)); 
           result.add(working.substring(0,2));
           }
        else
          {
          result.add(working);
          }

     return result;
     }


   public static void main (String [] args)
      {
      String allwords;

      try 
        { 
      if (args.length < 2)
         {
         allwords = new String(args[0]);
         }
      else
         {
         allwords = new String();
         for (int i = 0; i < args.length; ++i)
           {
           allwords = allwords.concat(args[i]) + " ";
           allwords.trim();
           }
         }
    
        List<String> reversed_words = ReverseWordsStatic.reverse(allwords);

        for (int i = 0 ; i < reversed_words.size(); ++i)
           {
           System.out.println(reversed_words.get(i) + " ");
           }
        }
      catch (Exception e)
        {
        System.err.println("Error: Empty input string.");
        System.err.println(e.toString());
        }
      }
   }

