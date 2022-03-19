# java-unix-pipes
Support for unix pipes in java

The project is at its early stages, provide feedback when something does not work :)

### Sample Usage
```java
import com.github.bogdanlivadariu.jpipe.PipeRuntime;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Foo {

    @Test
    public void bar() throws IOException {
        String firstOutput = PipeRuntime.exec("ls -a | grep src");
        String secondOutput = PipeRuntime.exec("ls -a | grep src | cut -c1-2");

        System.out.println("firstOutput: " + firstOutput);
        System.out.println("secondOutput: " + secondOutput);
    }
}

// output
// firstOutput: src
// secondOutput: sr
```
