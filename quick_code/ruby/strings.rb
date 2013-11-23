def good_night (name) 
result = "Good night, " + name + "."
puts result
end

def good_night_2 (name) 
	result = "Have a good night, " + name + "."
	return result
end

def good_night_3 (name) 
	result = "Gnight, #{name}."
	return result
end

def good_night_4 (name) 
	"Go to sleep, #{name}."
end



## main ##
good_night("Daniel")
good_night('Jeremy')

puts good_night_2("Harold")
puts (good_night_2('Bob'))
puts (good_night_2 'Jack')
puts good_night_2 'Nate'

puts good_night_3("John")
puts good_night_3('Gerrard')

puts good_night_4('Joe')
puts good_night_4 'Ellie'
