#!/usr/bin/env fish

set PROJECT_NAME (basename $PWD)

set HELPER_CLASSES_DIR /Users/ajcaldwell/Dropbox/School/14/Spring2014/CS112/Classes
set HELP_SRC_DIR $HELPER_CLASSES_DIR/src
set HELP_BLD_DIR $HELPER_CLASSES_DIR/bld

set SRC_DIR $PWD/src
set BLD_DIR $PWD/bld

set SRC_FILES $SRC_DIR/*.java
set MAIN_CLASS $PROJECT_NAME.java

if test -e $SRC_DIR -a -e $BLD_DIR # make sure project is initialized
	if test $argv = "build" 
		javac -d $BLD_DIR -sourcepath $HELP_SRC_DIR $SRC_FILES
		codemark $SRC_DIR/$MAIN_CLASS $SRC_FILES > $BLD_DIR/$PROJECT_NAME.md
	else if test $argv = "run"
	    java -cp $BLD_DIR:$HELP_BLD_DIR $PROJECT_NAME
	else if test $argv = "shoot"
		screencapture -w $BLD_DIR/$PROJECT_NAME.png 
	end
end 

if test $argv = "init"
	mkdir $SRC_DIR
	mkdir $BLD_DIR
	touch README.md
	touch $SRC_DIR/$PROJECT_NAME.java
end 