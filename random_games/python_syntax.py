""" 
Python syntax...
"""
# list comprehension
	
## syntax
new_list = [x for x in range(1,6)]
# => [1, 2, 3, 4, 5]
##

## examples
even_squares = [x**2 for x in range(1,11) if (x)%2 == 0]


## 


# dictionary


my_dict = {
    'name' : "Hyunchel",
    'age' : 23,
    'citizenship' : "Republic of Korea"
}

print my_dict.keys()
print my_dict.values()

for key in my_dict:
    print key, my_dict[key]

#


# list slicing

## syntax
[start:end:stride]
same with range() syntax.
[inclusive: exclusive: inclusive]

# if you omit, you can default value [first:last:1]

# negative values change direction (reverse...)

##

l = [i ** 2 for i in range(1, 11)]
# Should be [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

print l[0:9:2]

## omitting
my_list = range(1, 11) # List of numbers 1 - 10

# Add your code below!
print my_list[::2]
##

## reverseing
my_list = range(1, 11)

# Add your code below!
backwards = my_list[::-1]
print backwards
##



# lambda

## syntax
# lambda variable: expression
##


squares = [x**2 for x in range(1, 11)]

print filter(lambda x: x >= 30 and x <= 70, squares)

#

## file i/o


#----__enter__() and __exit__() invocation "with" and "as" syntax
#syntax
with open("file", "mode") as variable:
   # Read or write to the file
#

#### "variable" is created for good. it can be used after the statement. ###

#examples
with open("text.txt", "w") as textfile:
	textfile.write("Success!")
#


#_---- File's memeber variable "closed" is set to True/False depending the file's open status
with open("text.txt", "r+") as my_file:
    my_file.write("HONEY")
    
if not my_file.closed:
    my_file.close()

print my_file.closed

#
##