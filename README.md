# DownloadManager
## Table of contents
* [About](#about)
* [Technologies](#technologies)
* [Features](#features)
* [Status](#status)

## About
A download manager with graphical user interface using Java with JavaFX library, built for learning purpouses.

## Technologies
* [Java](#java)
* [JavaFX](#java)
* [Maven](#maven)

## Features
Download Manager provies four main activities for a user: download a file from a given url,  pause download, cancel download, and resume paused files.

### Download a file
This functionality enables user to download a file from url which he inserted into field, user needs to choose extension. After clicking on the button download starts.
In case of wrong url, or any problem on download logic side will occure (ie. connecion timeout, no file to download, server error) user will be informed with appropriate
message, and download will not start. Progress of a download is represented by progress bar binded to progress property of a task taking care of downloading, and by status
of downloading(awaiting, downloading, paused, canceld). Awaiting status is set to files in queue to download pool (number of simultaneous downloads which executor service 
can handle is set programmatically ).

### Pause download
After hitting pause button thread handling download operation is stopped, transfer channel is closed, and information about url and filename are stored in a file prepared for
that. Paused files are loaded into GUI on startup if present and ready to be resumed.

### Cancel download
Thread taking care of this ile is stopped and file is deleted.

### Resume download
User can resume paused files, in such case program will check if file still exists in downloads folder, if so, it will ask under saved url for respose in range of current size.
If no errors download will start. 

## Status
Finnished.
(In future only functionality of choosing download directory will be added).
