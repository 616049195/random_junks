
## main ##

count = 0

if count == 0
	puts "HI"
end

puts "HELLO" if count == 0

count = 5

while count != 0
	puts "How many times?"
	puts "Count #{count} times."
	count = count - 1
end


count = 5

# puts "Count from 10 to 0." while count > 0 


aString = "HELLO"
puts aString
puts aString[0]


# patterns #


puts /Perl|Python/

puts "-----------"
puts "Block and Iteration"
puts "-----------"

def callBlock
  yield
  yield
end

def callLots
	yield
	yield
	yield
end


callBlock { puts "In the block" }
callLots { puts "In the lots" }


a = %w( dog cat frog mice koala monkey duck )
a.each { |e| puts e }
a.each { |s| puts s+"s" }

