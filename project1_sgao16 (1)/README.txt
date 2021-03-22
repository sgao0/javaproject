Shen Gao
02/24/21
Project 1

	At the beginning of my code, I create a while loop because we don't know how many times it should iterate until we entered "q". And this also leads to my if and else statement. For my code, I first wrote if the input is not "q", I have to check whether there is tag sign <r> in the input, so I wrote another if statement. If it has tag signs, it is important to count the number of it because it tells us the number of iteration we need to replace the tag parts. Then, in the for loop, I created 2 strings of tagPart to show from where to where is the area we need to replace the digit or letter to asterisks. The reason I create 2 strings is that one of them, tagPart, is the one I made changes and the other one is just the duplication of the original one. My idea is to take the tagPart out of the strings and only make changes on this part first, and then replace the original tagPart1 with the new tagPart. 
	For this version, I tried multiple inputs, there is no bug for now. But for my previous version, I met some problems like the code only replace my first tag part instead of the other. So later I add the count to make it iterates and it works well. 
