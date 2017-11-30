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

The download is library.jar file. Once you add this to your classpath, you will be able to use the API. All the public API methods can be found in API Specification. [link]

## Additional option:
Instructions to compile in Windows OS.
```sh
// Create a folder to store the source files in:  
mkdir LibraryAPI  
cd LibraryAPI  

//Create a folder inside for the compiled source files:  
mkdir build  

//Compile all of the source files (.java) in the folder, add -g in order to compile with debug info:  
javac -d (-g) build \*.java  

//Build the .jar file  
jar cvf LibraryAPI.jar build/.  
```

 
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

## More Samples
The following sample may help you get started using the client library:
>libClient-cmdline-sample
