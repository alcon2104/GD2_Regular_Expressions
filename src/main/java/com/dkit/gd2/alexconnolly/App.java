package com.dkit.gd2.alexconnolly;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular expressions
 * Basically lets you validate input
 * So if you entered an email as '123'
 * The code will go "HEY THERE'S A STRUCTURE FOR EMAILS AND THAT AIN'T IT"
 *
 */
public class App {
    public static void main(String[] args)
    {
        //stringRegularExpressions();
        //alphaNumericRegularExpressions();
        //alphaNumericRegularExpressionsMatches();
        //alphaNumericEndFindMultipleCharactersRegEx();
        //alphaNumericRangesRegEx();
        //whitespaceRegEx();
        //specificNumberOccurencesRegEx();
        //introToPatternMatcher();
        //findOccurrencesPatternMatcher();
        //findOccurrencesPatternMatcherGroup();
        //orAndRegularExpressions();
        //whyWeNeedNegativeLookAheadRegEx();
        //negativeLookAheadRegEx();
        //usPhoneNumberRegex();

        //challenges start here
        //visaRegex();
        //challengeOne();
        //challengeTwo();
        //challengeThree();
        //challengeFour();
        //challengeFive();
        //challengeSix();
        //challengeSeven();
        challengeEight();
        //challengeNine();
        //challengeTen();
        //challengeEleven();
        //challengeTwelve();
        //challengeThirteen();
        //challengeFourteen();

    }

    private static void stringRegularExpressions()
    {
        //a string is a regular expression
        String testString = "I like bikes. So I suck.";
        System.out.println(testString);
        String replacementString = testString.replaceAll("I", "You");
        System.out.println(replacementString);
    }

    private static void alphaNumericRegularExpressions()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric);
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println("\n");
        //Expected = "YYYF12Ghhiiiiijkl99z"
        System.out.println(alphanumeric.replaceAll
                ("^abcDeee", "YYY"));
        System.out.println("\n");
        String alphanumeric2 = "abcDeeeF12GhhabcDeeeiiiiiijkl99z";
        //Expected = "YYYF12Ghhiiiiijkl99z"
        System.out.println(alphanumeric2.replaceAll
                ("^abcDeee", "YYY"));
    }

    private static void alphaNumericRegularExpressionsMatches()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println("\n");
        //using matches only returns true if it's matching the entire string, so no partial
        //matches
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiiiijkl99z"));
    }

    private static void alphaNumericEndFindMultipleCharactersRegEx()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "END"));
        System.out.println("\n");
        System.out.println(alphanumeric.replaceAll("[aei]",
                "something longer"));
        System.out.println("\n");
        //CHALLENGE - Replace any a, e, or i that is followed by and F or j with x
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "x"));
        System.out.println("\n");
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
    }

    private static void alphaNumericRangesRegEx()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        //replace anything that isn't e or j (hat in [] does this)
        System.out.println(alphanumeric.replaceAll("[^ej]","x"));
        System.out.println("\n");
        //Regular Expressions are case sensitive
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        //You can also make them forget cases exist with (?i)
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println("\n");
        //These will both do the same thing (\\d will find digits)
        System.out.println(alphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(alphanumeric.replaceAll("\\d", "X"));
        //This one finds everything that isn't a digit
        System.out.println(alphanumeric.replaceAll("\\D", "X"));
    }

    private static void whitespaceRegEx()
    {
        String whitespace = "I have blanks and \t a tab and a \n newline";
        System.out.println(whitespace);

        // \\s will find whitespace, \S will find stuff that isn't whitespace
        System.out.println(whitespace.replaceAll("\\s", ""));
        System.out.println(whitespace.replaceAll("\\S", "x"));
        // Replace tab with an x
        System.out.println(whitespace.replaceAll("\t", "x"));
        // Replace newline with an x
        System.out.println(whitespace.replaceAll("\n", "x"));
        // \\w is any word character [a-zA-Z_0-9]
        System.out.println(whitespace.replaceAll("\\w", "x"));
        // \\w is everything but word characters [a-zA-Z_0-9]
        System.out.println(whitespace.replaceAll("\\W", "x"));
        // \\b marks all boundaries of characters
        System.out.println(whitespace.replaceAll("\\b", "x"));
    }

    private static void specificNumberOccurencesRegEx()
    {
        String alphanumeric = "abcDeeeF12Ghhiiiiiijkl99z";
        //curly brackets specify number of occurrences of a character
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println("\n");
        //+ means 1 or more occurrences
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println("\n");
        //* means 0 or more occurrences
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println("\n");
        //Putting a range in {} means any number of occurences between 2 and 5 will be changed
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println("\n");
        //Challenge - replace any number of h's (at least 1 needs to be there) followed
        //by a number of i's, followed by a j with Y
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y"));
    }

    private static void introToPatternMatcher()
    {
        //StringBuilder is a mutable String (can be changed) , Strings are immutable (can't)
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1");
        htmlText.append("<h2>Subheadings</h2>");
        htmlText.append("<p>This is a Paragraph about something</p>");
        htmlText.append("<p>This is another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>One last paragraph about the summary</p>");

        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(matcher.matches());
    }

    private static void findOccurrencesPatternMatcher()
    {
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1>");
        htmlText.append("<h2>Subheadings</h2>");
        htmlText.append("<p>This is a Paragraph about something</p>");
        htmlText.append("<p>This is another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>One last paragraph about the summary</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;

        while(matcher.find())
        {
            count++;
            System.out.println("Occurrence " +count + ": " +matcher.start() + " to "
            + matcher.end());
        }
    }

    private static void findOccurrencesPatternMatcherGroup()
    {
        StringBuilder htmlText = new StringBuilder("<h1>Page Heading</h1>");
        htmlText.append("<h2>Subheadings</h2>");
        htmlText.append("<p>This is a Paragraph about something</p>");
        htmlText.append("<p>This is another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>One last paragraph about the summary</p>");

        //Groups surrounded by ()
        //? will have the group stop at the first </h2> rather than the second one
        String h2GroupPattern = "(<h2>)(.*?)(</h2>)";
        Pattern grouppattern = Pattern.compile(h2GroupPattern);
        Matcher groupmatcher = grouppattern.matcher(htmlText);
        System.out.println(htmlText);
        System.out.println(groupmatcher.matches());

        while(groupmatcher.find())
        {
            System.out.println("Occurrence: " +groupmatcher.group(1));
        }

        groupmatcher.reset();

        while(groupmatcher.find())
        {
            System.out.println("Occurrence: " +groupmatcher.group(2));
        }
    }

    private static void orAndRegularExpressions()
    {
        //"abc" -> "a" and "b" and "c"
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));
    }

    private static void whyWeNeedNegativeLookAheadRegEx()
    {
        //[^abc]
        String tvTest = "tstvtkt";
        String tNotVRegEx = "t[^v]";

        Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while(tNotVMatcher.find())
        {
            count++;
            System.out.println(tvTest);
            System.out.println("Occurrence " + count + ": " + tNotVMatcher.start() + " to "
            + tNotVMatcher.end());
        }

        //We need negative look ahead regex because the last occurrence isn't shown,
        //because nothing appears after it
    }

    private static void negativeLookAheadRegEx()
    {
        //[^abc]
        String tvTest = "tstvtkt";
        String tNotVRegEx = "t(?!v)";

        Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while(tNotVMatcher.find())
        {
            count++;
            System.out.println(tvTest);
            System.out.println("Occurrence " + count + ": " + tNotVMatcher.start() + " to "
                    + tNotVMatcher.end());
        }
    }

    private static void usPhoneNumberRegex()
    {
        //(800) 123-4567
        String phone1 = "1234567890"; //Won't match-nothing makes it a phone number
        String phone2 = "(123) 456-7890"; //Will match
        String phone3 = "123 456-7890"; //Won't match-no brackets
        String phone4 = "(123)456-7890"; //Won't match-no space
        String phone5 = "***(123) 456-7890"; //Won't match-stuff before the brackets

        // \\( makes the ( not make a group
        String usPhoneNumberRegex = "^[\\(]{1}[\\d]{3}[\\)]{1}[ ]{1}[\\d]{3}-" +
                "[\\d]{4}$";

        System.out.println("phone1 = " +phone1.matches(usPhoneNumberRegex));
        System.out.println("phone2 = " +phone2.matches(usPhoneNumberRegex));
        System.out.println("phone3 = " +phone3.matches(usPhoneNumberRegex));
        System.out.println("phone4 = " +phone4.matches(usPhoneNumberRegex));
        System.out.println("phone5 = " +phone5.matches(usPhoneNumberRegex));
    }

    private static void visaRegex()
    {
        //Visa has to start with 4, can have either 13 or 16 digits in total
        //4444444444, 13 4's and starts with 4 - valid
        //4444444444444444, 16 4's and valid
        //57777, invalid
        //4444, invalid
        //444444444444444444444444444, invalid

        String visa1 = "4444444444444"; //valid
        String visa2 = "5444444444444"; //invalid
        String visa3 = "4444444444444444"; //valid
        String visa4 = "4444"; //invalid

        String visaRegex = "^4(\\d){12}$|^4(\\d){15}$";
        System.out.println("Visa 1: " +visa1.matches(visaRegex));
        System.out.println("Visa 2: " +visa2.matches(visaRegex));
        System.out.println("Visa 3: " +visa3.matches(visaRegex));
        System.out.println("Visa 4: " +visa4.matches(visaRegex));
    }

    private static void challengeOne()
    {
        //write the string literal regex that will match the following string
        //use String.matches() to test it

        String challenge1 = "I want a bike\\.";
        System.out.println(challenge1.matches("I want a bike."));
    }

    private static void challengeTwo()
    {
        //Write a regex that will match the two strings below. Use matches()

        String challenge1 = "I want a bike\\.";
        String challenge2 = "I want a ball\\.";

        String regEx = "I want a .*[.]";
        String regExJohn = "I want a \\w+.";
        String regExJohn2 = "I want a (bike|ball)).";
        String regExJohn3 = "I want a \\w+.";
        System.out.println(challenge1.matches(regEx));
        System.out.println(challenge2.matches(regEx));
    }

    private static void challengeThree()
    {
        //In challenge 2 we used String.matches()
        //use Matcher.matches to check for matches
        //compile regular expression

        String challenge1 = "I want a bike\\.";
        String challenge2 = "I want a ball\\.";

        String regEx = "I want a .*[.]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);
        System.out.println(matcher.matches() + ", " +matcher2.matches());
    }

    private static void challengeFour()
    {
        //Replace all occurrences of whitespace with _ in this string.
        //Print the new String

        String challenge4 = "Replace all blanks with whitespaces";
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }

    private static void challengeFive()
    {
        //Write a regex to match the string below with .matches();
        String challenge5 = "aaabccccccccdddefffg";
        String regex = "[a-g]+";
        System.out.println(challenge5.matches(regex));
    }

    private static void challengeSix()
    {
        //Write a regular expression that will match challenge 5's string in its
        //entirety

        String challenge5 = "aaabccccccccdddefffg";
        String regex = "^a{3}bc{8}d{3}e{1}f{3}g$";

    }

    private static void challengeSeven()
    {
        //write a regex for a string that starts with a series of letters followed
        //by a . and then there are a series of digits. "kjsl.22"
        String challengeSeven = "abcd.135";
        //If you wanna match a dot you gotta \\
        String regex = "^[A-Za-z]+\\.[0-9]+$";
        System.out.println(challengeSeven.matches(regex));
    }

    private static void challengeEight()
    {
        //Modify challenge 7 regex to use a group so we can print out digits that
        //occur in a string that has multiple occurrences of the pattern. Use
        //Pattern, Matcher. Output should be 135, 7, 999

        String challenge8 = "abcd.135usqv.7tzik.999";
        String regex = "[A-Za-z]+\\.([0-9]+)";

        Pattern grouppattern = Pattern.compile(regex);
        Matcher groupmatcher = grouppattern.matcher(challenge8);

        while(groupmatcher.find())
        {
            System.out.println("Occurrence: " +groupmatcher.group(1));
        }

    }

//    private static void challengeNine()
//    {
//
//    }
}

