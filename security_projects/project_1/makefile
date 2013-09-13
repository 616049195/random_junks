all:
	make SecureSystem.zip

diff: SecureSystem.java instructionList Test_Output 
	java SecureSystem instructionList > output.tmp
	diff output.tmp Test_Output
	rm output.tmp

clean:
	rm -f *.class

log:
	git log > project1.log

SecureSystem.zip:

compile: 
	javac SecureSystem.java

compile-all:
	javac *.java

run: SecureSystem.java instructionList
	java SecureSystem instructionList

