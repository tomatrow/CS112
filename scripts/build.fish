#!/usr/bin/env fish

set PROJECT_NAME (basename $PWD)

set HELPER_CLASSES_DIR /Users/ajcaldwell/Dropbox/School/14/Spring2014/CS112/Classes
set HELP_SRC_DIR $HELPER_CLASSES_DIR/src
set HELP_BLD_DIR $HELPER_CLASSES_DIR/bld
set HELP_SRC_FILES $HELP_SRC_DIR/*


set SRC_DIR ./src
set BLD_DIR ./bld

set SRC_FILES $SRC_DIR/*.java
set MAIN_CLASS $PROJECT_NAME.java

set SOURCE_FILE_PATH ./src/source.txt


function masterbuild 
	touch $SOURCE_FILE_PATH
	echo $SRC_FILES > $SOURCE_FILE_PATH
	echo $HELP_SRC_FILES >> $SOURCE_FILE_PATH
	
	if test -e $SRC_DIR -a -e $BLD_DIR # make sure project is initialized
		if test $argv = "build" 
			javac -d $BLD_DIR @$SOURCE_FILE_PATH
			# codemark $SRC_FILES $SRC_DIR/$MAIN_CLASS > $BLD_DIR/$PROJECT_NAME.md
			# echo $SRC_FILES $SRC_DIR/$MAIN_CLASS 
		else if test $argv = "run"
		    java -cp $BLD_DIR:$HELP_BLD_DIR $PROJECT_NAME
		else if test $argv = "shoot"
			screencapture -w $BLD_DIR/$PROJECT_NAME.png 
		end
	else if test $argv = "init"
		mkdir $SRC_DIR
		mkdir $BLD_DIR
		touch README.md
		touch $SRC_DIR/$PROJECT_NAME.java
	end 
	echo $status > /dev/null # This is the only solution I found to unwanted statuses being sent to the terminal. 
end 

masterbuild $argv
