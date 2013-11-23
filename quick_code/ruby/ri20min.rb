#!/usr/bin/env ruby

class MegaGreeter
	attr_accessor :names

	# Create the object
	def initialize(names = "World")
		@names = names
	end
	
	# Say hi to everyone
	def say_hi
		if @names nil?
			puts "..."
		elsif @names.respond_to?("each")
			# @names is a list of some kind, iterate!
			@names.each do |name|
				puts "Hello #{name}!"
			end
		else
			puts "Hello #{@names}!"
		end
	end

	# Say bye to everybody
	def say_bye
		if @name.nil?
			puts "..."
		elsif @names.respond_to?("join")
			# Join the list elements with commas
			puts "Goodbye #{@names.join(", ")}. Come back later!"
		else
			puts "Goodbye #{@names}. Come back soon!"
		end
	end
end

if __FILE__ == #0
	g = MegaGreeter.new
	g.say_hi
	g.say_bye

	# Change name to be "Zeke"
	g.names = "Zeke"
	g.say_hi
	g.say_bye

	# Change the name to an array of names
	g.names = ["Albert", "Beth", "Daniel", "Jeremy", "David", "Ellis"]
	g.say_hi
	g.say_bye

	# Change to nl
	g.names = nil
	g.say_hi
	g.say_bye
end

