#!/usr/local/bin/fish
set SRC_DIR $PWD/src
set BLD_DIR $PWD/build
set PREV_PROB_SRC_DIR $PWD/Chapter08Project02/src
set MAIN_CLASS Chapter08Project03

if test $argv = "build" 
	echo Building
	javac -d $BLD_DIR $SRC_DIR/*.java $PREV_PROB_SRC_DIR/*.java
else if test $argv = "run"
	echo Running 
	java -cp $BLD_DIR $MAIN_CLASS
end
