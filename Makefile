all: compile

compile: *.java ; javac $?
clean: *.class ; rm -rf $?
