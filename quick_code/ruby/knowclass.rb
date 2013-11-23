class Rectangle

	def initialize () 
		@length = 0
		@breadth = 0
	end

	def initialize (len, brth)
		@length = len
		@breadth = brth
	end

	def perimeter
		2 * (@length + @breadth)
	end

	def area ()
		return @length*@breadth
	end

end

class Life
	# initialize
	def initialize (age, gender)
		@age = age
		@gender= gender
	end

	def print ()
		puts "You are #{@age} years old #{@gender.capitalize!}."
	end

end

## main ##

# rectangle
rec = Rectangle.new(2, 4)
puts rec.perimeter
puts rec.area
puts rec.area()


# Life
life1 = Life.new(24, "male")
life1.print

# default constructor still exist?
# life2 = Life.new() # no

