#!/usr/bin/env fish

set SRC_DIR $PWD/src
set BLD_DIR $PWD/bld
set SRC_FILES $SRC_DIR/*.java
set PROJECT_NAME (basename $PWD)
set HELPER_CLASSES_DIR /Users/ajcaldwell/Dropbox/School/14/Spring2014/CS112/Classes

set MAIN_CLASS $PROJECT_NAME.java

if test -e $SRC_DIR -a -e $BLD_DIR # make sure project is initialized
	if test $argv = "build" 
		javac -d $BLD_DIR -sourcepath $HELPER_CLASSES_DIR $SRC_FILES
		codemark $SRC_DIR/$MAIN_CLASS $SRC_FILES > $BLD_DIR/$PROJECT_NAME.md
	else if test $argv = "run"
	    java -cp $BLD_DIR:$HELPER_CLASSES_DIR $PROJECT_NAME
	else if test $argv = "shoot"
		screencapture -w $BLD_DIR/$PROJECT_NAME.png 
	else if test $argv = "init"
		mkdir $SRC_DIR
		mkdir $BLD_DIR
		touch README.md
	end
end 