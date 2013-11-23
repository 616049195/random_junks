class Security
	# number of officers available
	@@officers = 10

	def initialize (pay)
		@rank = 1 if pay <= 5
		@rank = 2 if pay > 5
		@rank = 3 if pay > 10
		@rank = 4 if pay > 20
		@rank = 5 if pay > 30
		@rank = 0 if pay > 100

	end


	def openDoor ()
		@secured = false
		puts "Door is opened."
	end

	def closeDoor ()
		@secured = true
		@alarm_on = false
		puts "Door is closed."
	end

	def soundAlarm ()
		@alarm_on = true
		puts "ALARM!"
		@@officers -= 1 if @@officers > 0
		alarm()
	end

	def offAlarm ()
		@alarm_on = false
		@@officer += 1
	end
	
	def status ()
		puts "Secured: #{@secured}"
		puts "Alarm is on: #{@alarm_on}"
	end

	def alarm ()
		s = 1 if @rank == 1
		s = 3 if @rank == 2
		s = 5 if @rank == 3
		s = 7 if @rank == 4
		s = 10 if @rank == 5
		s = 20 if @rank == 0


		while s > 0 do
			puts "---------\ncode:RED\n---------"
			s -= 1
		end
	end
end



class House
	include Security

	def initialize (doors)
		@doors = doors
	end
	
end




## main ##

house_1 = Security.new(1)
house_1.openDoor()
house_1.soundAlarm()
house_1.closeDoor()
house_1.status

house_1.openDoor
house_1.status
house_1.soundAlarm



puts "Done."
