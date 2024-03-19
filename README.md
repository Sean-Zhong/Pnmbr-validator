# Pnmbr-validator
Takes a list of Personal numbers from input.csv and returns the types of numbers and their validity in output.csv.

## Prerequisites
- Java installation - (openjdk 11.0.22 was used for this project)

## Instructions
1. Provide a list of personalnumbers to be validated in input.csv (the test data from the pdf is in there by default)
2. Compile PnmbrValidator.java by entering ```javac com/seanzhong/pnmbrvalidator/PnmbrValidator.java``` in terminal/cmd
3. Execute PnmbrValidator.java by entering ```java com/seanzhong/pnmbrvalidator/PnmbrValidator.java``` in terminal/cmd
4. The results will be present in output.csv

## Thought Process
I broke down the problem into the following steps,

for each number in the input list:
1. Validate input format
2. Detect number type based on the provided criteria
3. Based on which number type, validate the number type by using a strategy design pattern
4. Provide information about the number and its validity
5. Log errors along the way

## Improvements
If I had more time I would have liked to package the project in a executable jar file and look into the java package structure more. I would like to separate the .class files into a separate directory other than inside my code directory.
