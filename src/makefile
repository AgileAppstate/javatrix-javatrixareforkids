# makefile 
#
# Javatrix project

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher

default: 
	@echo "usage: make target"
#	@echo "5 available targets: clean - removes editor tmpfiles and .class files"
#	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
#	@echo "____________________ defchk, customchk - default or custom checkstyle"
#	@echo "Just starting with make? Try these 4 make commands successively:"
#	@echo "________ make clean ; make compile ; make test ; make defchk"
	@echo "example: make compile"
	@echo "example: make test"
	@echo "example: make clean"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

compile: MatrixTest.java matrix/Matrix.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) MatrixTest.java
	javac matrix/Matrix.java

clean:
	rm -f *~
	rm -f Matrix*.class
	rm -f matrix/Matrix*.class
 
# help:
# 	@echo "Just starting with make? Try these 4 make commands successively:"
# 	@echo "________ make clean ; make compile ; make test ; make defchk"

# targetlist:
# 	@echo "7 available targets: clean - removes editor tmpfiles and .class files"
# 	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
# 	@echo "____________________ defchk, customchk - default or custom checkstyle"
# 	@echo "____________________ help, targetlist - just starting commands, list available targets"

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 
