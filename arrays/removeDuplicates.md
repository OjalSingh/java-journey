#Remove duplicates:

Using *2 pointer* approach to remove duplicates in a sorted array

->Here, I initialized a seperate index variable *newpos* apart form *i* which I used as iterator.
->The newpos was a slow pointer which only moved when duplicates didnt exist to let the current element be and move on to next.
-> If the first element of the array doesnt match with any other, leave it at zero 1