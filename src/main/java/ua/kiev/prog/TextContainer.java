package ua.kiev.prog;

import java.io.*;

@SaveTo(path = "e:\\text2.txt")
public class TextContainer {

    String text = "A new text";


    @Saver
    public void saveToFile(String path) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(path), "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

