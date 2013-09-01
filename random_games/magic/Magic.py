"""
# credit goes to: HK
# created on 2014.08.17
# status: semi-done
"""

from random import randint

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
