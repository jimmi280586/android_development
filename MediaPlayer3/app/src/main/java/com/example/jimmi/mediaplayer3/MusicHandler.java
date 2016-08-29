package com.example.jimmi.mediaplayer3;

import java.io.File;
import java.util.ArrayList;
import android.app.Activity;
import android.widget.LinearLayout;


public class MusicHandler extends Activity {


        private ArrayList<File> fileList = new ArrayList<File>();
        private LinearLayout view;

        public ArrayList<File> getfile(File dir) {
            //creates array with all folders in root directory
            File listFile[] = dir.listFiles();
            //only checs folders with files in
            if (listFile != null && listFile.length > 0)
            {
                //checs all files in folder
                for (int i = 0; i < listFile.length; i++)
                {
                    //this is more complicated if the file it checs is a folder it adds it to the list it is curently goving thrue
                    //this is alowed as i is one bigger then the one it uses
                    if (listFile[i].isDirectory()) {
                        fileList.add(listFile[i]);
                        getfile(listFile[i]);

                    }
                    else {
                        //alows only files with these endings to be alowed in list
                        if (listFile[i].getName().endsWith(".mp3")
                                || listFile[i].getName().endsWith(".mp4")
                                || listFile[i].getName().endsWith(".Mp3")
                                || listFile[i].getName().endsWith(".mp3"))

                        {
                            //adds to list
                            fileList.add(listFile[i]);
                        }
                    }

                }
            }
            return fileList;
        }

    }

