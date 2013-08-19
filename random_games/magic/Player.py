"""
# credit goes to: HK
# created on 2014.08.17
# status: semi-done
"""

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



def testing():
	print "works!"