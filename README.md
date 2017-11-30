# Library API
Library API is a simple Java library.
It helps in everyday tasks, such as 
- processing borrows, returns of books, 
- managing library's users,
- keeping watch of the requests of books, which users would like to read.

## Prerequisites 
Supported Java environments:
- Java SE Runtime Environment 7 or higher
- Java Development Kit 7 or higher (for compiling)

## Installation
To use Library API you need to download its latest version. [link] 
The download is Library.jar file. Once you add it to your classpath, you will be able to use the API. All the public API methods can be found in API Specification. [link]

### IDEs
You can also download corresponding "-sources" file, which is a jar file of the source code suitable for linking to the jar file in IDEs such as Eclipse or IntelliJ IDEA. [link]

## Implementation
The Library class can be instantiated and used as simple as that:

```java
import se.lib.*;

class YourClientClass {
    
    //some fields...
    
    Library lib = new Library();
    
    //some other methods...
    
    void yourLibraryMethod() {
        lib.addUser("John Doe");
        lib.newRequest("Clean Code", "Uncle Bob", "0-123456789-10");
    }
}
```

## Sourcecode
In order to get the sourcecode please unzip the Library-sources.jar to get the plain .java files of se.lib package.