//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    private int openBracket;
    private int closeBracket;
    private int openParen;
    private int closeParen;
    private ArrayList<String> toReturn = new ArrayList<>();
    
    public ArrayList<String> getLinks(String markdown) {

        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            gatherIndices(markdown, currentIndex);
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }

    private void gatherIndices(String markdown, int currentIndex) {
        openBracket = markdown.indexOf("[", currentIndex);
        closeBracket = markdown.indexOf("]", openBracket);
        openParen = markdown.indexOf("(", closeBracket);
        closeParen = markdown.indexOf(")", openParen);
    }


    public static void main(String[] args) throws IOException {
        MarkdownParse fileFinder = new MarkdownParse();
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = fileFinder.getLinks(content);
	    System.out.println(links);
    }
}
