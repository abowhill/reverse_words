import java.util.*;

// Reverse words contained in a string.

public class ReverseWords
   {
   private String words;
   private List<String> reversed_words;

   ReverseWords()
      {
      }

   ReverseWords(String inputWords)
      {
      words = inputWords.trim();
      }

   public void init()
      {
      try
         {
         reversed_words = this.reverse(words);
         }
      catch (Exception e) 
         {
         System.out.println("Empty String passed in as Argument.");
         }
      }

   public void printWords()
      {
      for (int i = 0 ; i < reversed_words.size(); ++i)
         {
         System.out.print(reversed_words.get(i) + " ");
         }
      }

   // Function: reverse()
   // preconditions: input string was trimmed.
   // error condition: input string is empty
   // assumption: first and last characters are non-whitespace
   // input: string to reverse words from
   // output: array of strings of words, reversed
   //

   public List<String> reverse(String input) throws Exception
     {
     /* PRE-LOOP */

     // Handle input cases:
     // CASE 1: empty string                  An exception is thrown when the function is sent an empty input string, which is an error.
     // CASE 2: one or two character string   In the pre-loop, a check is made to verify the string length is one or two characters. If so, the string is already reversed, so return list containing word.
     // CASE 3: three or more letter string   Iterate over string, ignoring first and last chars. Find word boundaries, add to list. Right-trunc as we go.

     // CASE 1: throw exception if input string is empty
     if (input.length() == 0)
        throw new Exception();
        
     // setup empty dynamic array of Strings to return to caller
     List<String> result = new ArrayList<String>();

     // CASE 2: string is one or two characters long, so return as-is
     if (input.length() < 3)
        {
        result.add(input);
        return result;
        }

     // CASE 3: string is 3 or more characters long

     // establish working copy of input string 
     String working = new String(input);

     // init guess index, marker of potential beginning of rightmost word in working string
     int guess = words.length()-1;

     /* IN-LOOP: iterate backwards between last and first chars in working string, searching for word boundaries.  */
     /* When boundary is found, extract rightmost word, assign to result list, and truncate it from working string */
     /* the point of this loop is to discover what's inside the string, and act accordingly                        */

     for (int idx = working.length()-2; idx > 0; --idx) // don't iterate over non-whitespace end characters in working string. we trimmed it already.
        {
        // test-for and gobble whitespace
        if ( Character.isWhitespace( working.charAt(idx) ) )
            continue;

        // Non-whitespace: at this point we have either found a boundary, or are somewhere in a word.

        // boundary check: if we previously gobbled any whitespace, it shows as a word boundary by a larger difference between indexes
        if ( (guess - idx) > 1)
           {
           // we have discovered a word boundary so add word to list 
           result.add(working.substring(guess));

           // right-truncate the word out of the working string
           working = working.substring(0,idx+1);

           // relocate guess to last char position of new working string
           guess = working.length()-1;
           }
        else // we are in word somewhere so must continue looking for boundary
           {
           --guess;
           }
        }

        // POST-LOOP: leftovers. Determine if we are left with ether one or two words, assign them to list and return.
        
        if ( (guess > 1) ) // we have two words, a left one (one char long) and a right one n chars long
           {
           result.add(working.substring(guess)); // add rightmost string to result
           result.add(working.substring(0,2));   // add leftmost string to result
           }
        else // we have one word
          {
          result.add(working); // add rightmost string to list
          }
     return result;
     }



   // driver that takes arguments as array and passes it as a string
   public static void main (String [] args)
      {
      String allwords;
      if (args.length < 2)
         {
         // CASE 1: user enters single string to reverse encloded in quotes
         allwords = new String(args[0]);
         }
      else
         {
         // CASE 2: user enters string without quotes
         // if args are more than length one, concat into single string
         allwords = new String();
         for (int i = 0; i < args.length; ++i)
           {
           allwords = allwords.concat(args[i]) + " ";
           allwords.trim();
           }
         }
      ReverseWords Reverser = new ReverseWords(allwords);
      Reverser.init();
      Reverser.printWords();
      }
   }

