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
    public void correctLinks() throws IOException {
        String content = Files.readString(Path.of("test-file2.md"));
        assertEquals(List.of("https://google.com", "some-thing.html"), MarkdownParse.getLinks(content));
    }
}