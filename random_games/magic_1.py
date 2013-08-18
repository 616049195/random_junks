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
	number = -1

	def intro(self):
		print "Choose a number between 1 and 10."
		self.number = int(raw_input("Once you are done, enter the number: "))



user = Player()
user.welcome()
user.get_info()

# print "%s %s %s" % (user._name, user._age, user._gender)


# game = Magic()






print "Bye..."
