package org.msu.adiesha.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInput {

    public static class SourceAndTarget {
        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        private String source;
        private String target;


    }

    public static SourceAndTarget readInput(String filename) {
        SourceAndTarget targetDTO = new SourceAndTarget();


        try {
            File readFile = new File(filename);
            Scanner reader = new Scanner(readFile);
            while (reader.hasNextLine()) {
                String source = reader.nextLine();
                String target = reader.nextLine();
                targetDTO.setSource(source);
                targetDTO.setTarget(target);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Exception");
            throw new RuntimeException(e);
        }

        return targetDTO;
    }
}
