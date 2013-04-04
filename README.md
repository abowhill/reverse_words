What is this?
=============

This is a pair of `Java` programs which perform the notorious interview-question task of reversing words in a sentence. I wrote this after failing a phone screen in which I was given an hour to code it while the interviewer waited on the other end of the line, nose-breathing. 

Surprisingly, to perform this task correctly there is quite a bit of analysis that has to go into it. It can be solved a number of ways, but this implementation is iterative, with considerations taken for various special cases. I'm not a big fan of recursion, so my answer naturally involves more code.

ReverseWords.java is a class and driver to reverse words given as an argument list on stdin.

ReverseWordsStatic.java does exactly the same thing, but as a Functor.

Features
--------

* Iterative solution. 

* Full analysis of the problem, included as comments to ReverseWords.java

* Implemented as a single function as a static Functor class in ReverseWordsStatic.java 


Input and Output
----------------

To compile the java classes use: `javac ReverseWords.java ReverseWordsStatic.java`

After compiling these java classes, you can run them by supplying the list of words to reverse as arguments on the command-line:

`java ReverseWordsStatic Now is the time for all good men to come to the aid of their country.`

Which will result in the following dump to stdout:

	country.
	their
	of
	aid
	the
	to
	come
	to
	men
	good
	all
	for
	time
	the
	is
	Now

* Alternately, the same result will be obtained if the sentence is passed as a single parameter contained in quotes:

`java ReverseWordsStatic "Now is the time for all good men to come to the aid of their country.`

Description
------------

First, two special cases are eliminated before any work is done to search the string:

1. Zero-length input string. This is handled by throwing an exception.
2. Input string is one or two characters long. This is sent straight to stdout, as the word is already reversed. We don't need to know if there is a space separating the characters. Even if the "words" are only one character long, we can't possibly have two of them because it would require the presence of a third character as a space seperator.

Next, the input is traversed backwards, identifying word boundaries along the way. A `guess index` serves as a marker to the start of the rightmost word while another index searches ahead for whitespace to consume. When inside a word, both indexes keep pace with each other. But when the second index passes the first by more than a character's distance, it means a boundary has been identified, and the word is right-truncated out of the input string and pushed onto the output string.


Caveats
-------

This program has only been lightly tested, and is still under development. I've tried my best to describe its behavior, but there are probably hidden behaviors I am unaware of. Therefore I accept no liability in the use of this program, nor do I give any warranty for its use.


