# library-management-coding-challenge

tools to run this app:
1. IntelliJ
2. Java 8

Steps to run in your local machine:
1. download the source code zip file and extract it in library-system folder in your local machine.
2. the structure of your folder should be like below
    <br>library-system
    <br>  pom.xml
      <br>  README.md
     <br>   src
3. open the project in IntelliJ 
4. start the application from IntelliJ by clicking on start button.

Now the application should start and can be accessed on http://localhost:8080/api/books

To get a list of all the books in library run this command in terminal/command prompt<br>
curl http://localhost:8080/api/books

 To get a list of all members on library<br>
 curl http://localhost:8080/api/members
 
 To add a book in library (mandatory parameters are "title", "author" and "category") <br>
 curl -H "Content-Type:application/json" -X POST -d '{"title":"Book 10","author":"Demo Author","category":["category4"],"loanedBy":0,"loanedDate":null,"returnedDate":null}' http://localhost:8080/api/book
 
 To delete a book from library<br>
 curl -H "Content-Type:application/json" -X DELETE -d '{"title":"Book 10"}' http://localhost:8080/api/deletebook
 
 To loan a book to a member<br>
 curl -H "Content-Type:application/json" -X POST -d '{"memberId":3,"title":"Book 4"}' http://localhost:8080/api/loanbook
 
 To return a book to library<br>
 curl -H "Content-Type:application/json" -X POST -d '{"memberId":3,"title":"Book 4"}' http://localhost:8080/api/returnbook
 
 To get a list of all outstanding books<br>
 curl http://localhost:8080/api/outstandingbooks
 
