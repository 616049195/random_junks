"""
# credit goes to: HK
# created on 2014.08.17
# status: semi-done
"""


from random import randint # for Magic class

class Player(object):
	_name = ""
	_age = -1
	_gender = ""

	def welcome(self):
		"""Welcomes our users"""
		print "\nWelcome to Magic #1."
		print "This is a little trick for kids under age 8."
		print "Let the magic begin!\n"
		self.get_info()

	def get_info (self):
		""" Ask and store user's data """
		self._name = raw_input("What is your name? ")
		self._age = int(raw_input("Tell me your age: "))
		self._gender = raw_input("Are you Male or Female? ")

class Magic(object):
	""" does the magic"""
	number = 0
	ran_num = 0

	def intro(self):
		print "\nChoose a number between 1 and 10."
		
		wait = True
		while (wait):
			if raw_input("Once you are done, enter \"YES\": ").lower() == 'yes':
				wait = False
	
	def doing_magic(self):
		""" asks the user to add a randomized number """
		self.ran_num = randint(1,10)
		self.number += self.ran_num
		print "\nAdd %s to your number." % (self.ran_num)

	def show_magic(self):

		_sum = int(raw_input("What is your sum?: "))
		self.number = _sum - self.number
		print "\nYour number was %s" % (self.number)

	def start(self):
		self.intro()

		for x in range(0, randint(3,7)):
			self.doing_magic()
			raw_input("Once you are done, type ENTER.")
			
		self.show_magic()



# create a user and invoke welcome.
user = Player()
user.welcome()

# create a Magic class and invoke
game = Magic()
game.start()



print "\nGood Bye...\n"
