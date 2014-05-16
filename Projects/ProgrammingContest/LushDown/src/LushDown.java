/*
File Name:          LushDown.java
Programmer:         Andrew Caldwell
Date Last Modified: April. 27, 2014
Problem Statement:
	Make a markdown editor with features: 
		Open files
		Save files 
		Live preview
		Upload ("Cloud")
		Persistance

Overall Plan:
	Model: 
		Markdown Parser
		Paste Bin Uploader
	View: 
		Rootpane
			ToolBar Pane
			Duel Pane 
				Editor Pane 
				Preview Pane
	Controller:
		MainPanel

Classes needed and Purpose:
	Main Class        - LushDown
	MarkdownParse     - converts markdown to html 
	LushNameValuePair - immutable ecapsulation of request arguments 
	PasteBinUpload    - takes markdown and returns a link 
	ToolBarPane       - holds buttons: toggleHtml, openFile, uploadMarkdown, saveFile	
	EditorPane        - edits markdown
	PreviewPane       - displays html 
	MainPanel         - Glues everything together
*/

/*
Features Skipped for the Sake of Lines and Time
	* clarity
	* bug-freeness
	* correctly encoded paste bin text. I've never done web stuff before. 
	* multi-level lists 
*/

public class LushDown {
	public static void main(String[] args) {
		MainPanel mainWindow = new MainPanel();
	}
}