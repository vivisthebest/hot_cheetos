all: compile

compile: *.java ; javac $?
clean: *.class *.java~ ; rm -rf $?
