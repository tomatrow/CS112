#!/usr/local/bin/fish
set SRC_DIR $PWD/src
set BLD_DIR $PWD/bld
set SRC_FILES $SRC_DIR/*.java

set MAIN_CLASS Chapter08Project05.java
set BASE_MAIN (basename $MAIN_CLASS .java)

if test $argv = "build" 
    echo Building
    javac -d $BLD_DIR $SRC_FILES
	codemark $SRC_DIR/$MAIN_CLASS $SRC_FILES > $BLD_DIR/$BASE_MAIN.md
else if test $argv = "run"
    echo Running 
    java -cp $BLD_DIR $BASE_MAIN
else if test $argv = "shoot"
	echo Shooting 
	screencapture -w $BLD_DIR/$BASE_MAIN.png 
else if test $argv = "init"
	echo Initializing
	mkdir $SRC_DIR
	mkdir $BLD_DIR
	touch README.md
end