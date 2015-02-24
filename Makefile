all: compile run

compile: *.java ; javac $?
run: *Client.java ; java $?
clean: *.class *.java~ ; rm -rf $?
