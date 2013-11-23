## main ## 

# string

str = "ABCDE"
print str[0], str[1], str[2], str[3], str[4] + "\n"

puts str.empty?


# number

dec = 1234
oct = 01234
hex = 0x1234
float = 2e10

puts dec, oct, hex, float
puts dec.zero?
puts oct.abs


# range

r1 = 0...3
puts r1 # should be from 0~2

r2 = 0..3
puts r2 #should be from 0-3

r3 = 0..3

r4 = 1...3

puts r1 == r2 # should be false
puts r1.eql? r2 # should be false
puts r2.eql? r3 # should be treu

puts "---------------"

puts r1 === 2 # true
puts r1.include?(2) # true
puts r2 === 0.0000001 # true
puts r2.include?(r4) # false
puts r2.member?(1.22222) # true

# .member? and .include? functions do not take ranges as their parameters!


# array

emptyArray = []
another_empty = Array.new
# .member? and .include? functions do not take ranges as their parameters!
