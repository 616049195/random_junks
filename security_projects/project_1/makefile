all:
	make SecureSystem.zip

clean:
	rm -f *.class

log:
	git log > project1.log

SecureSystem.zip:

compile: 
	javac SecureSystem.java

compile-all:
	javac *.java

run: SecureSystem.java instruction_sample.txt
	java SecureSystem instruction_sample.txt

