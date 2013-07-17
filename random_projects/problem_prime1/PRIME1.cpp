// -------------------------------
// projects/collatz/RunCollatz.c++
// Copyright (C) 2013
// Hyunchel Kim
// -------------------------------

#include <iostream> // cout, cin, etc
#include <cassert> // assert
#include <string>	// for c++string?
#include <vector>	// for vectors

using namespace std;
void prime1_solve (std::istream& r, std::ostream& w) {


	// take number of test cases
	int test_cases;
	r >> test_cases;


	vector<int> saved_num(20, 0);
	int m;
	int n;
	string number;
	r.ignore();
	//loop begins
	while (test_cases != 0)
	{
		
		// take in the set of domains
		// getline(r, number);
		r >> m;
		r.ignore();
		r >> n;
		r.ignore();

		// assert(1 <= n && m < n && n < 1000000000 && (n-m) <= 100000);
		assert(1 <= n);
		// assert(m < n);
		assert(n < 1000000000);
		assert((n-m) <= 100000);


		cout << "number: " << number << endl;
		cout << "num1: " << m << endl;
		cout << "num2: " << n << endl;
		--test_cases;
	}
	//loop ends

	//calculate
	int factor = 2;
	int new_factor = 0;
	for (m; m<n+1; ++m)
	{
		new_factor= m % factor;
		if (!new_factor)
		{

		}
		cout << "M : " << m << endl;
	}

	//print
	cout << "HELLO! all done? \n";
}

int main () {
	using namespace std;
	prime1_solve(cin, cout);
	return 0;
}
