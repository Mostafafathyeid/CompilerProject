# compiler project

this project is a dynamic code analyzer for Java Language to generate statement and branches
code coverage reports.

## 1) Testing the grammer :
 we use intellij program using antlr we used use ANTLR Java grammar, like the one provided at this https://github.com/antlr/grammars-v4/tree/master/java/java
***
after we test the grammer this sopme of generatinng parse trees :
#### tree 1:

![Tree](https://user-images.githubusercontent.com/66316400/226891247-040fe2d3-96ac-458b-abcd-9a0a27bd97f2.jpeg)

#### tree 2:

![parse tree jpg](https://user-images.githubusercontent.com/66273172/226969305-a388cf88-8fee-4fee-8df6-3921803e3f93.png)

#### tree 3:

![WhatsApp Image 2023-03-22 at 19 08 44](https://user-images.githubusercontent.com/93389696/226983652-7b093bab-048b-44eb-92a6-c90a5ed06d75.jpg)
***

## 2) generating output jave file :
- ### first :
we Wrote a Java program based on Antlr that takes a java file as an input and outputs a
modified intermediate java file (injected code) as demonstrated in the section
where:
we added a comment in each block of this code indicates the number of this block , it
should look like this :

// block number 3
#### input file :

![infile](https://user-images.githubusercontent.com/66273172/228575143-9f38c423-c7b3-450d-a696-25af641cf557.png)

#### output file:
![out](https://user-images.githubusercontent.com/66273172/228575129-d1cd4ad9-8dd0-43cd-b393-cf7e01ef1c0d.png)

- ### second:

when you run The modified intermediate java file (generated from the previous step)
to know which blocks of the code are visited (A file has to be generated after the
program run that shows which blocks are visited) and stamentent coverd.
the file should look like this

 block number 1 is visited

 block number 3 is visited
#### modified java file :
![modifiied](https://user-images.githubusercontent.com/66273172/232833632-20af2025-b202-47bc-9c64-2e5bf21f5420.png)

#### first output text file :

![blockk](https://user-images.githubusercontent.com/66273172/228578726-9c54d287-66ba-4455-8f2b-ad928c47c2e6.png)
#### second output text file :
![vsiitexp](https://user-images.githubusercontent.com/66273172/232833952-9a58f038-8c82-48f8-bdca-950b68de07a3.png)
### final step :
- when you run the output from second steps it will generate an HTML file with highlighted red, green and orange lines as program output
![Screenshot 2023-04-18 174011](https://user-images.githubusercontent.com/66273172/232834978-bedeadeb-4baf-4490-8339-00c5d92f9080.png)

### note:

+ Green lines are highlighted for visited lines.

+ Orange lines are highlighted for branches (if/else/for/while) if the boolean expression has more than one condition, like a || b, and the first condition always  evaluate to true, this means that the second condition b never executed.

+ Red lines are highlighted for not visited lines.

## Team members

- yousef ahmed
- mostafa fathy
- marsellino medhat
- yousef hassan
- mohammed nabil

