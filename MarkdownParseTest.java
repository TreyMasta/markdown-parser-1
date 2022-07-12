import org.junit.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void correctLinks1() throws IOException {
        String content = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks2() throws IOException {
        String content = Files.readString(Path.of("test-file2.md"));
        assertEquals(List.of("https://google.com", "some-thing.html"), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks3() throws IOException {
        String content = Files.readString(Path.of("test-file3.md"));
        assertEquals(List.of("more text here"), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks4() throws IOException {
        String content = Files.readString(Path.of("test-file4.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks5() throws IOException {
        String content = Files.readString(Path.of("test-file5.md"));
        assertEquals(List.of("page.com"), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks6() throws IOException {
        String content = Files.readString(Path.of("test-file6.md"));
        assertEquals(List.of("page.com"), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks7() throws IOException {
        String content = Files.readString(Path.of("test-file7.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(content));
    }

    @Test
    public void correctLinks8() throws IOException {
        String content = Files.readString(Path.of("test-file8.md"));
        assertEquals(List.of("a link on the first line"), MarkdownParse.getLinks(content));
    }

    //dbfbijds
    @Test
    public void failTest() {
        assertEquals(4, 1 + 1);
    }
    
}