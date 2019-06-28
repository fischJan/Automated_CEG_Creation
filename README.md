# Automated_CEG_Creation
This project aims at developing an algorithm for the automated transfer of structured requirements / pseudo code into Cause Effect Graphs (CEG). The algorithm comprises two functionalities: 1) syntax analysis of the pseudo code by means of ANTLR and 2) semantic analysis of the parse tree by a implemented visitor pattern. 

**How to test the code?**
1) Clone the repository to your machine and import it to your favorite IDE (e.g. eclipse).
2) Open the folder "MyVisitor" and open the file "example.txt".
3) Add the pseudo code section that should be transformed into a CEG (ATTENTION: we implemented a loosely defined grammar in order to avoid limiting the vocabulary too much. However, you should use the logical constructs "IF", "THEN", "ELSE", "AND" etc. to structure your requirement. For a more detailed explanation please refer to the defined grammar within the "Parser" folder.)
4) After inserting the pseudo code section, just start the main method.
5) The method creates the parse tree and traverses the tree to create the corresponding CEG. 
6) The final CEG is given in a .dot file. Just copy the content of this into a "Graphviz" editor (e.g. https://dreampuf.github.io/GraphvizOnline/) and enjoy the CEG. 

**Ideas for improvement?**

We welcome any kind of feedback! Just shoot me a email or private message.
