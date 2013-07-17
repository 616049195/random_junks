// -------------------------------
// fun_projects/TEST.c++
// Copyright (C) 2013
// Hyunchel Kim
// -------------------------------

#include <iostream> // cout, cin, etc
#include <vector> // need vector
#include <string>

void test_solve (std::istream& r, std::ostream& w){
	using namespace std;

	std::vector<string> vector_saved;
	vector<string>::iterator myIterator;

	string given;

	// first input = exception
	getline(cin, given);

	// save
	while (given != "")
	{
		vector_saved.push_back(given);
		getline(cin, given);	
	}

	// print
	for (myIterator=vector_saved.begin(); myIterator != vector_saved.end(); ++myIterator)
	{
		if (*myIterator == "42")
			break;
		cout << *myIterator << endl;
	}
}

int main () {
	using namespace std;
	test_solve(cin, cout);
	return 0;
}