# having fun with ruby
puts "Hello, this is just me fooling around with syntax."

name = gets.chomp.capitalize!

puts "You name is #{name}, yes or no?"

test = gets.chomp

puts "Okay." if test.capitalize! == "Yes"

puts "How old are you? "
age = gets.chomp

if age < '17'
	puts "Under age, kicking you out in 10 seconds."
end
