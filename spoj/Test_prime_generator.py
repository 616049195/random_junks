#!/usr/bin/env python

# -------
# imports
# -------

import StringIO
import unittest

from prime_generator import get_input

# -----------
# TestCollatz
# -----------

class Test_prime_generator (unittest.TestCase) :
    # ----
    # read
    # ----

    def test_input (self) :
        r = StringIO.StringIO("10 20\n")
        p = get_input(r)
        (i, j) = p.next()
        self.assert_(i == 10)
        self.assert_(j == 20)


    # ----
    # eval
    # ----

    def test_eval_1 (self) :
        v = collatz_eval((1, 10))
        self.assert_(v == 20)


    # -----
    # print
    # -----

    def test_print (self) :
        w = StringIO.StringIO()
        collatz_print(w, (1, 10), 20)
        self.assert_(w.getvalue() == "1 10 20\n")

    # -----
    # solve
    # -----

    def test_solve (self) :
        r = StringIO.StringIO("1 10\n100 200\n201 210\n900 1000\n")
        w = StringIO.StringIO()
        collatz_solve(r, w)
        self.assert_(w.getvalue() == "1 10 20\n100 200 125\n201 210 89\n900 1000 174\n")

# ----
# main
# ----

print "Test_prime_generator.py"
unittest.main()
print "Done."