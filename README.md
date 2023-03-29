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
program run that shows which blocks are visited).
the file should look like this

 block number 1 is visited

 block number 3 is visited
#### modified java file :
![3aaaaaaaaaaa](https://user-images.githubusercontent.com/66273172/228578719-553d9a61-ff09-4388-b913-3ff1b94e306e.png)
#### output text file :

![blockk](https://user-images.githubusercontent.com/66273172/228578726-9c54d287-66ba-4455-8f2b-ad928c47c2e6.png)
