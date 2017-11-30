# Library API
Library API is a simple Java library.
It helps in everyday tasks, such as 
- processing borrows, returns of books, 
- managing library's users,
- keeping watch of the requests of books, which users would like to read.

## Prerequisites 
Supported Java environments:
- Java SE Runtime Environment 7 or higher

## Installation
To use Library API you need to download its latest version. [link] 

The download is library.jar file. Once you add this to your classpath, you will be able to use the API. All the public API methods can be found in API Specification. [link]

## Additional option:
Instructions to compile in WIN OS.

-Create a folder to store the source files in:  
mkdir LibraryAPI  
cd LibraryAPI  
-Create a folder inside for the compiled source files:  
mkdir build  
-Compile all of the source files (.java) in the folder, add -g in order to compile with debug info:  
javac -d (-g) build \*.java  
-Build the .jar file  
jar cvf LibraryAPI.jar build/.  


 
### IDEs
Add library.jar as a one of your dependencies in your project. [link] 


## Samples
The following sample may help you get started using the client library:
>libClient-cmdline-sample
