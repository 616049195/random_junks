all:
	make SecureSystem.zip

diff: SecureSystem.java instructionList Sample_Output 
	java SecureSystem instructionList > output.tmp
	diff output.tmp Sample_Output
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

