package com.leetcode.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MethodTimer implements AutoCloseable{
    private final String label;
    private String fileName;
    private final long startTime;
    private double duration;

    public MethodTimer(String label, String fileName){
        this.label=label;
        this.fileName=fileName;
        this.startTime=System.nanoTime();
    }

    public MethodTimer(String label){
        this(label, "target/generated-sources/timed.txt");
    }

    public double getDuration() {
        return duration;
    }

    //duration is in seconds
    @Override
    public void close(){
        long endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000_000.0;
        saveToFile();
    }

    private void saveToFile() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String logEntry = String.format("[%s] %s: %.6f seconds%n", label, timestamp, duration);

        try {
            Files.writeString(Path.of(fileName), logEntry);
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }
    }

}
