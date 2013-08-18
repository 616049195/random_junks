from random import randint # for Magic class

class Player(object):
	_name = ""
	_age = -1
	_gender = ""

	def welcome(self):
		"""Welcomes our users"""
		print "Welcome to Magic #1."
		print "This is a little trick for kids under age 8."
		# blahblahblah

	def get_info (self):
		""" Ask and store user's data """
		self._name = raw_input("What is your name?")
		self._age = int(raw_input("Tell me your age:"))
		self._gender = raw_input("Are you male or female?")

class Magic(object):
	""" does the magic"""
	number = 0
	ran_num = 0

	def intro(self):
		print "Choose a number between 1 and 10."
		
		wait = True
		while (wait):
			if raw_input("Once you are done, enter \"YES\": ").lower() == 'yes':
				wait = False
	
	def doing_magic(self):
		""" asks the user to add a randomized number """
		self.ran_num = randint(1,10)
		self.number += self.ran_num
		print "Add %s to your number." % (self.ran_num)

	def show_magic(self):

		_sum = int(raw_input("What is your sum?: "))
		print "Your number was %s" % (_sum - number)

	def start(self):
		self.intro()

		for x in range(0, randint(3,7)):
			self.doing_magic()
			raw_input("Once you are done, type ENTER.")
			
		self.show_magic()




user = Player()
user.welcome()
user.get_info()


game = Magic()
game.start()



print "Bye..."
